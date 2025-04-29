package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.GetBoardDetailService;
import com.crewrung.board.vo.BoardDetailVO;

public class updateBoardUIAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
    	   // 1) boardNumber 파라미터 유효성 검사
        String noParam = request.getParameter("boardNumber");
        if (noParam == null || !noParam.matches("\\d+")) {
            // 잘못된 접근이면 목록으로 되돌아가기
            return "redirect:controller?cmd=boardsUI";
        }
        long boardNumber = Long.parseLong(noParam);

        // 2) 서비스 호출: 게시글 상세 가져오기
        BoardDetailVO board = new GetBoardDetailService().execute((int) boardNumber);
        // 3) request 에 담기
        request.setAttribute("board", board);

        // 4) 수정 폼 JSP로 포워딩
        return "/updateBoardUI.jsp";
    }
}
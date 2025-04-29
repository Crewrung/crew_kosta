package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crewrung.board.service.UpdateBoardService;
import com.crewrung.servlet.Action;
import com.crewrung.board.vo.BoardVO;

// detailBoardUIAction import
import com.crewrung.board.action.detailBoardUIAction;

public class updateBoardAction implements Action {
    @Override
    public String execute(HttpServletRequest request)
            throws ServletException, IOException {

        // 1) 파라미터 파싱
        long boardNumber = Long.parseLong(request.getParameter("boardNumber"));
        String writerId  = request.getParameter("writerId");
        String title     = request.getParameter("title");
        String content   = request.getParameter("content");

        // 2) VO 생성 & 서비스 호출
        BoardVO vo = new BoardVO();
        vo.setBoardNumber((int) boardNumber);
        vo.setWriterId(writerId);
        vo.setTitle(title);
        vo.setContent(content);
        new UpdateBoardService().execute(vo);

        // 3) 수정 후 바로 상세보기로 “포워드” 
        //    FrontController가 또 cmd=detailBoardUIAction을 부르는 게 아니라,
        //    이곳에서 Detail 로직을 직접 호출합니다.
        detailBoardUIAction detailAction = new detailBoardUIAction();
        // 내부에서 board, commentsList, etc.를 request에 세팅하고
        // "/detailBoardUI.jsp"를 리턴하도록 실행
        return detailAction.execute(request);
    }
}
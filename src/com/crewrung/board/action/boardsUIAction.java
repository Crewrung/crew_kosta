package com.crewrung.board.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.GetAllBoardsService;
import com.crewrung.board.vo.BoardVO;

public class boardsUIAction implements Action {
	 private static final int PAGE_SIZE = 15;
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 1) DB에서 전체 게시글(이미 board_number DESC 정렬됨) 가져오기
        List<BoardVO> allBoards = new GetAllBoardsService().execute();

        // 2) 요청 파라미터로 현재 페이지 계산
        String p = request.getParameter("page");
        int currentPage = 1;
        if (p != null && p.matches("\\d+")) {
            currentPage = Integer.parseInt(p);
        }

        // 3) 페이징 계산
        int totalCount = allBoards.size();
        int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);

        int startIdx = (currentPage - 1) * PAGE_SIZE;
        int endIdx   = Math.min(startIdx + PAGE_SIZE, totalCount);

        // 4) 한 페이지 분량만 잘라서 전달
        List<BoardVO> pageList = allBoards.subList(startIdx, endIdx);

        // 5) JSP에 속성 세팅
        request.setAttribute("boards",       pageList);
        request.setAttribute("currentPage",  currentPage);
        request.setAttribute("totalPages",   totalPages);
        
        HttpSession ServerSession = request.getSession(false); // 기존 세션만 가져옴 (없으면 null)
        String userId = null;
        if (ServerSession != null && ServerSession.getAttribute("userId") != null) {
        	userId = (String) ServerSession.getAttribute("userId");
        }

        // 6) 뷰 리턴
        return "board/boardsUIAction.jsp";
    }
}
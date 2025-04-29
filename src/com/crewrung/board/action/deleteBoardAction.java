package com.crewrung.board.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.DeleteBoardService;
import com.crewrung.board.service.GetAllBoardsService;
import com.crewrung.board.vo.BoardVO;

public class deleteBoardAction implements Action {

    // boardsUIAction과 동일한 페이지 크기
    private static final int PAGE_SIZE = 15;

    @Override
    public String execute(HttpServletRequest request)
            throws ServletException, IOException {

        // 1) 삭제 파라미터 읽기
        int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
        String writerId = request.getParameter("writerId");
        System.out.println("sdad");
        // 2) 삭제 서비스 호출
        new DeleteBoardService().execute(boardNumber, writerId);

        // 3) 삭제 후 전체 게시글 목록 조회
        List<BoardVO> allBoards = new GetAllBoardsService().execute();

        // 4) 페이징 계산 (현재 페이지는 파라미터 있으면 사용, 없으면 1)
        int currentPage = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        } catch (Exception ignored) { }
        int totalCount = allBoards.size();
        int totalPages = (int) Math.ceil(totalCount / (double) PAGE_SIZE);
        int startIdx = (currentPage - 1) * PAGE_SIZE;
        int endIdx   = Math.min(startIdx + PAGE_SIZE, totalCount);
        List<BoardVO> pageList = 
            (startIdx < totalCount) 
            ? allBoards.subList(startIdx, endIdx) 
            : allBoards.subList(0, Math.min(PAGE_SIZE, totalCount));

        // 5) JSP에 목록·페이징 정보 세팅
        request.setAttribute("boards",      pageList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages",  totalPages);

        // 6) boardsUIAction.jsp 로 포워드
        return "board/boardsUIAction.jsp";
    }
}


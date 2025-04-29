package com.crewrung.board.action;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.GetBoardDetailService;
import com.crewrung.board.service.IncrementViewService;
import com.crewrung.board.service.GetAllCommentsService;
import com.crewrung.board.vo.BoardCommentListVO;
import com.crewrung.board.vo.BoardDetailVO;

public class detailBoardUIAction implements Action {

    private static final int PAGE_SIZE = 10;  // 예시

    @Override
    public String execute(HttpServletRequest request)
            throws ServletException, IOException {
        // 1) 진입 파라미터에서 boardNumber, writerId 읽기
        int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
        String writerId = request.getParameter("writerId");

        // 2) 조회수 증가
        new IncrementViewService().execute(boardNumber);

        // 3) 상세조회
        BoardDetailVO board = new GetBoardDetailService().execute(boardNumber);

        // 4) 댓글 전체 조회
        List<BoardCommentListVO> allComments =
            new GetAllCommentsService().execute(boardNumber);

        // 5) 페이징 계산 (예시)
        int currentPage = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        } catch (Exception e) { /* 기본값 1 유지 */ }
        int totalCount = allComments.size();
        int totalPages = (int)Math.ceil(totalCount / (double)PAGE_SIZE);
        int start = (currentPage - 1) * PAGE_SIZE;
        int end   = Math.min(start + PAGE_SIZE, totalCount);
        List<BoardCommentListVO> pageComments =
            start < totalCount ? allComments.subList(start, end) : Collections.emptyList();

        // 6) JSP로 넘기기
        request.setAttribute("board",         board);
        request.setAttribute("writerId",      writerId);       // ← 추가
        request.setAttribute("commentsList",  pageComments);
        request.setAttribute("currentPage",   currentPage);
        request.setAttribute("totalPages",    totalPages);

        return "board/detailBoardUI.jsp";
    }
}

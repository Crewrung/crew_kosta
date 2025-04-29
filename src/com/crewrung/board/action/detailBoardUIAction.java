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
    private static final int PAGE_SIZE = 3;

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 1) boardNumber 파라미터
        String no = request.getParameter("boardNumber");
        if (no == null || !no.matches("\\d+")) {
            return "redirect:controller?cmd=boardsUI";
        }
        long boardNumber = Long.parseLong(no);

        // 2) 게시글 상세 + 조회수 증가
        BoardDetailVO board = new GetBoardDetailService().execute((int) boardNumber);
        new IncrementViewService().execute((int) boardNumber);
        request.setAttribute("board", board);

        // 3) 전체 댓글 조회
        List<BoardCommentListVO> allComments = new GetAllCommentsService().execute();
        if (allComments == null) allComments = Collections.emptyList();
        int totalCount = allComments.size();

        // 4) 페이지 파라미터
        String p = request.getParameter("page");
        int currentPage = (p!=null && p.matches("\\d+")) ? Integer.parseInt(p) : 1;
        int totalPages  = (int)Math.ceil((double) totalCount / PAGE_SIZE);

        // 5) subList
        int start = (currentPage - 1)*PAGE_SIZE;
        int end   = Math.min(start+PAGE_SIZE, totalCount);
        List<BoardCommentListVO> pageComments =
            (start < totalCount) ? allComments.subList(start, end) : Collections.emptyList();

        // 6) JSP 전달 속성
        request.setAttribute("commentsList", pageComments);
        request.setAttribute("currentPage",  currentPage);
        request.setAttribute("totalPages",   totalPages);

        // 7) detailBoardUI.jsp 로 포워딩
        return "/detailBoardUI.jsp";
    }
}

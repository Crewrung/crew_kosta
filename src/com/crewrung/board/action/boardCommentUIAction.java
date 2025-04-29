package com.crewrung.board.action;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.GetAllCommentsService;
import com.crewrung.board.vo.BoardCommentListVO;

public class boardCommentUIAction implements Action {
	private static final int PAGE_SIZE = 3;
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	 // 1) 모든 댓글 조회 (서비스는 파라미터 없이 호출)
        List<BoardCommentListVO> allComments = new GetAllCommentsService().execute();
        if (allComments == null) {
            allComments = Collections.emptyList();
        }
        int totalCount = allComments.size();

        // 2) 페이지 파라미터 계산
        String pageParam = request.getParameter("page");
        int currentPage = 1;
        if (pageParam != null && pageParam.matches("\\d+")) {
            currentPage = Integer.parseInt(pageParam);
        }
        int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);

        // 3) 현재 페이지 댓글만 subList 로 추출
        int startIdx = (currentPage - 1) * PAGE_SIZE;
        int endIdx   = Math.min(startIdx + PAGE_SIZE, totalCount);
        List<BoardCommentListVO> pageComments = Collections.emptyList();
        if (startIdx < totalCount) {
            pageComments = allComments.subList(startIdx, endIdx);
        }

        // 4) JSP에서 사용할 속성 세팅
        request.setAttribute("commentsList", pageComments);
        request.setAttribute("currentPage",  currentPage);
        request.setAttribute("totalPages",   totalPages);

        // 5) 댓글 UI JSP로 포워딩
        return "/boardCommentUI.jsp";
    }
}
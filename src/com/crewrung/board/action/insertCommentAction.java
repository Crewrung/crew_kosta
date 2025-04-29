package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.crewrung.servlet.Action;
import com.crewrung.board.service.InsertCommentService;
import com.crewrung.board.action.detailBoardUIAction;

public class insertCommentAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 1) 요청 파라미터 취득
        int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
        String commenterId = request.getParameter("boardCommenterId");
        String comment     = request.getParameter("boardComment");

        // 2) 서비스 호출 (db에 INSERT)
        new InsertCommentService().execute(boardNumber, commenterId, comment);

        // 3) 등록 후 상세보기로 포워드 (댓글 목록도 함께 세팅됨)
        return new detailBoardUIAction().execute(request);
    }
}

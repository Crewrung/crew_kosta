package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.DeleteBoardService;

public class deleteBoardAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 1) 삭제할 글 번호와 작성자 ID 파라미터로 받기
        int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
        String writerId = request.getParameter("writerId");
        // 2) 삭제 서비스 호출
        new DeleteBoardService().execute(boardNumber, writerId);

        // 3) 삭제 후 게시판 목록으로 리다이렉트
        return "controller?cmd=boardsUI";
    }
}
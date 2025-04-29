package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.board.service.InsertBoardService;

public class uploadboardAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 1) 폼에서 넘어온 writerId, title, content 파라미터 수집
        String writerId = request.getParameter("writerId");//무조건 db에 있는거로해야함
        String title    = request.getParameter("title");
        String content  = request.getParameter("content");

        // 2) 게시글 등록 서비스 호출 (DB에 글만 insert)
        new InsertBoardService().execute(writerId, title, content);

        // 3) 등록 완료 후 게시판 목록으로 리다이렉트
        return "controller?cmd=boardsUI";
    }
}
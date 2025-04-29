package com.crewrung.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class postingUIAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // 단순히 글쓰기 화면 JSP로 포워딩
        return "PostingUI.jsp";
    }
}

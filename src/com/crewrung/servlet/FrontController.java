package com.crewrung.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
    }
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init servlet");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		System.out.println("cmd:" + cmd);
		if(cmd == null) {
			cmd = "mainUI";
		}
		
		Action action = ActionFactory.getAction(cmd);

		String url = action.execute(request);
		
		request.getRequestDispatcher("/" + url).forward(request, response);
		
	}
	
	public void destroy() {
		System.out.println("servlet destory");
	}
}

package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class FindUserPwUIAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "account/findUserPw.jsp";
	}

}

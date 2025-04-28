package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class AddCrewUIAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "addCrew.jsp";
	}
}



package com.crewrung.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class boardsUI implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		return boardsUIAction;
	}

}

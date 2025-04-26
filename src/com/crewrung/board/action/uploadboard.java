package com.crewrung.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class uploadboard implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		return UploadpostAction;
	}

}

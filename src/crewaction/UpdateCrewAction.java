package crewaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class UpdateCrewAction implements Action{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		return "crewDetail.html";
	}

}

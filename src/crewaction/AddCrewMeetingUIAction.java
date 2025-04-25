package crewaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class AddCrewMeetingUIAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		return "addMeeting.jsp";
	}

}

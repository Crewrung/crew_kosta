package crewaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.vo.AllCrewVO;

import com.crewrung.servlet.Action;

public class GetCrewInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		//crewNumber 갖고옴
		int crewNumber = Integer.parseInt(request.getParameter("crewNumber"));
		CrewDAO dao = new CrewDAO();
		//크루에 관한 정보 담기
		request.setAttribute("crew", dao.getCrewDetail(crewNumber));
		//크루 멤버들의 정보
		request.setAttribute("crewMembers", dao.getCrewMember(crewNumber));
		//크루 모임들의 정보
		request.setAttribute("crewMeetings", dao.getCrewMeetingsInfo(crewNumber));
		//댓글 갯수
		request.setAttribute("crewCommentCount", dao.getCommentCount(crewNumber));
		//댓글 정보
		request.setAttribute("crewComments", dao.getCrewCommentDetail(crewNumber));
		return "crewDetailPage.jsp";
	}
}

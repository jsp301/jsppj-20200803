package movie.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import movie.service.WriteMovieService;
import movie.service.WriteRequest;
import mvc.controller.CommandHandler;

public class WriteMovieHandler implements CommandHandler {

	private static final String FORM_VIEW ="/WEB-INF/view/newMovieForm.jsp";
	private WriteMovieService writeService = new WriteMovieService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		//equalsIgnoreCase : 대소문자 구분 없이 비교
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, req);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, req);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	
	private String processForm(HttpServletRequest req, HttpServletRequest req2) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletRequest req2) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		//authUser -> auth->LoginHandler
		//getSession(false) - HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 생성하지 않고 그냥 null을 반환합니다.
		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newMovieNo = writeService.write(writeReq);
		req.setAttribute("newMovieNo", newMovieNo);
		
		return "/WEB-INF/view/newMovieSuccess.jsp";
	}


	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new User(user.getId()),
				req.getParameter("title"),
				req.getParameter("score"),
				req.getParameter("content"),
				req.getParameter("fileName")
				);
	}
	

}

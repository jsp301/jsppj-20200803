package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.controller.CommandHandler;
import reply.sevice.DeleteMessageService;

public class DeleteMessageHandler implements CommandHandler{

	private static final String FORM_VIEW="/WEB-INF/view/readMovie.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, req);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, req);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletRequest req2) {
		HttpSession session = req.getSession();
		String messageIdStr = req.getParameter("contentId");
		int contentId = Integer.parseInt(messageIdStr);
		
		String movId = req.getParameter("movieId");
		int movieId = Integer.parseInt(movId);
		
		DeleteMessageService service = DeleteMessageService.getInstance();
		
		String del = service.deleteMessage(contentId,movieId);
		session.setAttribute("del",del);
		
		
		return "/read.do?no="+String.valueOf(movieId);
		
	}

	private String processForm(HttpServletRequest req, HttpServletRequest req2) {
		return FORM_VIEW;
	}

}

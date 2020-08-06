package reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.controller.CommandHandler;
import reply.model.Message;
import reply.sevice.GetMessageListService;
import reply.sevice.MessageListView;
import reply.sevice.WriteMessageService;

public class WriteMessageHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newContentForm.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		Message message = new Message();
		
		String pageStr = req.getParameter("page");
		int page = 1;
		
		if (pageStr != null) {
			page = Integer.valueOf(pageStr);
		}
		
		GetMessageListService service1 = GetMessageListService.getInstance();
		MessageListView list = service1.getMessageList(page);
		
		
		String score = req.getParameter("score");
		int sco = Integer.parseInt(score);
		String body2 = req.getParameter("content") ;
		

		if (body2 == null || body2.isEmpty()) {
			session.setAttribute("info", "별점, 메시지를 꼭 입력하세요.");
		} else {
			message.setScore(sco);
			message.setContent(body2);
			WriteMessageService service = WriteMessageService.getInstance();
			boolean success = service.write(message);

			if (success) {
				session.setAttribute("info", "메시지가 등록되었습니다.");
			} else {
				session.setAttribute("info", "메시지 등록에 실패하였습니다.");
			}
			req.setAttribute("list", list);	
	}
		return FORM_VIEW;
}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {

		return FORM_VIEW;
	}

}

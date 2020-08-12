package reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.controller.CommandHandler;
import reply.dao.MessageDao;
import reply.model.Message;
import reply.sevice.GetMessageListService;
import reply.sevice.MessageListView;
import reply.sevice.WriteMessageService;

public class WriteMessageHandler implements CommandHandler {
	
	private static final String FORM_VIEW ="/WEB-INF/view/readMovie.jsp";
	
	
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
		Message message = new Message();
		
		String movId = req.getParameter("movieId");
		int movieId = Integer.parseInt(movId);
		String userId = req.getParameter("userId");
		String sco = req.getParameter("score");
		int score =Integer.parseInt(sco);
		String content = req.getParameter("content");
		
//		System.out.println(movId);
//		System.out.println(userId);
//		System.out.println(score);
//		System.out.println(content);
		
		if(content == null || sco==null|| content.isEmpty() || sco.isEmpty() ) {
			session.setAttribute("info", "내용을 꼭 입력하세요");
		}
		else {
		message.setMovId(movieId);
		message.setuId(userId);
		message.setScore(score);
		message.setContent(content);
		WriteMessageService wrs = WriteMessageService.getInstance();
		boolean success = wrs.write(message);
		if (success) {
			session.setAttribute("info", "메시지가 등록되었습니다.");
		} else {
			session.setAttribute("info", "메시지 등록에 실패하였습니다.");
		}
	}
		return "/read.do?no="+String.valueOf(movieId);
}

	private String processForm(HttpServletRequest req, HttpServletRequest req2) {
		
		return FORM_VIEW;
	}

}

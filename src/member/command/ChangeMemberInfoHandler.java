package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangeMemberInfoRequest;
import member.service.ChangeMemberInfoService;
import member.service.MemberData;
import member.service.MemberNotFoundException;
import member.service.ReadMemberService;
import movie.service.MovieNotFoundException;
import mvc.controller.CommandHandler;

public class ChangeMemberInfoHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/view/changePwdForm.jsp";
	
	private ChangeMemberInfoService changeMISerive = new ChangeMemberInfoService();
	private ReadMemberService readService = new ReadMemberService();
		
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		}else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}	
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		try {
			String id = req.getParameter("Id");
			MemberData memberData = readService.getMember(id);
			User authUser = (User) req.getSession().getAttribute("authUser");
			
			ChangeMemberInfoRequest cmiReq = new ChangeMemberInfoRequest(
					authUser.getId(), 
					memberData.getMember().getUserpw(), 
					memberData.getMember().getUserName(),
					memberData.getMember().getUserGender(),
					memberData.getMember().getUserEmail());
			req.setAttribute("cmiReq", cmiReq);
			return FORM_VIEW;
			
		} catch (MovieNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		User authUser = (User) req.getSession().getAttribute("authUser");
		String id = req.getParameter("id");
		
		ChangeMemberInfoRequest cmiReq = new ChangeMemberInfoRequest(
				authUser.getId(),
				req.getParameter("pw"),
				req.getParameter("name"),
				req.getParameter("gender"),
				req.getParameter("email"));
		req.setAttribute("cmiReq", cmiReq);
				
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		cmiReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changeMISerive.changeMemberInfo(cmiReq);
			return "/WEB-INF/view/changeMemberInfoSuccess.jsp";
			
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		
		 
	}	
	
	
	
	
	
}

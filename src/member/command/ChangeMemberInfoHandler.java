package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import auth.service.User;
import member.service.ChangeMemberInfoRequest;
import member.service.ChangeMemberInfoService;
import member.service.InvalidPasswordException;
import member.service.MemberData;
import member.service.MemberNotFoundException;
import member.service.ReadMemberService;
import movie.service.MovieNotFoundException;
import mvc.controller.CommandHandler;

public class ChangeMemberInfoHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/WEB-INF/view/changeMemberInfoForm.jsp";
	
	private ChangeMemberInfoService changeMISerive = new ChangeMemberInfoService();
	private ReadMemberService readService = new ReadMemberService();
	private LoginService loginService = new LoginService();
	
	
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
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		
		User user = (User) req.getSession().getAttribute("authUser");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		String newEmail = req.getParameter("newEmail");
				
		if(curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if(newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changeMISerive.changeMemberInfo(user.getId(),curPwd,newPwd,newEmail);
			req.setAttribute("changeMem", "changed");
			req.setAttribute("newEmail", newEmail);
			return "/memberInfo.jsp";
			
		}catch(InvalidPasswordException e) {
			e.printStackTrace();
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		}
		catch (MemberNotFoundException e) {
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		
		 
	}	
	
	
	
	
	
}

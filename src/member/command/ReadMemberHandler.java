package member.command;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.service.MemberNotFoundException;
import member.service.MemberSelectService;
import member.service.ReadMemberService;
import mvc.controller.CommandHandler;

public class ReadMemberHandler implements CommandHandler{
	
	private MemberSelectService selmem = new MemberSelectService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		Connection conn =null; 
		try {
			 conn =ConnectionProvider.getConnection();
						
			ArrayList<Member> list1 = selmem.getMemberLists();
			
			request.setAttribute("list1", list1);
			
			return "/WEB-INF/view/TotalMember.jsp";
			
		}catch(MemberNotFoundException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return "main.do";
		}
		
	}

}

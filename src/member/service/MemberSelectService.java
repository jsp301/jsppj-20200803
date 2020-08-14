package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class MemberSelectService {

	private MemberDao dao = new MemberDao();
	
	public ArrayList<Member> getMemberLists() {
		Connection conn = null;
		
		try {
			conn =  ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArrayList<Member> memberList = dao.getMemberList(conn);
			
			if (memberList == null) {
				throw new MemberNotFoundException();
			}
			
			conn.commit();
			
			return memberList;
		}catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}
		finally {
			JdbcUtil.close(conn);
		}
		
	}
}

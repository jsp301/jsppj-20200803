package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class DeleteMemberService {

	private MemberDao dao = new MemberDao();
	
	public void deleteMember(String userId, String curPwd) {
		Connection conn = null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = dao.selectById(conn, userId);
			if(member == null) {
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			member.matchPassword(curPwd);
			dao.deleteMember(conn, member);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}

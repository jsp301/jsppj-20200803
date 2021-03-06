package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangeMemberInfoService {
	private MemberDao dao = new MemberDao();
	
	/*public void changeMemberInfo(ChangeMemberInfoRequest cmiReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = dao.selectById(conn, cmiReq.getUserId());
			if(member == null) {
				throw new MemberNotFoundException();
			}
//			member.changePassword(newPwd);
//			member.changeEmail(newEmail);  //
			dao.update(conn, member);
			conn.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}*/
	
	public void changeMemberInfo(String userId, String curPwd, String newPwd, String newEmail) {
		Connection conn =null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member member = dao.selectById(conn, userId);
			if(member == null) {
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			member.changePassword(newPwd);
			member.changeEmail(newEmail);
			dao.update1(conn, member);
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

}

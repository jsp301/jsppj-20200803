package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ReadMemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public MemberData getMember(String userId) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			Member member = memberDao.selectById(conn, userId);
			if (member == null) {
				throw new MemberNotFoundException();
			}
			
			return new MemberData(member);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}










package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.Member;

public class MemberDao {
	
	public Member selectById(Connection conn, String id)throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member where userID = ?");
			pstmt.setString(1,id);
			rs= pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member(
						rs.getString("userId"),
						rs.getString("userPassword"),
						rs.getString("userName"),
						rs.getString("userGender"),
						rs.getString("userEmail"));
			}
			return member;
						
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
		}
	}
	
	public void insert(Connection conn, Member mem) throws SQLException {
		try(PreparedStatement pstmt =
				conn.prepareStatement("insert into user value(?,?,?,?,?)")) {
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getUserpw());
			pstmt.setString(3, mem.getUserName());
			pstmt.setString(4, mem.getUserGender());
			pstmt.setString(5, mem.getUserEmail());
			pstmt.executeUpdate();
		}
	}

}

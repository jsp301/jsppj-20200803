package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.MovieContent;

public class MovieContentDao {
	// insert 메서드
	public MovieContent insert(Connection conn, MovieContent content)
	throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO movie_content "
					+ "(movie_no, content) values(?,?)");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount>0) {
				return content;
				
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}

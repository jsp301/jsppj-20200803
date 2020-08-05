package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import movie.model.MovieContent;

public class MovieContentDao {
	// insert 메서드
	public MovieContent insert(Connection conn, MovieContent content)
	throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO movie_content "
					+ "(movieId, userId, score, content, file_name) values(?,?,?,?)");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getUserid().getId());
			pstmt.setString(3, content.getScore());
			pstmt.setString(4, content.getContent());
			pstmt.setString(5, content.getFileName());
			
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

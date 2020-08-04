package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Movie;

public class MovieDao {
	
	//insert 메서드
	public Movie insert(Connection conn, Movie movie)
	throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO movie "
					+ "(writer_id, writer_name, title,"
					+ " regdate, moddate, read_cnt)"
					+ "values (?,?,?,?,?,0)"); 
			pstmt.setString(1, movie.getWriter().getId());
			pstmt.setString(2, movie.getWriter().getName());
			pstmt.setString(3, movie.getTitle());
			pstmt.setTimestamp(4, toTimestamp(movie.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(movie.getModiDate()));
			
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() FROM movie");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Movie(
							newNum,
							movie.getWriter(),
							movie.getTitle(),
							movie.getRegDate(),
							movie.getModiDate(),
							0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}

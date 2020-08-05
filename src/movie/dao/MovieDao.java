package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import movie.model.Movie;

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
					+ "(movieTitle, director,"
					+ " movieGenre, releaseDate)"
					+ "values (?,?,?,?)"); 
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getMovieGenre());
			pstmt.setString(4, movie.getReleaseDate());
						
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() FROM movie"); //movieId의 마지막번호
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Movie(
							newNum,
							movie.getTitle(),
							movie.getDirector(),
							movie.getMovieGenre(),
							movie.getReleaseDate()
							);
				}
			}
			return null;
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

}

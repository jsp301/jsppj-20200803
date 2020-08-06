package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
					+ " movieGenre, releaseDate, file_name)"
					+ "values (?,?,?,?,?)"); 
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getMovieGenre());
			pstmt.setString(4, movie.getReleaseDate());
			pstmt.setString(5, movie.getFileName());
						
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() FROM movie"); //movieId의 마지막번호
				if(rs.next()) {
					// newNum 가져와서 Movie 새로 반영
					Integer newNum = rs.getInt(1);
					return new Movie(
							newNum,
							movie.getTitle(),
							movie.getDirector(),
							movie.getMovieGenre(),
							movie.getReleaseDate(),
							movie.getFileName()
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

	// convertMovie()메서드 : ResultSet에서 데이터 읽어와 Movie 객체 생성
	private Movie convertMovie(ResultSet rs) throws SQLException {
		return new Movie(
				rs.getInt("movieId"),
				rs.getString("movieTitle"),
				rs.getString("director"),
				rs.getString("movieGenre"),
				rs.getString("releaseDate"),
				rs.getString("file_name")
				);
	}
	
	// selectById
	public Movie selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM movie WHERE movieId = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			Movie movie = null;
			
			if(rs.next()) {
				movie = convertMovie(rs);
			} 
			return movie;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	
	
}
































package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
					+ " movieGenre, releaseDate, file_name, story)"
					+ "values (?,?,?,?,?,?)"); 
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getMovieGenre());
			pstmt.setString(4, movie.getReleaseDate());
			pstmt.setString(5, movie.getStory());
			pstmt.setString(6, movie.getFileName());
						
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
							movie.getFileName(),
							movie.getStory()
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
				rs.getString("file_name"),
				rs.getString("story")
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
	
	
	
	
	//selectCount 
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select count(*) from movie");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	//select
	public List<Movie> select(Connection conn, int startRow, int size)
	throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"select * from movie "
					+ "order by movieId desc limit ?,?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			
			List<Movie> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertMovie(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	// search
	public List<Movie>	search(Connection conn, int startRow, int Size, String search)
	throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT movieId, movieTitle, director, movieGenre"
					+ "FROM movie where CONCAT(movieTitle,director,movieGenre) LIKE ? "  
					+ "ORDER BY movieId DESC LIMIT ?,?");
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, Size);
			
			rs = pstmt.executeQuery();
			List<Movie> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertMovie(rs));
			}
			return result;
		    
		} finally {
			JdbcUtil.close(rs, pstmt);
		} 
		
	} 
	
	
	
}
































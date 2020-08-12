package movie.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import movie.dao.MovieContentDao;
import movie.dao.MovieDao;
import movie.model.Movie;
import movie.model.MovieContent;

public class WriteMovieService {
	
	private MovieDao movieDao = new MovieDao();
	/*private MovieContentDao contentDao = new MovieContentDao();*/
	
	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Movie movie = toMovie(req);
			Movie savedMovie = movieDao.insert(conn, movie);
			
			if(savedMovie == null) {
				throw new RuntimeException("fail to insert movie");
			}
			
			
			/*MovieContent content = new MovieContent(
					savedMovie.getNumber(),
					req.getUser(),
					req.getContent(),
					req.getScore(),
					req.getFileName());
			MovieContent savedcontent = contentDao.insert(conn, content);
			
			if(savedcontent == null) {
				throw new RuntimeException("fail to insert movie_content");
			}*/
			
			conn.commit();
			
			//새로 추가한 게시글 번호 리턴
			return savedMovie.getNumber();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		
	}
	
	private Movie toMovie(WriteRequest req) {		
		return new Movie(null, req.getTitle(), req.getDirector(), 
				req.getGenre(), req.getReleaseDate(), req.getFileName(), req.getStory());
	}


}

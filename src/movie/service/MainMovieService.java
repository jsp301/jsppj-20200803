package movie.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;

public class MainMovieService {
	
	private MovieDao movieDao = new MovieDao();
	private int size =6;
		
	public MainMovie getMainMovie(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			int total = movieDao.selectCount(conn);
			
			List<Movie> content = movieDao.select(
					conn, (pageNum-1)*size, size);
			return new MainMovie(total,  pageNum, size, content);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}

package movie.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;

public class SearchMovieService {
	private MovieDao movieDao = new MovieDao();
	private int size = 10;
	
	public SearchMovie getSearchMovie(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			int total = movieDao.selectCount(conn);
			
			List<Movie> content = movieDao.select(
					conn, (pageNum-1)*size, size);
			return new SearchMovie(total, pageNum, size, content);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

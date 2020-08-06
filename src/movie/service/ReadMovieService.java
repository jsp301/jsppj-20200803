package movie.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;

public class ReadMovieService {
	
	private MovieDao movieDao = new MovieDao();
	
	public MovieData getMovie(int movieNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			Movie movie = movieDao.selectById(conn, movieNum);
			if(movie == null) {
				throw new MovieNotFoundException();
			}
			return new MovieData(movie);
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} 
	
}

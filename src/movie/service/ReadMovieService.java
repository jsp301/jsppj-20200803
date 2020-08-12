package movie.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;
import reply.dao.MessageDao;
import reply.model.Message;

public class ReadMovieService {
	
	private MovieDao movieDao = new MovieDao();
	private MessageDao messageDao = new MessageDao();
	
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
	
	public int getScore(int movieNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int score = messageDao.avgScore(conn, movieNum);
			return score;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}

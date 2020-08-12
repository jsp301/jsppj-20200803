package reply.sevice;

import auth.service.User;
import movie.model.Movie;


public class MessageRequest {
	
	private Integer number;
	private int movieId;
	private String userId;
	private int score;
	private String content;
	
	public MessageRequest(Integer number, int movieId, String userId, int score, String content) {
		
		this.number = number;
		this.movieId = movieId;
		this.userId = userId;
		this.score = score;
		this.content = content;
	}

	public Integer getNumber() {
		return number;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getUserId() {
		return userId;
	}

	public int getScore() {
		return score;
	}

	public String getContent() {
		return content;
	}

}

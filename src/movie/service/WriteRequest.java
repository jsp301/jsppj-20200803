package movie.service;

import java.util.Date;
import java.util.Map;

import auth.service.User;

public class WriteRequest {
	private Integer number;
	private User userid;
	private String title;
	private String score;
	private String content;
	private String fileName;
	
	private String director;
	private String genre;	//movieGenre
	private String releaseDate;
	
	public WriteRequest(Integer number, String title, String director, 
			String genre, String releaseDate) {
		this(number, title, director, genre, releaseDate, "");
	}
	
	public WriteRequest(Integer number, String title, String director, 
			String genre, String releaseDate, String fileName) {
		this.number=number;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.fileName = fileName;
	}
	
	


	public User getUser() {
		return userid;
	}
	public String getTitle() {
		return title;
	}
	public String getScore() {
		return score;
	}
	public String getContent() {
		return content;
	}
	public String getFileName() {
		return fileName;
	}

	
	
	public String getDirector() {
		return director;
	}
	public String getGenre() {
		return genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}


	// 데이터 유효 여부 검사
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}

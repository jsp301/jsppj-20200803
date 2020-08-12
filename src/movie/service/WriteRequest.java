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
	private String story;
	
	public WriteRequest(Integer number, String title, String director, 
			String genre, String releaseDate, String story) {
		this(number, title, director, genre, releaseDate, story, "");
	}
	
	
	
	public WriteRequest(Integer number, User userid, String title, String score, String content, String fileName,
			String director, String genre, String releaseDate, String story) {
		super();
		this.number = number;
		this.userid = userid;
		this.title = title;
		this.score = score;
		this.content = content;
		this.fileName = fileName;
		this.director = director;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.story = story;
	}



	public WriteRequest(Integer number, String title, String director, 
			String genre, String releaseDate, String fileName, String story) {
		this.number=number;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.fileName = fileName;
		this.story = story;
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
	
	

	public String getStory() {
		return story;
	}

	
	// 데이터 유효 여부 검사
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}

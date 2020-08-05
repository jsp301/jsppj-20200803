package movie.service;

import java.util.Date;
import java.util.Map;

import auth.service.User;

public class WriteRequest {
	private User userid;
	private String title;
	private String score;
	private String content;
	private String fileName;
	
	private String director;
	private String genre;	//movieGenre
	private Date releaseDate;
	
	
	public WriteRequest(User user, String title, String score, String content) {
		this(user,title,score,content, "");
	}


	public WriteRequest(User user, String title, String score, String content, String fileName) {
		super();
		this.userid = user;
		this.title = title;
		this.score = score;
		this.content = content;
		this.fileName = fileName;
	}
	
		
	public WriteRequest(User user, String title, String score, String content, String fileName, String director,
			String genre, Date releaseDate) {
		super();
		this.userid = user;
		this.title = title;
		this.score = score;
		this.content = content;
		this.fileName = fileName;
		this.director = director;
		this.genre = genre;
		this.releaseDate = releaseDate;
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
	public Date getReleaseDate() {
		return releaseDate;
	}


	// 데이터 유효 여부 검사
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}

package movie.model;

import auth.service.User;

public class MovieContent {
	private Integer number;	//movieId
	private User userid; 	//userId
	private String score;
	private String content;
	private String fileName;
	
	public MovieContent(Integer number, User userid, String score, String content, String fileName) {
		super();
		this.number = number;
		this.userid = userid;
		this.score = score;
		this.content = content;
		this.fileName = fileName;
	}
	

	public Integer getNumber() {
		return number;
	}
	public User getUserid() {
		return userid;
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
	
	
	

		
	
	
}

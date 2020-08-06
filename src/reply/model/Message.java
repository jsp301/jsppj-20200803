package reply.model;

import auth.service.User;


public class Message {
	

	private int id;
	private int score;
	private String content;


	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getContent() {
		return content;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}

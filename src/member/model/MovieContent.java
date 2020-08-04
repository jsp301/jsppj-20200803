package member.model;

public class MovieContent {
	private Integer number;
	private String content;
	private String score;
	
	public MovieContent(Integer number, String content, String score) {
		super();
		this.number = number;
		this.content = content;
		this.score = score;
	}
	
	
	public Integer getNumber() {
		return number;
	}
	public String getContent() {
		return content;
	}
	public String getScore() {
		return score;
	}
	
	
}

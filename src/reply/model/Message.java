package reply.model;




public class Message {
	private Integer contentId; 	//댓글 번호
	private int movId;			//영화 number
	private String uId;			//user Id
	private int score;
	private String content;
	
	
	public Integer getContentId() {
		return contentId;
	}
	public int getMovId() {
		return movId;
	}
	public String getuId() {
		return uId;
	}
	public int getScore() {
		return score;
	}
	public String getContent() {
		return content;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public void setMovId(int movId) {
		this.movId = movId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
		
	
}

package member.model;

//Member 저장소
public class Member {
	private String userId;
	private String userpw;
	private String userName;
	private String userGender;
	private String userEmail;
	
	
	
	public Member(String userId, String userpw, String userName, String userGender, String userEmail) {
		this.userId = userId;
		this.userpw = userpw;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public String getUserpw() {
		return userpw;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public boolean matchPassword(String pwd) {
		return userpw.equals(pwd);
	}
	
	public void changePassword(String newPwd) {
		this.userpw = newPwd;
	}
	
}

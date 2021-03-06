package member.model;

import java.util.ArrayList;

//Member 저장소
public class Member {
	private String userSelect;
	private String userId;
	private String userpw;
	private String userName;
	private String userGender;
	private String userEmail;
	private ArrayList<Member> memberList;
	
	public Member(String userSelect, String userId, String userpw, String userName, String userGender, String userEmail) {
		this.userSelect = userSelect;
		this.userId = userId;
		this.userpw = userpw;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
	}
	
	public ArrayList<Member> getMemberList(){
		return memberList;
	}
	
	public String getUserSelect() {
		return userSelect;
	}

	public void setUserSelect(String userSelect) {
		this.userSelect = userSelect;
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
	public void changeEmail(String newEmail) {
		this.userEmail = newEmail;
	}

	public boolean matchSelect(String slt) {
		return userSelect.equals(slt);
	}
	
}

package auth.service;

public class User {
	private String id;
	private String name;

	
	public User (String id) {
		this.id = id;
	}
	

	private String gender;
	private String email;
	
	public User(String id, String name, String gender, String email) {
		this.id = id;
		this.name = name;
		this.gender =gender;
		this.email = email;
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}


}

package auth.service;

public class User {
	private String select;
	private String id;
	private String name;
	private String gender;
	private String email;
	

	
	public User (String id) {
		this.id = id;
	}
	
	
	public User(String select, String id, String name, String gender, String email) {
		this.select =select;
		this.id = id;
		this.name = name;
		this.gender =gender;
		this.email = email;
		
	}
	
	public String getSelect() {
		return select;
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

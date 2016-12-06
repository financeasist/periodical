package ua.com.periodical.model;

public class User {

	Integer id;
	String email;
	String password;
	
	
	public User(Integer id, String email, String password) {
	
		this.id = id;
		this.email = email;
		this.password = password;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email +" password= " + password + "]";
	}
	
	
	
}

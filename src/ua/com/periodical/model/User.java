package ua.com.periodical.model;

public class User {

	String userName;
	String email;
	String password;
	String role;

	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User(String userName, String email, String password, String role) {

		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;

	}

	public String getId() {
		return userName;
	}

	public void setId(String userName) {
		this.userName = userName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

}

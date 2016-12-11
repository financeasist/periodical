package ua.com.periodical.service;

import java.util.Set;

import ua.com.periodical.model.User;

public interface UserService {

	public void addUser(String userName,String email, String password);
	public Set<User> getAllUsers();
	public User getUserById(String userName);
	public User getUserByEmail(String email);
	public User getUserByEmailAndPassword(String email, String password);
	public User getUserByUserNameAndPassword(String userName, String password);
	public void updatePasswordByEmail(String password, String email); 
	public void removeById(String id);
	public Boolean IsUserExist(String userName, String password);
	public Boolean IfUserExist(User user);
}

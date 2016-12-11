package ua.com.periodical.dao;

import java.util.Set;

import ua.com.periodical.model.User;

public interface UserRepositoryDao{

	public void addUser(String id,String email, String password);
	public Set<User> getAllUsers();
	public User getUserById(String Id);
	public User getUserByEmail(String email);
	public User getUserByEmailAndPassword(String email, String password);
	public void updatePasswordByEmail(String password, String email); 
	public void removeById(String idInt);
	public Boolean IsUserExist(String userName, String password);
	public User getUserByUserNameAndPassword(String userName, String password);
	public Boolean IfUserExist(User user);
	
}


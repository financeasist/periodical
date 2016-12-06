package ua.com.periodical.dao;

import java.util.Set;

import ua.com.periodical.model.User;

public interface UserRepositoryDao {

	public void addUser(Integer id,String email, String password);
	public Set<User> getAllUsers();
	public User getUserById(Integer Id);
	public User getUserByEmail(String email);
	public User getUserByEmail(String email, String password);
	public void updatePasswordByEmail(String password, String email); 
	public void removeById(Integer idInt);
	
}


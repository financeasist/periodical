package ua.com.periodical.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ua.com.periodical.dao.UserRepositoryDao;
import ua.com.periodical.model.User;

/**
 * This class is memory repository for users . Created by Bill Pugh Singleton
 * pattern. During initialization we fill the repository by 3 Users; Class
 * implements UserRepositoryDao;
 * 
 * @version 1.0 04.12.2016
 * @author Roman Grupskyi
 */
public class UsersRepositoryDaoImpl implements UserRepositoryDao {

	private static Set<User> users;

	/**
	 * Here, during initialization we fill the repository by 3 Users;
	 */
	private UsersRepositoryDaoImpl() {
		UsersRepositoryDaoImpl.setUsers(new HashSet<User>());
		users.add(new User(1, "login1@gmail.com", "1111"));
		users.add(new User(2, "login2@gmail.com", "2222"));
		users.add(new User(3, "login3@gmail.com", "3333"));
	}

	private static class SingletonHelper {
		private static final UsersRepositoryDaoImpl INSTANCE = new UsersRepositoryDaoImpl();

	}

	public static UsersRepositoryDaoImpl getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public Set<User> getAllUsers() {
		return users;
	}

	public static void setUsers(Set<User> uzers) {
		users = uzers;
	}

	/**
	 * This method takes user from users by id;
	 * 
	 * @param id
	 * @return User
	 */
	@Override
	public User getUserById(Integer Id) {
		User user = null;
		for (User uzer : users) {
			if (uzer.getId() == Id) {
				user = uzer;
			}
		}
		return user;
	}

	/**
	 * This method takes user from users by email;
	 * 
	 * @param String
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email) {
		User user = null;
		for (User uzer : users) {
			if (uzer.getEmail().equals(email)) {
				user = uzer;
			}
		}
		return user;
	}

	/**
	 * This method removes user from users by id;
	 */
	@Override
	public void removeById(Integer idInt) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == idInt)
				iterator.remove();
		}

	}

	/**
	 * This method adds new user to users ;
	 * 
	 * @param id,email,password
	 * @return void
	 */
	@Override
	public void addUser(Integer id, String email, String password) {
		User user = new User(id, email, password);
		users.add(user);

	}

	/**
	 * Method updates password by email
	 * 
	 * @param password.
	 *            email
	 * @return void
	 */
	public void updatePasswordByEmail(String password, String email) {
		User user = null;
		for (User uzer : users) {
			if (uzer.getEmail().equals(email)) {
				user = uzer;
			}
			user.setPassword(password);
		}

	}

	/**
	 * This method takes user from users by email;
	 * 
	 * @param String
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email, String password) {
		User user = null;
		for (User uzer : users) {
			if (uzer.getEmail().equals(email) && uzer.getPassword().equals(password)) {
				user = uzer;
			}
		}
		return user;
	}

	/**
	 * This method chacs if user containsts(exist) in users; if exist - return
	 * true, else return false;
	 * 
	 * @param String,String
	 * @return Boolean
	 */
	public Boolean IsUserExist(String email, String password) {
		Boolean exist = false;
		for (User uzer : users) {
			if (uzer.getEmail().equals(email) && uzer.getPassword().equals(password)) {
				exist = true;
			}
		}
		return exist;
	}
}

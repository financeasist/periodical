package ua.com.periodical.service.impl;

import java.util.Set;

import ua.com.periodical.dao.UserRepositoryDao;
import ua.com.periodical.dao.impl.UsersRepositoryDaoImpl;
import ua.com.periodical.model.User;
import ua.com.periodical.service.UserService;

public class UserServiceImpl implements UserService {
	private UserRepositoryDao usersRepository = UsersRepositoryDaoImpl.getInstance();

	@Override
	public void addUser(String id, String email, String password) {
		usersRepository.addUser(id, email, password);
	}

	@Override
	public Set<User> getAllUsers() {
		Set<User> set = usersRepository.getAllUsers();
		return set;
	}

	@Override
	public User getUserById(String Id) {
		User user = usersRepository.getUserById(Id);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		return usersRepository.getUserByEmail(email);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user = usersRepository.getUserByEmailAndPassword(email, password);
		return user;
	}

	@Override
	public void updatePasswordByEmail(String password, String email) {
		usersRepository.updatePasswordByEmail(password, email);
	}

	@Override
	public void removeById(String id) {
		usersRepository.removeById(id);
		
	}

	@Override
	public Boolean IsUserExist(String userName, String password) {
		Boolean isUserExist = usersRepository.IsUserExist(userName, password);
		return isUserExist;
	}

	@Override
	public Boolean IfUserExist(User user) {
		return usersRepository.IfUserExist(user);
		
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		User user = usersRepository.getUserByUserNameAndPassword(userName, password);
		return user;
	}

}

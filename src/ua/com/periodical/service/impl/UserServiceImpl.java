package ua.com.periodical.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.periodical.dao.impl.MemoryRepositoryDaoImpl;
import ua.com.periodical.model.Periodical;
import ua.com.periodical.service.UserService;

public class UserServiceImpl implements UserService {
	private MemoryRepositoryDaoImpl memoryReposDao = MemoryRepositoryDaoImpl.getInstance();

	@Override
	public List<Periodical> getAllPeriodical() {
		ArrayList<Periodical> periodicals = memoryReposDao.getPeriodicals();
		return periodicals;
	}

	@Override
	public Periodical getPeriodicalByTitle(String title) {
		Periodical periodical = memoryReposDao.getByTitle(title);
		return periodical;
	}

}

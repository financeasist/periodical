package ua.com.periodical.service.impl;

import java.util.ArrayList;

import ua.com.periodical.dao.impl.MemoryRepositoryDaoImpl;
import ua.com.periodical.model.Periodical;
import ua.com.periodical.model.User;
import ua.com.periodical.service.PeriodicalService;

public class PeriodicalServiceImpl implements PeriodicalService {
	private MemoryRepositoryDaoImpl memoryReposDao = MemoryRepositoryDaoImpl.getInstance();

	@Override
	public void addPeriodical(Periodical periodical) {
		memoryReposDao.addPeriodical(periodical);
	}

	@Override
	public ArrayList<Periodical> getAllPeriodicals() {
		ArrayList<Periodical> periodicals = memoryReposDao.getAllPeriodicals();
		return periodicals;
	}

	@Override
	public void setPeriodicals(ArrayList<Periodical> periodicals) {
		memoryReposDao.setPeriodicals(periodicals);
	}

	@Override
	public Periodical getPeriodicalByTitle(String title) {
		Periodical periodical = memoryReposDao.getPeriodicalByTitle(title);
		return periodical;

	}

	@Override
	public void removePeriodicalByTitle(String title, User user) {
		memoryReposDao.removePeriodicalByTitle(title, user);
	}

	@Override
	public void removePeriodicalById(Integer idInt, User user) {
		memoryReposDao.removePeriodicalById(idInt, user);
	}

}

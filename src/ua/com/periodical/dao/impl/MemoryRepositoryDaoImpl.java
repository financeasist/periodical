package ua.com.periodical.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import ua.com.periodical.dao.MemoryRepositoryDao;
import ua.com.periodical.model.Periodical;
import ua.com.periodical.model.User;

/**
 * This class is memory repository for periodicals list. Created by Bill Pugh
 * Singleton pattern
 * 
 * @version 1.2 10.11.2016
 * @author Roman Grupskyi
 */
public class MemoryRepositoryDaoImpl implements MemoryRepositoryDao {

	private ArrayList<Periodical> periodicals;
	
	/**
	 * Here is implementation by Singleton pattern
	 */
	private MemoryRepositoryDaoImpl() {
		this.setPeriodicals(new ArrayList<Periodical>());
		periodicals.add(new Periodical(1,"Forbs", 7.05, "рейтинг успішних людей"));
		periodicals.add(new Periodical(2,"woman", 3.05, "all about women"));
		periodicals.add(new Periodical(3,"Hi-Tech", 4.00, "some description"));
	}

	private static class SingletonHelper {
		private static final MemoryRepositoryDaoImpl INSTANCE = new MemoryRepositoryDaoImpl();
	}

	public static MemoryRepositoryDaoImpl getInstance() {
		return SingletonHelper.INSTANCE;
	}

	/**
	 * This method add Periodical to periodicals List
	 * 
	 * @param periodical
	 */
	public void addPeriodical(Periodical periodical) {
		periodicals.add(periodical);
	}

	public ArrayList<Periodical> getAllPeriodicals() {
		return periodicals;
	}

	public void setPeriodicals(ArrayList<Periodical> periodicals) {
		this.periodicals = periodicals;
	}

	/**
	 * This method remove Periodical by id from periodicals List
	 * 
	 * @param periodical
	 */
	public void removePeriodicalById(Integer idInt, User user) {
		String role = user.getRole();
		if (role.equals("admin")) {
			Iterator<Periodical> iterator = periodicals.iterator();
			while (iterator.hasNext()) {
				Periodical periodical = iterator.next();
				if (periodical.getId() == idInt)
					iterator.remove();
			}
		}else
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method remove Periodical by title from periodicals List
	 * 
	 * @param periodical
	 * @return void
	 */
	public void removePeriodicalByTitle(String title, User user) {
		String role = user.getRole();
		if (role.equals("admin")) {
			Iterator<Periodical> iterator = periodicals.iterator();
			while (iterator.hasNext()) {
				Periodical periodical = iterator.next();
				if (periodical.getTitle().equals(title))
					iterator.remove();
			}
		}else
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method get Periodical by title from periodicals List
	 * 
	 * @param periodical
	 */
	public Periodical getPeriodicalByTitle(String title) {
		Periodical periodical = null;
		for (Periodical per : periodicals) {
			if (per.getTitle().equals(title)) {
				periodical = per;
			}
		}

		return periodical;

	}
}

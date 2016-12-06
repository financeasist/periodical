package ua.com.periodical.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import ua.com.periodical.dao.MemoryRepositoryDao;
import ua.com.periodical.model.Periodical;

/**
 * This class is memory repository for periodicals list. Created by Bill Pugh
 * Singleton pattern
 * 
 * @version 1.2 10.11.2016
 * @author Roman Grupskyi
 */
public class MemoryRepositoryDaoImpl implements MemoryRepositoryDao{

	private ArrayList<Periodical> periodicals;

	/**
	 * Here is implementation by Singleton pattern
	 */
	private MemoryRepositoryDaoImpl() {
		this.setPeriodicals(new ArrayList<Periodical>());
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

	public ArrayList<Periodical> getPeriodicals() {
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
	public void removeById(Integer idInt) {
		Iterator<Periodical> iterator = periodicals.iterator();
		while (iterator.hasNext()) {
			Periodical periodical = iterator.next();
			if (periodical.getId() == idInt)
				iterator.remove();
		}
	}
	
	/**
	 * This method get Periodical by title from periodicals List
	 * 
	 * @param periodical
	 */
	public Periodical getByTitle(String title) {
		Periodical periodical = null;
		for (Periodical per:periodicals){
			if(per.getTitle().equals(title)) {
				periodical = per;
			}
		}
		
		return periodical;
		
	}
}

package ua.com.periodical.dao;

import java.util.ArrayList;
import java.util.Iterator;

import ua.com.periodical.model.Periodical;

/**
 * This class is memory repository for periodicals list. Created by Bill Pugh
 * Singleton pattern
 * 
 * @version 1.2 10.11.2016
 * @author Roman Grupskyi
 */
public class MemoryRepository {

	private ArrayList<Periodical> periodicals;

	/**
	 * Here is implementation by Singleton pattern
	 */
	private MemoryRepository() {
		this.setPeriodicals(new ArrayList<Periodical>());
	}

	private static class SingletonHelper {
		private static final MemoryRepository INSTANCE = new MemoryRepository();
	}

	public static MemoryRepository getInstance() {
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

	public void removeById(Integer idInt) {
		Iterator<Periodical> iterator = periodicals.iterator();
		while (iterator.hasNext()) {
			Periodical periodical = iterator.next();
			if (periodical.getId() == idInt)
				iterator.remove();
		}
	}
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

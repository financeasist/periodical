package ua.com.periodical.dao;

import java.util.ArrayList;

import ua.com.periodical.model.Periodical;

public interface MemoryRepositoryDao {

	public void addPeriodical(Periodical periodical);
	public ArrayList<Periodical> getPeriodicals();
	public void removeById(Integer idInt);
	public Periodical getByTitle(String title);
}

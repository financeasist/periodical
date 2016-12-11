package ua.com.periodical.dao;

import java.util.ArrayList;

import ua.com.periodical.model.Periodical;
import ua.com.periodical.model.User;

public interface MemoryRepositoryDao {
	
	public void addPeriodical(Periodical periodical);
	public ArrayList<Periodical> getAllPeriodicals();
	public void setPeriodicals(ArrayList<Periodical> periodicals);
	public Periodical getPeriodicalByTitle(String title);
	public void removePeriodicalByTitle(String title, User user);
	public void removePeriodicalById(Integer idInt, User user);




}

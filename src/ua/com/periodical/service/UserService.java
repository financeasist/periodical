package ua.com.periodical.service;

import java.util.List;

import ua.com.periodical.model.Periodical;

public interface UserService {

	public List<Periodical> getAllPeriodical();

	public Periodical getPeriodicalByTitle(String title);

}

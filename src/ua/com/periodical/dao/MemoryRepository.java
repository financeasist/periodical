package ua.com.periodical.dao;

import java.util.ArrayList;

import ua.com.periodical.model.Periodical;

public class MemoryRepository {

	public static ArrayList<Periodical> periodicals = new ArrayList<Periodical>();

	public static ArrayList<Periodical> getPeriodicals() {
		return periodicals;
	}

}

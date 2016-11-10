package ua.com.periodical.dao;

import java.util.ArrayList;

import ua.com.periodical.model.Periodical;
/**
 * This class is memory repository for periodicals list.
 * Created by Bill Pugh Singleton pattern 
 * @version 1.2 10.11.2016
 *@author Roman Grupskyi
 */
public class MemoryRepository {

	private ArrayList<Periodical> periodicals; 
	/**
	 * here is implementation by Singleton pattern
	 */
	private MemoryRepository(){
		this.setPeriodicals(new ArrayList<Periodical>());
		}
		   
		  private static class SingletonHelper{
		    private static final MemoryRepository INSTANCE = new MemoryRepository();
		  }
		   
		  public static MemoryRepository getInstance(){
		    return SingletonHelper.INSTANCE;
		  }

		/**
		 * This method add Periodical to periodicals List  
		 * @param periodical
		 */
		public void addPeriodical(Periodical periodical){
			periodicals.add(periodical);
		}  
		  
		public ArrayList<Periodical> getPeriodicals() {
			return periodicals;
		}

		public void setPeriodicals(ArrayList<Periodical> periodicals) {
			this.periodicals = periodicals;
		}
		


}

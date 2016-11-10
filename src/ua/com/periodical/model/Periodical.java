package ua.com.periodical.model;
/**
 * This class describes periodical(the main substance of this application)
 * @version 1.0 09.11.2016
 * @author  Roman Grupskyi
 */
public class Periodical {

	private Integer id;
	private String title;
	private Double price;
	private String discription;
	private Boolean isAdded=false;
	private Boolean isPaided=false;
	

	public Periodical(Integer id, String title, Double price, String discription, Boolean isAdded, Boolean isPaided) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.discription = discription;
		this.isAdded = isAdded;
		this.isPaided = isPaided;
	}

	public Periodical(Integer id, String title, Double price, String discription) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.discription = discription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsAdded() {
		return isAdded;
	}

	public void setIsAdded(Boolean isAdded) {
		this.isAdded = isAdded;
	}

	public Boolean getIsPaided() {
		return isPaided;
	}

	public void setIsPaided(Boolean isPaided) {
		this.isPaided = isPaided;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "<td>"+ id + "</td>\n<td>" + title + "</td>\n<td>" + price + "</td>\n<td>" + discription
				+ "</td>\n<td>" + isAdded + "</td>\n<td>" + isPaided + "</td>";
		}


public static void main(String...args){
	Periodical p = new Periodical(2,"vvv",2.0,"rrr");
	System.out.println(p.toString());
	}
}
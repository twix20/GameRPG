package Models;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 2941677815273042223L;
	
	protected int id;
	protected String name;  
	protected int price;  
	protected StatisticsBag statistics;
   
	public Item(int id, String name, int price, StatisticsBag statistics){
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setStatistics(statistics);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Object getStatistics() {
		return statistics;
	}

	public void setStatistics(StatisticsBag statistics) {
		this.statistics = statistics;
	}
}

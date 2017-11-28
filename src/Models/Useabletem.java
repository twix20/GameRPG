package Models;

import javax.persistence.Entity;

@Entity
public class Useabletem extends Item {

	public Useabletem(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	
    public void Use() {
    	
    }
}

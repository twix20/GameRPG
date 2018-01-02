package Models;

import javax.persistence.Entity;

@Entity
public abstract  class UseableItem extends Item {

	public UseableItem() {}
	
	public UseableItem(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	
    public abstract int Use();
}

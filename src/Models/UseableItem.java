
package Models;

import javax.persistence.Entity;

@Entity
public abstract  class UseableItem extends Item {

	public UseableItem() {}
	
	
	public UseableItem(String name, int price, StatisticsBag statistics) {
		super(name, price, statistics);
	}
	
    public abstract BattlefieldActionsHistory Use(Player player);
}


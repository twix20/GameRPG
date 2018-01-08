package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ARMOR")
public class Armor extends DefensiveItem {

	public Armor() {}
	
	public Armor(String name, int price, StatisticsBag statistics, int defDamage) {
		super(name, price, statistics, defDamage);
	}
	
	public int Defend() {
		return getDefDamage();
	}
}

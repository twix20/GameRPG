package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SHIELD")
public class Shield extends DefensiveItem {

	public Shield() {}
	
	public Shield(int id, String name, int price, StatisticsBag statistics, int defDamage) {
		super(id, name, price, statistics, defDamage);
	}
    public int Defend() {
    	return getDefDamage();
    }
}

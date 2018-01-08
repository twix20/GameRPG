package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SHIELD")
public class Shield extends DefensiveItem {

	public Shield() {}
	
	public Shield(String name, int price, StatisticsBag statistics, int defDamage) {
		super(name, price, statistics, defDamage);
	}
	
    public int Defend() {
    	return getDefDamage();
    }
}

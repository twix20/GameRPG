package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BOW")
public class Bow extends AttackItem {
	
	public Bow() {}
	
	public Bow(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	}
	
	public int DealDamage() {
		return getDamage();
    }
}

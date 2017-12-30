package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "WAND")
public class Wand extends AttackItem {
	
	public Wand() {}
   
	public Wand(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	}
	
	public int DealDmg() {
		return getDamage();
		
	}
	
}

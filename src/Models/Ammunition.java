package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AMMUNITION")
public class Ammunition extends AttackItem {

	public Ammunition() {}
	
	public Ammunition(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	
	}
  public int DealDamage() {
		return getDamage();
  }
}

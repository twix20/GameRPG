package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SWORD")
public class Sword extends AttackItem {

	public Sword() {}
	
	public Sword(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	}
	
    public int DealDamage() {
    	return getDamage();
    }
}

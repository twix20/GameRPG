package Models;


import java.util.Random;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SPEAR")
public class Spear extends AttackItem {

	public Spear() {}
	
	public Spear(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	}
	
    public int DealDamage() {
    	Random rand = new Random();
    	return (int) (rand.nextInt((int) (getDamage() * 0.7)) + getDamage() * 0.4);
    }
}
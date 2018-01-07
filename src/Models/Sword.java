package Models;

import java.util.Random;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SWORD")
public class Sword extends AttackItem {

	public Sword() {}
	
	public Sword(String name, int price, StatisticsBag statistics, int damage) {
		super(name, price, statistics, damage);
	}
	@Override
    public int DealDamage() {
    	Random rand = new Random();
    	return (int) (rand.nextInt((int) (getDamage() * 0.3)) + getDamage() * 0.7);
    }
}

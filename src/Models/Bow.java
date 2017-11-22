package Models;

import java.util.ArrayList;

public class Bow extends AttackItem {

	public Bow(String name, int durability, int damage, ArrayList<Statistic> statistics) {
		super(name, durability, damage, statistics);
	}
	 public int DealDamage() {
	    	return 0;
	    }
}

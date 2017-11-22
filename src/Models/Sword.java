package Models;

import java.util.ArrayList;

public class Sword extends AttackItem {

	public Sword(String name, int durability, int damage, ArrayList<Statistic> statistics) {
		super(name, durability, damage, statistics);
	}
    public int DealDamage() {
    	return 0;
    }
}

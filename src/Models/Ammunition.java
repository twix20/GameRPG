package Models;

import java.util.ArrayList;

public class Ammunition extends AttackItem {

	public Ammunition(String name, int durability, int damage, ArrayList<Statistic> statistics) {
		super(name, durability, damage, statistics);
	}
  public int DealDamage() {
	  return 0;
  }
}

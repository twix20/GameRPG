package Models;

public class Ammunition extends AttackItem {

	public Ammunition() {}
	
	public Ammunition(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	
	}
  public int DealDamage() {
	  return 0;
  }
}

package Models;

public class Bow extends AttackItem {
	
	public Bow() {}
	
	public Bow(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics, durability, damage);
	}
	
	public int DealDamage() {
		return 0;
    }
}

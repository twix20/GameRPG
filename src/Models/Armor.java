package Models;

public class Armor extends DefensiveItem {

	public Armor() {}
	
	public Armor(int id, String name, int price, StatisticsBag statistics, int defDamage) {
		super(id, name, price, statistics, defDamage);
	}
	
	public int Defend() {
		return 0;
	}
}

package Models;

public class HealingPotion extends Useabletem {
	private int healing; 
	public HealingPotion(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	public void Use() {
		
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
}

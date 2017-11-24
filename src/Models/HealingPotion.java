package Models;

public class HealingPotion extends Useabletem {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1370781715065189766L;
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

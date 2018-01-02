package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends UseableItem {
    @Column(name = "HealValue")
    private int healing; 
    
    public HealingPotion() {}
    
	public HealingPotion(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	@Override
	public int Use() {
		return this.getHealing();
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
}

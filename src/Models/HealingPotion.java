package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends UseableItem {
    @Column(name = "HealValue")
    private int healValue; 
    
    public HealingPotion() {}
    
	public HealingPotion(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	public int Use() {
		return this.gethealValue();
	}
	
	public int gethealValue() {
		return this.healValue;
	}
	public void setHealValue(int value) {
		this.healValue = value;
	}
}

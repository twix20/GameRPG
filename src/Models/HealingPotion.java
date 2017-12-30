package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends UseableItem {
    @Column(name = "HealValue")
    private int value; 
    
    public HealingPotion() {}
    
	public HealingPotion(int id, String name, int price, StatisticsBag statistics) {
		super(id, name, price, statistics);
	}
	public int Use() {
		return this.getHealing();
	}
	public void setValue(int value) {
		this.value = value;
	}
}

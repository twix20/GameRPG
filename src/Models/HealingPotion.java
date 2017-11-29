package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends Item {//extends Useabletem {
    @Column(name = "HealValue")
    private int healing; 
    
    public HealingPotion() {}
    
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

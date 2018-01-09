
package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends UseableItem {
    @Column(name = "HealValue")
    private int healing; 
    
    public HealingPotion() {}
    
	public HealingPotion(String name, int price, StatisticsBag statistics, int healingValue) {
		super(name, price, statistics);
		
		this.setHealing(healingValue);
	}
	@Override
	public BattlefieldActionsHistory Use(Player player) {
		player.setCurrentHp(player.getCurrentHp() + this.getHealing());
		return new BattlefieldActionsHistory(player, "potion", this.getHealing());
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}

	@Override
	public int getBaisicAttribute() {
		return getHealing();
	}

	@Override
	public void setBaisicAttribute(int newValue) {
		this.setHealing(newValue);
	}
}


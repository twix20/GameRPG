
package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("HealingPotion")
public class HealingPotion extends UseableItem {
    @Column(name = "HealValue")
    private int healing; 
    
    public HealingPotion() {}
    
	public HealingPotion(String name, int price, StatisticsBag statistics) {
		super(name, price, statistics);
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
}


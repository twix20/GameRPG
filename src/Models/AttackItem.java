package Models;

import javax.persistence.*;

@Entity
public abstract class AttackItem extends Item {

    @Column(name = "MaxDurability")
	private int maxDurability;

    @Column(name = "Damage")
    private int damage;

	 public AttackItem() {}
	
	 public AttackItem(int id, String name, int price, StatisticsBag statistics, int maxDurability, int damage) {
		super(id, name, price, statistics);
		 
		this.setDamage(damage);
		this.setMaxDurability(maxDurability);
	}
	 
	 public int DealDamage() {
		 return 0;
	 }
	 
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMaxDurability() {
		return maxDurability;
	}
	public void setMaxDurability(int durability) {
		this.maxDurability = durability;
	}
}

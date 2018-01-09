package Models;

import javax.persistence.*;

@Entity
public abstract class AttackItem extends Item {

    @Column(name = "Damage")
    private int damage;

	 public AttackItem() {}
	
	 public AttackItem(String name, int price, StatisticsBag statistics, int damage) {
		super(name, price, statistics);
		 
		this.setDamage(damage);
	}
	 
	 public abstract int DealDamage();
	 
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public int getBaisicAttribute() {
		return getDamage();
	}

	@Override
	public void setBaisicAttribute(int newValue) {
		this.setDamage(newValue);
	}
}

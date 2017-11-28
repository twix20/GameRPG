package Models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class AttackItem extends Item{

    @Column(name = "Durability")
	private int durability;

    @Column(name = "Damage")
    private int damage;
        
	private String name;
	private StatisticsBag statistics;
	
	 public AttackItem() {}
	
	 public AttackItem(int id, String name, int price, StatisticsBag statistics, int durability, int damage) {
		super(id, name, price, statistics);
		 
		this.setDamage(damage);
		this.setDurability(durability);
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
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StatisticsBag getStatistics() {
		return statistics;
	}
	public void setStatistics(StatisticsBag statistics) {
		this.statistics = statistics;
	}
}

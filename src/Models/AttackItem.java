package Models;

import java.util.ArrayList;

@Entity
@DiscriminatorValue("AttackItem")
public abstract class AttackItem extends Item{

        @Column("Durability")
	private int durability;

        @Column("Damage")
        private int damage;
        
	private String name;
	private ArrayList<Statistic> statistics;
	
	 public AttackItem(String name, int durability, int damage, ArrayList<Statistic> statistics) {
		this.setDamage(damage);
		this.setDurability(durability);
		this.setName(name);
		this.setStatistics(statistics);
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
	public ArrayList<Statistic> getStatistics() {
		return statistics;
	}
	public void setStatistics(ArrayList<Statistic> statistics) {
		this.statistics = statistics;
	}
}

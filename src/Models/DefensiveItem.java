package Models;


import java.util.ArrayList;

import javax.persistence.*;

@Entity
public abstract class DefensiveItem extends Item {
    
    @Column(name = "DefDamage")
    private int defDamage;
    
    private ArrayList<Statistic> statistics;
    
    public DefensiveItem() {}
    
	public DefensiveItem(int id, String name, int price, StatisticsBag statistics, int defDamage) {
		super(id, name, price, statistics);
		
		this.setDefDamage(defDamage);
	}
	public int getDefDamage() {
		return defDamage;
	}
	
	public void setDefDamage(int defDamage) {
		this.defDamage = defDamage;
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

package Models;


import javax.persistence.*;

@Entity
public abstract class DefensiveItem extends Item {
    
    @Column(name = "DefDamage")
    private int defDamage;
    
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
}

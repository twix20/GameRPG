package Models;


import javax.persistence.*;

@Entity
public class DefensiveItem extends Item {
    
    @Column(name = "DefDamage")
    private int defDamage;
    
    public DefensiveItem() {}
    
	public DefensiveItem(String name, int price, StatisticsBag statistics, int defDamage) {
		super(name, price, statistics);
		
		this.setDefDamage(defDamage);
	}
	public int getDefDamage() {
		return defDamage;
	}
	
	public void setDefDamage(int defDamage) {
		this.defDamage = defDamage;
	}

	@Override
	public int getBaisicAttribute() {
		return getDefDamage();
	}

	@Override
	public void setBaisicAttribute(int newValue) {
		this.setDefDamage(newValue);
	}
}

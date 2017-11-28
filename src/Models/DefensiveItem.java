package Models;


import java.util.ArrayList;

@Entity
public abstract class DefensiveItem extends Item {
    
    @Column("DefDamage")
    private int defDamage;
    
    private String name;
    private ArrayList<Statistic> statistics;
public DefensiveItem(String name, int defDamage, ArrayList<Statistic> statistics) {
this.name = name;
this.defDamage = defDamage;
this.statistics = statistics;
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

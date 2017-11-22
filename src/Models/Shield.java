package Models;

import java.util.ArrayList;

public class Shield extends DefensiveItem {

	public Shield(String name, int defDamage, ArrayList<Statistic> statistics) {
		super(name, defDamage, statistics);
		
	}
    public int Defend() {
    	return 0;
    }
}

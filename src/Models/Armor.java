package Models;

import java.util.ArrayList;

public class Armor extends DefensiveItem {

	public Armor(String name, int defDamage, ArrayList<Statistic> statistics) {
		super(name, defDamage, statistics);
	}
	public int Defend() {
		return 0;
	}

}

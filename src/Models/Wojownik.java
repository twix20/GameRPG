package Models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@DiscriminatorValue("WARRIOR")
public class Wojownik extends Player {
	
	public Wojownik() {}

	public Wojownik(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,
			Equipment equipment) {
		super(nickname, password, currentHp, maxHp, statistics, equipment);

	}

	public ArrayList<Item> Battle(Player player) {
		return null;
	}

}

package Models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@DiscriminatorValue("WARRIOR")
public class Warrior extends Player {

	public Warrior() {
	}

	public Warrior(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		super(nickname, password, currentHp, maxHp, equipment);

	}

	public ArrayList<Item> Battle(Player player) {
		return null;
	}

}

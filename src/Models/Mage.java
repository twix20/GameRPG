package Models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MAG")
public class Mage extends Player {

	@Column(name = "CurrentMana")
	private int currentMana;
	
	@Column(name = "MaxMana")
	private int maxMana;

	public Mage() {}

	public Mage(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,
			Equipment equipment) {
		super(nickname, password, currentHp, maxHp, statistics, equipment);

	}

	public ArrayList<Item> Battle(Player player) {
		return null;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

}

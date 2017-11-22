package Models;

import java.util.ArrayList;

public class Mage extends Player {
    private int currentMana;
    private int maxMana;
    private Wand weapon;
	public Mage(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,
			Equipment equipment) {
		super(nickname, password, currentHp, maxHp, statistics, equipment);
		
	}
	public ArrayList<Item> Battle(Player player) {
		return null;
	}
	public Wand getWeapon() {
		return weapon;
	}
	public void setWeapon(Wand weapon) {
		this.weapon = weapon;
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

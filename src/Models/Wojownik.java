package Models;

import java.util.ArrayList;

public class Wojownik extends Player {
    private DefensiveItem def;
    private AttackItem weapon;
	public Wojownik(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,
			Equipment equipment) {
		super(nickname, password, currentHp, maxHp, statistics, equipment);
	
	}
	public ArrayList<Item> Battle(Player player) {
		return null;
	}
	public DefensiveItem getDef() {
		return def;
	}
	public void setDef(DefensiveItem def) {
		this.def = def;
	}
	public AttackItem getWeapon() {
		return weapon;
	}
	public void setWeapon(AttackItem weapon) {
		this.weapon = weapon;
	}

}

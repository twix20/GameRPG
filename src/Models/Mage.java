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

	private AttackItem weapon;

	private DefensiveItem def;

	public Mage() {}

	public Mage(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		super(nickname, password, currentHp, maxHp, equipment);
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

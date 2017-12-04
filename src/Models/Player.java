package Models;

import javax.persistence.*;

import Pole_walki.Battlefield;

@Entity
public class Player extends AppUser {

	@Column(name = "CurrentHp")
	protected int currentHp;

	@Column(name = "MaxHp")
	protected int maxHp;

	// TODO
	@Transient
	protected Equipment equipment;

	public Battlefield battle(Player player) {
		return null;
	}

	public Player() { }

	public Player(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.equipment = equipment;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public Equipment getEquipment() {
		return equipment;
	}
}

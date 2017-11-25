package Models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Pole_walki.Battlefield;
import Sklep.Shop;

@Entity
@DiscriminatorValue("PLAYER")
public class Player extends AppUser{
	
	@Column(name = "CurrentHp")
	protected int currentHp;
	
	@Column(name = "MaxHp")
	protected int maxHp;
	
	//TODO
	protected StatisticsBag statistics;
	protected Equipment equipment;
	
	public Battlefield battle(Player player) {
		return null;
	}
	public Shop shopping() {
		return null;
	}
	
	public Player() {}
	
	public Player(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.statistics  = statistics;
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
	public StatisticsBag getStatistics() {
		return statistics;
	}
	public Equipment getEquipment() {
		return equipment;
	}
}

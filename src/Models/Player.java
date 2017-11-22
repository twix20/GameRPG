package Models;

import java.io.Serializable;

public class Player implements Serializable{
	private static final long serialVersionUID = 3629527181951999234L;

	protected int id;
	protected String nickname;
	protected String password;
	
	protected int currentHp;
	protected int maxHp;
	
	protected StatisticsBag statistics;
	protected Equipment equipment;
	
	public Player(String nickname, String password, int currentHp, int maxHp, StatisticsBag statistics,Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.statistics  = statistics;
		this.equipment = equipment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

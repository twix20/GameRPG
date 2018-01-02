package Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PLAYER")
public class Player extends AppUser {

	@Column(name = "CurrentHp")
	protected int currentHp;

	@Column(name = "MaxHp")
	protected int maxHp;

	@Embedded
	protected Equipment equipment;
	
	public Player() { }

	public Player(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.equipment = equipment;
	}
	
	public int Battle(Player player) {
		int dmg = 0;
		for(PlayerItem item : this.getEquipment().getPlayerItems())
			if(item.getItem() instanceof AttackItem && item.isEquiped() == true) {
			dmg = 	item.getItem().getStatistics().getStatisticValue(StatisticTypeEnum.DealDmg);
			break;
			}
		return dmg;
	}

	public AttackItem getWeapon() {
		return null;
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

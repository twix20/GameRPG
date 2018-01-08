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
	
	public Player() {
		equipment = new Equipment();
	}

	public Player(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.equipment = equipment;
	}
	
	/// Returns damage to deal
	public int Battle(Player target) {
		int dmg = 2,  block = 0; 
		
		int dmgFromEquipment = this.getEquipment().GetSumEquipedStatistic(StatisticTypeEnum.DealDmg);
 		//Always deal at least 2 dmg
		if(dmgFromEquipment > 2)
			dmg = dmgFromEquipment;
		
		int targetDefFromEquipment = target.getEquipment().GetSumEquipedStatistic(StatisticTypeEnum.Def);
		block = targetDefFromEquipment;
		
 		int delta = dmg - block;
 		return delta <= 0 ? 2 : 50;//TODO do testow 50 hit
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

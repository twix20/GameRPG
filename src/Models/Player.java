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
	
	public Player() {}

	public Player(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		this.setCurrentHp(currentHp);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setMaxHp(maxHp);
		this.equipment = equipment;
	}
	
	public int Battle(Player player) {
		int dmg = 2, durabilityLoss = 10, block = 0; //dmg bez zbroji 2
		 		for(PlayerItem item : this.getEquipment().getPlayerItems()) {
		 			
		  			if(item.getItem() instanceof AttackItem && item.isEquiped() == true) {
		  			dmg = 	item.getItem().getStatistics().getStatisticValue(StatisticTypeEnum.DealDmg);
		 			item.setCurrentDurability(item.getCurrentDurability() - durabilityLoss);
		 			
		 			if(item.getCurrentDurability() <= 0)
		 				item.setEquiped(false);
		 			
		  			break;
		  			}
		 
				}
		 		
		 		for(PlayerItem item : player.getEquipment().getPlayerItems()) {
		 			if(item.getItem() instanceof DefensiveItem && item.isEquiped() == true) {
		 				block = item.getItem().getStatistics().getStatisticValue(StatisticTypeEnum.Def);
		 				item.setCurrentDurability(item.getCurrentDurability() - durabilityLoss);
		 				break;
		 			}
				}
		 		return dmg - block;
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

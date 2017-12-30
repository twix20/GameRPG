package Models;

import java.util.ArrayList;

import javax.persistence.*;
import Models.StatisticTypeEnum;
@Entity
@DiscriminatorValue("WARRIOR")
public class Warrior extends Player {

	public Warrior() {
	}

  private DefensiveItem def;
  private AttackItem weapon;
	public Warrior(String nickname, String password, int currentHp, int maxHp, Equipment equipment) {
		super(nickname, password, currentHp, maxHp, equipment);

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

}

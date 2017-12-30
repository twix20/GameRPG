package Models;

import java.util.ArrayList;

import javax.persistence.*;

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

    public boolean battle (Player player) {
    	boolean stillAlive = true;
    	if(player.getCurrentHp() - this.getWeapon().getDamage() <= 0)
    		stillAlive = false;
		return stillAlive;
    	
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

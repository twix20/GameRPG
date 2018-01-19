package Test.Fitnesse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import Models.Equipment;
import Models.HealingPotion;
import Models.Player;
import Models.PlayerItemId;
import Models.StatisticTypeEnum;
import Pole_walki.Battlefield;
public class HealFixture {
	private int beforeHeal;
	private int Heal;
public int afterHeal() {
		
		//Arrange
	    Battlefield battlefieldMock = mock(Battlefield.class);
		Player PlayerMock = mock(Player.class);
		
		when(PlayerMock.getMaxHpWithEquipment()).thenReturn(100);
		when(PlayerMock.getCurrentHp()).thenReturn(beforeHeal);
	
		when(battlefieldMock.changeHP(PlayerMock, Heal)).thenCallRealMethod();	
		
		//Act
		int heal = battlefieldMock.changeHP(PlayerMock, Heal);
		
		return heal;
	}

	public void setBeforeHeal(int beforeHeal) {
		this.beforeHeal = beforeHeal;
	}

	public void setHeal(int Heal) {
		this.Heal = Heal;
	}
}

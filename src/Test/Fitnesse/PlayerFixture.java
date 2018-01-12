package Test.Fitnesse;

import Models.Equipment;
import Models.Player;
import Models.StatisticTypeEnum;
import static org.mockito.Mockito.*;

public class PlayerFixture {
	private int attackerPlayerDmgFromEquipment;
	private int oponentPlayerDefFromEquipment;
	
	public int CalculateDmgToDeal() {
		
		//Arrange
		Player attackerPlayerMock = mock(Player.class);
		Equipment currentEquipmentMock = mock(Equipment.class);
		when(currentEquipmentMock.GetSumEquipedStatistic(StatisticTypeEnum.DealDmg)).thenReturn(attackerPlayerDmgFromEquipment);
		when(attackerPlayerMock.getEquipment()).thenReturn(currentEquipmentMock);
		when(attackerPlayerMock.CalculateDmgToDeal(any())).thenCallRealMethod();
		
		Player oponentPlayerMock = mock(Player.class);
		Equipment oponentEquipmentMock = mock(Equipment.class);
		when(oponentEquipmentMock.GetSumEquipedStatistic(StatisticTypeEnum.Def)).thenReturn(oponentPlayerDefFromEquipment);
		when(oponentPlayerMock.getEquipment()).thenReturn(oponentEquipmentMock);
		
		//Act
		int actualDmgToDeal = attackerPlayerMock.CalculateDmgToDeal(oponentPlayerMock);
		
		return actualDmgToDeal;
	}
	

	public void setAttackerPlayerDmgFromEquipment(int attackerPlayerDmgFromEquipment) {
		this.attackerPlayerDmgFromEquipment = attackerPlayerDmgFromEquipment;
	}

	public void setOponentPlayerDefFromEquipment(int oponentPlayerDefFromEquipment) {
		this.oponentPlayerDefFromEquipment = oponentPlayerDefFromEquipment;
	}

}

package Pole_walki;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Models.HealingPotion;
import Models.Player;
import Models.PlayerItem;
import Models.Spear;
import Models.StatisticsBag;

class BattlefieldTest {

	@Test
	void AttackTest() {
		Player player1 = new Player();
		int dmg = 20;
		Spear spear1 = new Spear("spear1", 10, new StatisticsBag(), dmg);
		player1.getEquipment().getPlayerItems().add(new PlayerItem(spear1, player1));
		PlayerItem playerSpear = player1.getEquipment().getPlayerItems().iterator().next();
		playerSpear.setEquiped(true);
		
		
		Player player2 = new Player();
		player2.setMaxHp(100);
		player2.setCurrentHp(100);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		
		Battlefield battlefield = new Battlefield(players);
		battlefield.setWhoseTurn(player1);
		
		battlefield.Attack();
		assertEquals(true, player2.getCurrentHp() < 100);	
		assertEquals(player2, battlefield.getWhoseTurn());
		}
	@Test
	void RestTest() {
		Player player1 = new Player();
		player1.setMaxHp(100);
		player1.setCurrentHp(50);
		
		Player player2 = new Player();
		
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		
		Battlefield battlefield = new Battlefield(players);
		battlefield.setWhoseTurn(player1);
		
		battlefield.Rest();
		assertEquals(70, player1.getCurrentHp());	
		
		}
	@Test
	void UseTest() {
		Player player1 = new Player();
		player1.setMaxHp(100);
		player1.setCurrentHp(10);
		
		Player player2 = new Player();
		
		HealingPotion potion = new HealingPotion();
		potion.setHealing(50);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		
		Battlefield battlefield = new Battlefield(players);
		battlefield.setWhoseTurn(player1);
		
		battlefield.Use(potion);
		assertEquals(60, player1.getCurrentHp());	
		
		}

}

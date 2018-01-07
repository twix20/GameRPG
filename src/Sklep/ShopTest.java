package Sklep;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Models.AttackItem;
import Models.Item;
import Models.Player;
import Models.PlayerItem;
import Models.Spear;
import Models.StatisticsBag;

class ShopTest {

	@Test
	void BuyHasEnoughGoldTest() {
		Spear spear1 = new Spear("spear1", 10, new StatisticsBag(), 20);
		Spear spear2 = new Spear("spear2", 20, new StatisticsBag(), 30);
		ArrayList<Item> depot = new ArrayList<>();
		depot.add(spear1);
		depot.add(spear2);
		Shop shop = new Shop(depot);
		
		Player player = new Player();
		player.getEquipment().setGold(100);
		
		shop.buy(player, spear1);
		assertEquals(spear2, shop.getDepot().get(0));
		
		for(PlayerItem item : player.getEquipment().getPlayerItems())
			assertEquals(item.getItem(), spear1);		
	}
	
	@Test
	void BuyHasNotEnoughGoldTest() {
		Spear spear1 = new Spear("spear1", 10, new StatisticsBag(), 20);
		Spear spear2 = new Spear("spear2", 20, new StatisticsBag(), 30);
		ArrayList<Item> depot = new ArrayList<>();
		depot.add(spear1);
		depot.add(spear2);
		Shop shop = new Shop(depot);
		
		Player player = new Player();
		player.getEquipment().setGold(5);
		
		shop.buy(player, spear1);
		assertEquals(spear1, shop.getDepot().get(0));
		assertEquals(0, player.getEquipment().getPlayerItems().size());		
	}
	
	@Test
	void SellTest() {
		Spear spear1 = new Spear("spear1", 10, new StatisticsBag(), 20);
		ArrayList<Item> depot = new ArrayList<>();
			
		Shop shop = new Shop(depot);
		
		Player player = new Player();
		player.getEquipment().setGold(0);
		player.getEquipment().getPlayerItems().add(new PlayerItem(spear1, player));
		
		shop.sell(player, spear1);
		assertEquals(5, player.getEquipment().getGold());

	}

}

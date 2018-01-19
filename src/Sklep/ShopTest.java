package Sklep;
//import org.junit.jupiter.api.Test;

import DataAccessLayer.DataBase;
import DataAccessLayer.RepositoryFactory;
import Models.Player;
import Models.PlayerItem;
import Models.Spear;
import Models.StatisticsBag;
//import static org.mockito.Mockito.*;

class ShopTest {

	/*@Test
	void BuyHasEnoughGoldTest() {
		Shop shop = mock(Shop.class);
		
		Player player = mock(Player.class);
		player.getEquipment().setGold(100);
		
		Spear spear = new Spear("spear", 20, new StatisticsBag(), 30);
		shop.ItemBuy(player, spear);
		assertEquals(80, player.getEquipment().getGold());
		
		for(PlayerItem item : player.getEquipment().getPlayerItems())
			assertEquals(item.getItem(), spear);
	}*/

	/*
	@Test
	void BuyHasEnoughGoldTest() {
		Shop shop = new Shop();
		
		Player player = new Player();
		player.getEquipment().setGold(100);
		
		Spear spear = new Spear("spear", 20, new StatisticsBag(), 30);
		shop.ItemBuy(player, spear);
		assertEquals(80, player.getEquipment().getGold());
		
		for(PlayerItem item : player.getEquipment().getPlayerItems())
			assertEquals(item.getItem(), spear);
	}
	
	@Test
	void BuyHasNotEnoughGoldTest() {
		Shop shop = new Shop();
		
		Player player = new Player();
		player.getEquipment().setGold(10);
		
		Spear spear = new Spear("spear", 20, new StatisticsBag(), 30);
		shop.ItemBuy(player, spear);
		assertEquals(10, player.getEquipment().getGold());
		
		for(PlayerItem item : player.getEquipment().getPlayerItems())
			assertNotEquals(item.getItem(), spear);
	}
	
	@Test
	void SellTest() {
		Shop shop = new Shop();
		
		Player player = new Player();
		player.getEquipment().setGold(100);
		
		Spear spear = new Spear("spear", 20, new StatisticsBag(), 30);
		shop.ItemSell(player, spear);
		assertEquals(130, player.getEquipment().getGold());
		
		for(PlayerItem item : player.getEquipment().getPlayerItems())
			assertNotEquals(item.getItem(), spear);
	}*/
}

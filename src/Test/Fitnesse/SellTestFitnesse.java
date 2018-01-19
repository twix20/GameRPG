package Test.Fitnesse;

import Models.Item;
import Models.Player;
import Models.PlayerItem;
import Models.PlayerItemId;
import Models.Spear;
import Sklep.Shop;

public class SellTestFitnesse {
	private int gold;
	private int itemsPrice;
	private Player player;
	private boolean sold;
	
	public boolean SellTest() {
		Shop shop = new Shop();
		player = new Player();
		player.getEquipment().setGold(gold);
		Item spear = new Spear();
		spear.setPrice(itemsPrice);
		
		PlayerItemId pk = new PlayerItemId();
		pk.setItem(spear);
		pk.setPlayer(player);		
		PlayerItem newItem = new PlayerItem();
		newItem.setPk(pk);
		newItem.setEquiped(false);
		newItem.setCustomItemName(null);
		player.getEquipment().getPlayerItems().add(newItem);
		
		shop.ItemSell(player, spear);
		
		sold = true;
		for (PlayerItem p : player.getEquipment().getPlayerItems()) {
			if (p.equals(newItem)) {
				sold = false;
				break;
			}
		}
		MoneyLeft();
		return sold;	
	}
	
	public void setPlayersGold(int gold) {
		this.gold = gold;
	}

	public void setItemsPrice(int itemsPrice) {
		this.itemsPrice = itemsPrice;
	}
		
	public int MoneyLeft() {
		return player.getEquipment().getGold();
	}
}

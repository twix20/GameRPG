package Test.Fitnesse;

import Models.Equipment;
import Models.Item;
import Models.Player;
import Models.PlayerItem;
import Models.PlayerItemId;
import Models.Spear;
import Sklep.Shop;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import GUI.Statement;

public class BuyTestFitnesse {
	private int gold;
	private int itemsPrice;
	private Player player;
	private boolean bought;
	
	public String BuyHasEnoughGoldTest() {
		Shop shop = new Shop();
		player = new Player();
		player.getEquipment().setGold(gold);
		Item spear = new Spear();
		spear.setPrice(itemsPrice);

		Statement komunikat = shop.ItemBuy(player, spear);
		MoneyLeft();
		
		bought = true;
		PlayerItem playerItem = player.getEquipment().getPlayerItemByItemId(spear.getId());
		if(playerItem == null) //Player nie ma tego przedmiotu
			bought = false;
		
		return komunikat.getInformation();
		
		/*Shop shopMock = mock(Shop.class);
		Item spearMock = mock(Spear.class);
		Player playerMock = mock(Player.class);
		Equipment equipmentMock = mock(Equipment.class);
		when(playerMock.getEquipment()).thenReturn(equipmentMock);
		when(playerMock.getEquipment().getGold()).thenReturn(gold);
		when(spearMock.getPrice()).thenReturn(itemsPrice);
		when(shopMock.ItemBuy(playerMock, spearMock)).thenCallRealMethod();

		Statement komunikat = shopMock.ItemBuy(playerMock, spearMock);
		player = playerMock;
		MoneyLeft();
		return komunikat.getInformation();*/
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
	
	public boolean Bought() {
		return bought;
	}
}

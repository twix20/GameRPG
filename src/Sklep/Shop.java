package Sklep;

import java.util.ArrayList;

import Models.Item;
import Models.Player;
import Models.PlayerItem;

public class Shop {
    private ArrayList<Item> depot;
    private Player player;
	public Shop(ArrayList<Item> depot) {
		this.setDepot(depot);
		// TODO pobrac depot z bazy
	}
	public Item buy(Player player, Item item){
		if(player.getEquipment().getGold() - item.getPrice() >= 0)
		{
			player.getEquipment().setGold(player.getEquipment().getGold() - item.getPrice());
			depot.remove(item);
			player.getEquipment().getPlayerItems().add(new PlayerItem(item, player));	
	
	    } else {
	    	//gui msg ze nie posiada wystarczajaco monet
	    	
	    }
		return item;
	}
	public Item sell(Player player, Item item){	
			player.getEquipment().getPlayerItems().remove(item);
			player.getEquipment().setGold(player.getEquipment().getGold() + (item.getPrice()/2));
			return item;
	}

	public void showDepod() {
		//gui
		
	}
	public void leaveShop() {
		//TODO zapisac zmiany depot do bazy
	}
	public ArrayList<Item> getDepot() {
		return depot;
	}
	public void setDepot(ArrayList<Item> depot) {
		this.depot = depot;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

}

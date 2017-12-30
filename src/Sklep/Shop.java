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
	public Item buy(Player player, int index){
		Item item = depot.get(index);
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
	public Item sell(Player player, int index){
		PlayerItem it = null;
			for(int i = 0; i < index; i++)
				it = player.getEquipment().getPlayerItems().iterator().next();
			player.getEquipment().getPlayerItems().remove(it);
			player.getEquipment().setGold(player.getEquipment().getGold() + (it.getItem().getPrice()/2));
			return it.getItem();
	}
	public Item repair(Player player, int index){
		PlayerItem it = null;
		for(int i = 0; i < index; i++)
			it = player.getEquipment().getPlayerItems().iterator().next();
		int cost = 100 - it.getCurrentDurability();
		if(player.getEquipment().getGold() - cost >= 0) {
		player.getEquipment().setGold(player.getEquipment().getGold() - cost );
		it.setCurrentDurability(100);
		player.getEquipment().getPlayerItems().add(it);
		}
		return it.getItem();
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

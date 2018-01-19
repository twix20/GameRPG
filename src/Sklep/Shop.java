package Sklep;

import java.util.ArrayList;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import GUI.Statement;
import Models.AppUser;
import Models.Item;
import Models.Player;
import Models.PlayerItem;
import Models.PlayerItemId;

public class Shop {
    //private ArrayList<Item> depot;
    //private Player player;
	private DataBase db;
    
    public Shop(DataBase db) {
    	this.db = db;
    }
    public Shop() {
    	this.db = null;
    }
    
	/*public Shop(ArrayList<Item> depot) {
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
	}*/
	
	public Statement ItemBuy(AppUser user, Item item) {
		if(!(user instanceof Player))
			return new Statement("error");
		
		Player player = (Player)user;
		int currentGold = player.getEquipment().getGold();
		
		int balanceAfterPurchase = currentGold - item.getPrice();
		if(balanceAfterPurchase < 0)//Za malo pieniedzy
			return new Statement("error");
		
		
		//Sprawdzenie czy juz nie posiada przedmiotu
		PlayerItem pi = player.getEquipment().getPlayerItemByItemId(item.getId());
		if(pi != null)
			return new Statement("error");
		
		PlayerItemId pk = new PlayerItemId();
		pk.setItem(item);
		pk.setPlayer(player);
		
		PlayerItem newItem = new PlayerItem();
		newItem.setPk(pk);
		newItem.setEquiped(false);
		newItem.setCustomItemName(null);
		
		player.getEquipment().setGold(balanceAfterPurchase);
		player.getEquipment().getPlayerItems().add(newItem);
		
		if (db != null) {
			AccountRepository accRepo = db.getAccountRepository();
			accRepo.SaveOrUpdate(player);
		}
		
		// TODO Auto-generated method stub
		return new Statement("ok"); // analogiczne zwracane wartosci co przy przy rejestracji
		
	}

	public void ItemSell(AppUser user, Item item) {
		if(!(user instanceof Player))
			return;
		
		Player player = (Player)user;
		PlayerItem playerItem = player.getEquipment().getPlayerItemByItemId(item.getId());
		
		if(playerItem == null) //Player nie ma tego przedmiotu
			return;
		
		int currentGold = player.getEquipment().getGold();
		int goldAfterSell = currentGold + item.getPrice();
		
		player.getEquipment().setGold(goldAfterSell);
		player.getEquipment().getPlayerItems().remove(playerItem);
		
		if (db != null) {
			AccountRepository accRepo = db.getAccountRepository();
			accRepo.SaveOrUpdate(player);
		}
	}

	/*public ArrayList<Item> getDepot() {
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
	}*/

}

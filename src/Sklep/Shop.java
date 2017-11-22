package Sklep;

import java.util.ArrayList;

import Models.Item;
import Models.Player;

public class Shop {
    private ArrayList<Item> depot;
    private Player player;
	public Shop(ArrayList<Item> depot) {
		this.setDepot(depot);
	}
	public ArrayList<Item> buy(Player player, int index){
		return null;
	}
	public Item sell(Player player, int index){
		return null;
	}
	public Item repair(Player player, int index){
		return null;
	}
	public void showDepod() {
		
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

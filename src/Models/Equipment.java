package Models;

import java.util.ArrayList;

public class Equipment {
	private int gold;
	private ArrayList<Item> items;
	
	public Equipment() {
		this.items = new ArrayList<Item>();
	}
	
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	public void removeItem(int itemId) {
		this.items.removeIf(i -> i.getId() == itemId);
	}

}

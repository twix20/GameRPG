package Models;


import java.util.*;

import javax.persistence.*;


public class Equipment {
	
	@Column(name = "Gold")
	private int gold;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.player")
	private Set<PlayerItem> playerItems = new HashSet<>();
	
	public Equipment() {}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public Set<PlayerItem> getPlayerItems() {
		return this.playerItems;
	}
	public void setPlayerItems(Set<PlayerItem> playerItems) {
		this.playerItems = playerItems;
	}

}

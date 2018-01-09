package Models;


import java.util.*;

import javax.persistence.*;


public class Equipment {
	
	@Column(name = "Gold")
	private int gold;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.player", cascade=CascadeType.ALL)
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
	
	public PlayerItem getPlayerItemByItemId(int itemId) {
		for(PlayerItem pi : getPlayerItems()) {
			
			if(pi.getItem().getId() == itemId)
				return pi;
		}
		
		return null;
	}
	
	public void removePlayerItem(int itemId) {
		PlayerItem itemToRemove = getPlayerItemByItemId(itemId);
		
		if(itemToRemove != null)
			this.playerItems.remove(itemToRemove);
	}
	
	public int GetSumEquipedStatistic(StatisticTypeEnum stat) {
		int totalStatValue = 0;
		
		for(PlayerItem playerItem : this.playerItems) {
			if(playerItem.isEquiped() == false) continue;
			
			if(stat == StatisticTypeEnum.DealDmg && playerItem.getItem() instanceof AttackItem) {
				totalStatValue += ((AttackItem)(playerItem.getItem())).getDamage();
			}
			
			if(stat == StatisticTypeEnum.Def && playerItem.getItem() instanceof DefensiveItem) {
				totalStatValue += ((DefensiveItem)(playerItem.getItem())).getDefDamage();
			}
			
			totalStatValue += playerItem.getItem().getStatistics().getStatisticValue(stat);
		}
		
		return totalStatValue;
	}

}

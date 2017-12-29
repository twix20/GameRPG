package Models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PlayerItemId implements Serializable {
	
	@ManyToOne
	private Player player;
	
	@ManyToOne
	private Item item;

	
	public PlayerItemId(Player player, Item item){
		this.setItem(item);
		this.setPlayer(player);
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}

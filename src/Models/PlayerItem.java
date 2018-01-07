package Models;

import javax.persistence.*;

@Entity
@Table(name = "Player_Item_XREF")
@AssociationOverrides({
	@AssociationOverride(name = "pk.item",
		joinColumns = @JoinColumn(name = "Item_Id")),
	@AssociationOverride(name = "pk.player",
		joinColumns = @JoinColumn(name = "Player_Id")) })
public class PlayerItem {
	
	public PlayerItem() {}
	public PlayerItem(Item item, Player player) {
		this.setCustomItemName(item.getName());
		this.setEquiped(false);
		this.setPk(new PlayerItemId(item, player)); 
		this.setItem(item);
		
		
	}
	
	@EmbeddedId
	private PlayerItemId pk;
	
	@Column(name = "CustomItemName")
	private String customItemName;
	
	@Column(name = "IsEquiped")
	private boolean isEquiped;
	
	
	
	
	@Transient
	public Item getItem() {
		return getPk().getItem();
	}
	public void setItem(Item item) {
		getPk().setItem(item);
	}
	
	
	@Transient
	public Player getPlayer() {
		return getPk().getPlayer();
	}
	public void setItem(Player player) {
		getPk().setPlayer(player);
	}
	public String getCustomItemName() {
		return customItemName;
	}
	public void setCustomItemName(String customItemName) {
		this.customItemName = customItemName;
	}
	public boolean isEquiped() {
		return isEquiped;
	}
	public void setEquiped(boolean isEquiped) {
		this.isEquiped = isEquiped;
	}
	
	
	public PlayerItemId getPk() {
		return pk;
	}
	
	public void setPk(PlayerItemId pk) {
		this.pk = pk;
	}
}

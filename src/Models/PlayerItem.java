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
	
	@EmbeddedId
	private PlayerItemId pk = new PlayerItemId();
	
	@Column(name = "CustomItemName")
	private String customItemName;
	
	@Column(name = "IsEquiped")
	private boolean isEquiped;
	
	@Column(name = "CurrentDurability")
	private Integer currentDurability;
	
	
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
	public Integer getCurrentDurability() {
		return currentDurability;
	}
	public void setCurrentDurability(Integer currentDurability) {
		this.currentDurability = currentDurability;
	}
	
	public PlayerItemId getPk() {
		return pk;
	}
	
	public void setPk(PlayerItemId pk) {
		this.pk = pk;
	}
}

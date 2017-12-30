package Models;

import java.util.Date;

import javax.persistence.*;

import Pole_walki.Battlefield;

@Entity
@Table(name = "BattlefieldActionsHistory")
public class BattlefieldActionsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	private int Id;

	@Column(name = "ActionDate")
	private Date ActionDate;

	@Column(name = "ActionDescription")
	private String ActionDescription;
	
	@Column(name="Value")
	private int Value;

	@ManyToOne
	@JoinColumn(name = "Battlefield_Id", foreignKey = @ForeignKey(name = "BfActionsHistory_Bf"))
	private BattlefieldHistory battlefieldHistory;

	@ManyToOne
	@JoinColumn(name = "ActionBy_Player_Id", foreignKey = @ForeignKey(name = "BfActionsHistory_Player"))
	private Player ActionByPlayer;
	
	public  BattlefieldActionsHistory() {}
	public  BattlefieldActionsHistory(Player player, String description, int value) {
		this.setActionByPlayer(player);
		this.setActionDate(new Date());
		this.setActionDescription(description);
		this.setValue(value);
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getActionDate() {
		return ActionDate;
	}

	public void setActionDate(Date actionDate) {
		ActionDate = actionDate;
	}

	public String getActionDescription() {
		return ActionDescription;
	}

	public void setActionDescription(String actionDescription) {
		ActionDescription = actionDescription;
	}
	
	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	public BattlefieldHistory getBattlefield() {
		return battlefieldHistory;
	}

	public void setBattlefield(BattlefieldHistory battlefield) {
		battlefieldHistory = battlefield;
	}

	public Player getActionByPlayer() {
		return ActionByPlayer;
	}

	public void setActionByPlayer(Player actionByPlayer) {
		ActionByPlayer = actionByPlayer;
	}
}

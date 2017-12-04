package Models;

import java.util.Date;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "Battlefield_Id", foreignKey = @ForeignKey(name = "BfActionsHistory_Bf"))
	private BattlefieldHistory battlefieldHistory;

	@ManyToOne
	@JoinColumn(name = "ActionBy_Player_Id", foreignKey = @ForeignKey(name = "BfActionsHistory_Player"))
	private Player ActionByPlayer;
	

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

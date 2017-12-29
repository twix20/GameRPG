package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "BattlefieldHistory")
public class BattlefieldHistory {

	@Id
	@Column(name = "Id")
	private int id;

	@Column(name = "FightStartDate")
	private Date fightStartDate;

	@Column(name = "FightEndDate")
	private Date fightEndDate;

	@ManyToOne
	@JoinColumn(name = "WhoWon_Player_Id", foreignKey = @ForeignKey(name = "Bf_Player_WhoseTurn"))
	private Player whoWonPlayerId;

	@ManyToOne
	@JoinColumn(name = "Player1_Id", foreignKey = @ForeignKey(name = "Bf_Player1"))
	private Player player1;

	@ManyToOne
	@JoinColumn(name = "Player2_Id", foreignKey = @ForeignKey(name = "Bf_Player2"))
	private Player player2;

	@OneToMany(mappedBy = "battlefieldHistory")
	private List<BattlefieldActionsHistory> actions;
	

	public BattlefieldHistory(){}
	
	public BattlefieldHistory(Player pl1, Player pl2) {
		this.setFightStartDate(new Date());
		this.setPlayer1(pl1);
		this.setPlayer2(pl2);
		this.actions = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFightStartDate() {
		return fightStartDate;
	}

	public void setFightStartDate(Date fightStartDate) {
		this.fightStartDate = fightStartDate;
	}

	public Date getFightEndDate() {
		return fightEndDate;
	}

	public void setFightEndDate(Date fightEndDate) {
		this.fightEndDate = fightEndDate;
	}

	public Player getWhoWonPlayerId() {
		return whoWonPlayerId;
	}

	public void setWhoWonPlayerId(Player whoWonPlayerId) {
		this.whoWonPlayerId = whoWonPlayerId;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public List<BattlefieldActionsHistory> getActions() {
		return actions;
	}
	
	public void setActions(List<BattlefieldActionsHistory> actions) {
		this.actions = actions;
	}
}

package Models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@OneToMany(mappedBy = "battlefieldHistory", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<BattlefieldActionsHistory> actions;
	

	public BattlefieldHistory() {
		this.setActions(new HashSet<>());
	}
	public BattlefieldHistory(Player player1, Player player2) {
		this.setActions(new HashSet<>());
		this.setFightStartDate(new Date());
		this.setPlayer1(player1);
		this.setPlayer2(player2);
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
	
	public Set<BattlefieldActionsHistory> getActions() {
		return actions;
	}
	
	public void setActions(Set<BattlefieldActionsHistory> actions) {
		this.actions = actions;
	}
}

package Models;

import java.util.Date;

public class BattleFieldHistory {
	private int id;
	private Date fightStartDate;
	private Date fightEndDate;
	private int player1_Id;
	private int player2_IdL;
	
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

	public int getPlayer1_Id() {
		return player1_Id;
	}
	public void setPlayer1_Id(int player1_Id) {
		this.player1_Id = player1_Id;
	}
	public int getPlayer2_IdL() {
		return player2_IdL;
	}
	public void setPlayer2_IdL(int player2_IdL) {
		this.player2_IdL = player2_IdL;
	}
}

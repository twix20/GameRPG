package Models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Battlefield")
public class BattleFieldHistory {
	
        @Id
        @Column(name ="Id")
        private int id;
        
        @Column(name ="FightStartDate")
	private Date fightStartDate;
        
        @Column(name ="FightEndDate")
	private Date fightEndDate;
        
        @Column(name ="WhoWon_Player_Id")
        private String whoWonPlayerId;
        
        @Column(name ="Player1_Id")
	private String player1_Id;
	
        @Column(name ="Player2_Id")
        private String player2_IdL;
	
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

	public String getPlayer1_Id() {
		return player1_Id;
	}
	public void setPlayer1_Id(String player1_Id) {
		this.player1_Id = player1_Id;
	}
	public String getPlayer2_IdL() {
		return player2_IdL;
	}
	public void setPlayer2_IdL(String player2_IdL) {
		this.player2_IdL = player2_IdL;
	}
               
    public String getWhoWonPlayerId() {
        return whoWonPlayerId;
    }

    public void setWhoWonPlayerId(String whoWonPlayerId) {
        this.whoWonPlayerId = whoWonPlayerId;
    }
}

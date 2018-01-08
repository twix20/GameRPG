package Pole_walki;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import DataAccessLayer.BattleFieldHistoryRepository;
import DataAccessLayer.DataBase;
import Models.BattlefieldActionsHistory;
import Models.BattlefieldHistory;
import Models.HealingPotion;
import Models.Player;
import Models.UseableItem;

public class Battlefield {
    private ArrayList<Player> players;
    private Player whoseTurn;
    private BattlefieldHistory history;
    private DataBase db;
    
	public Battlefield(DataBase db, ArrayList<Player> players) {
		this.db = db;
		
		this.setPlayers(players);
		Random rand = new Random();
		this.setWhoseTurn(rand.nextInt(100) < 50 ? players.get(0) : players.get(1));
		history = new BattlefieldHistory(players.get(0), players.get(1));
	}
	public boolean Attack() {
		int dmg = GetCurrentPlayerDmg();	
		boolean stillAlive = this.getAnotherPlayer().getCurrentHp() - dmg >= 0;
		
	     if(stillAlive) {
	    	 this.changeHP(this.getAnotherPlayer(), - dmg);
	    	 
	    	 this.AppendActionHistory(new BattlefieldActionsHistory(this.getWhoseTurn(),"attack", dmg ));
	    	 this.changeTurn();
	     } else {
	    	 this.endBattle();
	     }

	  return stillAlive;
	}
	
	public int GetCurrentPlayerDmg() {
		return this.getWhoseTurn().Battle(getAnotherPlayer());
	}
	
	public void Use(HealingPotion item) {
		
		BattlefieldActionsHistory action = item.Use(this.getWhoseTurn());
		this.AppendActionHistory(action);
		
		this.getWhoseTurn().getEquipment().getPlayerItems().remove(item);
		this.changeTurn();	
		
	}
	
	public void Rest() {
		this.changeHP(this.getWhoseTurn(),20);
	
	   	this.AppendActionHistory(new BattlefieldActionsHistory(this.getWhoseTurn(),"rest", 20));
		this.changeTurn();	
	}
	
	public void changeHP(Player player, int howMany) {	
		player.setCurrentHp(this.getWhoseTurn().getCurrentHp() + howMany);
	}
	
	public void endBattle() {
		this.getHistory().setFightEndDate(new Date());
		this.getHistory().setWhoWonPlayerId(this.getWhoseTurn());
		
		int reward = 10;
 		if(this.getAnotherPlayer().getEquipment().getGold() - reward <= 0)
 			this.getAnotherPlayer().getEquipment().setGold(0);
 		else
 			this.getAnotherPlayer().getEquipment().setGold(this.getAnotherPlayer().getEquipment().getGold() - reward);	
 		this.getWhoseTurn().getEquipment().setGold(this.getWhoseTurn().getEquipment().getGold() + reward);
 		
 		
 		//Save in db
 		BattleFieldHistoryRepository bfRepo = db.getBattleFieldHistoryRepository();
 		bfRepo.SaveOrUpdate(getHistory());
	}
	
	public String changeTurn() {
		this.setWhoseTurn(getAnotherPlayer());
		if (this.whoseTurn.equals(players.get(0)))
			return "T1";
		else return "T0";
	}
	public Player getAnotherPlayer() {
		return this.getPlayers().get(0).equals(this.getWhoseTurn()) ? this.getPlayers().get(1) : this.getPlayers().get(0);	
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Player getWhoseTurn() {
		return whoseTurn;
	}
	public void setWhoseTurn(Player whoseTurn) {
		this.whoseTurn = whoseTurn;
	}
	public BattlefieldHistory getHistory() {
		return history;
	}
	
	public void AppendActionHistory(BattlefieldActionsHistory action) {
		action.setBattlefield(getHistory());
		
		getHistory().getActions().add(action);
	}
	
	public void setHistory(BattlefieldHistory history) {
		this.history = history;
	}
	

}

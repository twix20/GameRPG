package Pole_walki;

import java.util.ArrayList;
import java.util.Date;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.BattleFieldHistoryRepository;
import DataAccessLayer.DataBase;
import Models.BattlefieldActionsHistory;
import Models.BattlefieldHistory;
import Models.Player;
import Models.PlayerItem;
import Models.UseableItem;

public class Battlefield {
    private ArrayList<Player> players;
    private Player whoseTurn;
    private BattlefieldHistory history;
    private DataBase db;
    
	public Battlefield(DataBase db, ArrayList<Player> players) {
		this.db = db;
		
		this.setPlayers(players);
		players.get(0).setCurrentHp(players.get(0).getMaxHpWithEquipment());
		players.get(1).setCurrentHp(players.get(1).getMaxHpWithEquipment());
		
		this.history = new BattlefieldHistory(players.get(0), players.get(1));
	}
	public boolean Attack() {
		int dmg = GetCurrentPlayerDmg();
		
		int hpBeforeDmg = this.getAnotherPlayer().getCurrentHp();
		int hpAfterDmg = hpBeforeDmg - dmg;
		
		boolean stillAlive = hpAfterDmg > 0;
		
		this.AppendActionHistory(new BattlefieldActionsHistory(this.getWhoseTurn(),"attack", dmg ));
		
	     if(stillAlive) {
	    	 this.changeHP(this.getAnotherPlayer(), - dmg);
	    	 this.changeTurn();
	     } else {
	    	 this.endBattle();
	     }

	  return stillAlive;
	}
	
	public int GetCurrentPlayerDmg() {
		return this.getWhoseTurn().CalculateDmgToDeal(getAnotherPlayer());
	}
	
	public void Use(int itemId) {
		Player playerToUseOn = this.getWhoseTurn();

		PlayerItem playerItemToConsume = playerToUseOn.getEquipment().getPlayerItemByItemId(itemId);
		
		//Assume we can only use useableitem
		UseableItem itemToConsume = (UseableItem)playerItemToConsume.getItem();

		//Use item
		BattlefieldActionsHistory action = itemToConsume.Use(playerToUseOn);
		
		//Save log
		this.AppendActionHistory(action);
		
		//Remove item from player
		playerToUseOn.getEquipment().removePlayerItem(itemToConsume.getId());
		
		AccountRepository accRepo = db.getAccountRepository();
		accRepo.SaveOrUpdate(playerToUseOn);
		
		this.changeTurn();	
		
	}
	
	public void Rest() {
		this.changeHP(this.getWhoseTurn(), 20);
	
	   	this.AppendActionHistory(new BattlefieldActionsHistory(this.getWhoseTurn(),"rest", 20));
		this.changeTurn();	
	}
	
	public void changeHP(Player player, int howMany) {
		int maxHpWithEq = player.getMaxHpWithEquipment();
		
		int hpAfterRest = player.getCurrentHp() + howMany;
		
		if(hpAfterRest > maxHpWithEq)
			player.setCurrentHp(maxHpWithEq);
		else
			player.setCurrentHp(hpAfterRest);
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
 		RefreshPlayersHp();
 		
 		BattleFieldHistoryRepository bfRepo = db.getBattleFieldHistoryRepository();
 		bfRepo.SaveOrUpdate(getHistory());
 		bfRepo.Detach(getHistory());
	}
	
	private void RefreshPlayersHp() {
		AccountRepository accRepo = db.getAccountRepository();
		
		for(Player p : players) {
			p.setCurrentHp(p.getMaxHp());
			accRepo.SaveOrUpdate(p);
		}
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

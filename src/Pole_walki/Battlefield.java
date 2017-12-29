package Pole_walki;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import Models.BattlefieldActionsHistory;
import Models.BattlefieldHistory;
import Models.HealingPotion;
import Models.Item;
import Models.Player;
import Models.StatisticTypeEnum;
import Models.UseableItem;

public class Battlefield {
    private ArrayList<Player> players;
    private Player whoseTurn;
    private BattlefieldHistory history;
	public Battlefield(ArrayList<Player> players) {
		this.setPlayers(players);
		Random rand = new Random();
		this.setWhoseTurn(rand.nextInt(100) < 50 ? players.get(0) : players.get(1));
		history = new BattlefieldHistory(players.get(0), players.get(1));
	}
	public void Attack() {
		//this.getWhoseTurn().getEquipment().getPlayerItems().
		// pytanie z OOP
		// w jaki sposob dostac sie do metod Wojownika/Maga jezeli posiadamy
		// tylko playerow?
		
		//bo potrzebuje parametrow zbroji
	}
	
	public void Use(UseableItem item) {
	switch(item.toString()) {
	case "HealingPotion" :
		
	//	final int dbId = 1;
		//StatisticTypeEnum Hp = new StatisticTypeEnum(dbId);
		//this.regHP(item.getStatistics().getStatisticValue(new StatisticTypeEnum )
		// jak dostac value przedmiotu np. ilosc regenerowanego hp?
		// nie uzywalem wczsniej enumow, a w internecia sa jakis slabe przyklady
	}
			
	}
	public void Rest() {
		this.changeHP(this.getWhoseTurn(),20);
		this.getHistory().getActions().add(new BattlefieldActionsHistory("rest", this.getWhoseTurn(), 20));
		this.changeTurn();	
	}
	public void changeHP(Player player, int howMany) {	
		player.setCurrentHp(this.getWhoseTurn().getCurrentHp() + howMany);
	}
	public void endBattle() {
		this.getHistory().setFightEndDate(new Date());
		this.getHistory().setWhoWonPlayerId(this.getWhoseTurn());
	}
	public void changeTurn() {
		this.setWhoseTurn(this.getPlayers().get(0).equals(this.getWhoseTurn()) ? this.getPlayers().get(1) : this.getPlayers().get(0));	
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
	public void setHistory(BattlefieldHistory history) {
		this.history = history;
	}
	

}

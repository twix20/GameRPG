package Pole_walki;

import java.util.ArrayList;

import Models.BattleFieldHistory;
import Models.Item;
import Models.Player;

public class Battlefield {
    private ArrayList<Player> players;
    private Player whoseTurn;
    private BattleFieldHistory history;
	public Battlefield(ArrayList<Player> players) {
		this.setPlayers(players);
	}
	public void Attack(int playerId) {
		
	}
	public void Block() {
		
	}
	public void Move() {
		
	}
	public void Use(Item item) {
		
	}
	public void Rest() {
		
	}
	public void endBattle() {
		
	}
	public void changeTurn() {
		
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
	public BattleFieldHistory getHistory() {
		return history;
	}
	public void setHistory(BattleFieldHistory history) {
		this.history = history;
	}
	

}

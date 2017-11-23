package Pole_walki;

import java.util.ArrayList;

import Models.Item;
import Models.MatchHistory;
import Models.Player;

public class Battlefield {
    private ArrayList<Player> players;
    private Player whoseTurn;
    private MatchHistory history;
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
	public MatchHistory getHistory() {
		return history;
	}
	public void setHistory(MatchHistory history) {
		this.history = history;
	}

}

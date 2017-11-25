package Models;

import java.util.ArrayList;

public class MatchHistory {
    private int id;
    private ArrayList<Player> listOfPlayers;
    private ArrayList<Integer> damageDealedByPlayers;
    private ArrayList<Integer> hpHealedByPlayers;
    private ArrayList<Integer> goldEarndByPlayers;
	public MatchHistory(ArrayList<Player> listOfPlayers, ArrayList<Integer> damageDealedByPlayers,
			ArrayList<Integer> hpHealedByPlayers, ArrayList<Integer> goldEarndByPlayers) {
		this.setDamageDealedByPlayers(damageDealedByPlayers);
		this.setGoldEarndByPlayers(goldEarndByPlayers);
		this.setHpHealedByPlayers(hpHealedByPlayers);
		this.setListOfPlayers(listOfPlayers);
		}
    public void record() {
    	
    }
	public ArrayList<Player> getListOfPlayers() {
		return listOfPlayers;
	}
	public void setListOfPlayers(ArrayList<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	public ArrayList<Integer> getDamageDealedByPlayers() {
		return damageDealedByPlayers;
	}
	public void setDamageDealedByPlayers(ArrayList<Integer> damageDealedByPlayers) {
		this.damageDealedByPlayers = damageDealedByPlayers;
	}
	public ArrayList<Integer> getHpHealedByPlayers() {
		return hpHealedByPlayers;
	}
	public void setHpHealedByPlayers(ArrayList<Integer> hpHealedByPlayers) {
		this.hpHealedByPlayers = hpHealedByPlayers;
	}
	public ArrayList<Integer> getGoldEarndByPlayers() {
		return goldEarndByPlayers;
	}
	public void setGoldEarndByPlayers(ArrayList<Integer> goldEarndByPlayers) {
		this.goldEarndByPlayers = goldEarndByPlayers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

package GUI;

import Models.AppUser;

public class Statement {
	private String information;
	private int value;
	private AppUser user;
	
	public Statement(String information, AppUser user) {
		this.information = information;
		this.user = user;
	}
	public Statement(String information, int value) {
		this.information = information;
		this.value = value;
	}
	public Statement(String information) {
		this.information = information;
	}
	public Statement(int value) {
		this.value = value;
	}
	public Statement(AppUser user) {
		this.user = user;
	}
	
	public String getInformation() { return information; }
	public int getValue() { return value; }
	public AppUser getUser() { return user; }
}

package GUI;

import DataAccessLayer.DataBase;
import DataAccessLayer.RepositoryFactory;
import java.util.List;
import Models.*;

public class GameFacade {
	private DataBase db = new DataBase(new RepositoryFactory());
	private List<AppUser> allAccs = db.getAccountRepository().GetAll();
	
	
	public String RegisterUser(String accountName, String accountPassword) {
		// TODO
		return "failure"; //lub "success" jesli sie powiedzie operacja
	}
	
	public void ModifyItem(Item itemToChange, String name, String price, String basicAttributeValue, String whichSA, String specialAttributeValue) {
		// TODO
	}
	
	public void AddItem(String name, String price, String basicAttributeValue, String whichSA, String specialAttributeValue) {
		// TODO
	}
	
	public void RemoveItem(Item itemToRemove) {
		// TODO
	}
	
	
	public String VerifyAccount(String accountName, String accountPassword) {
		for (AppUser ap : allAccs) {
			System.out.println("\nName: |" + ap.getNickname() + "| Pass |" + ap.getPassword() + "|");
			if (accountName.equals(ap.getNickname()) && accountPassword.equals(ap.getPassword()))
				if (ap instanceof Player) {
					return "player";
				} else return "admin";
		}
		return "error";
	}
	
	
	public DataBase getDataBase() {
		return db;
	}
}

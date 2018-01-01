package GUI;

import DataAccessLayer.DataBase;
import DataAccessLayer.RepositoryFactory;
import java.util.List;
import DataAccessLayer.*;
import Models.*;

public class GameFacade {
	private DataBase db = new DataBase(new RepositoryFactory());
	private List<AppUser> allAccs = db.getAccountRepository().GetAll();
	
	
	public String VerifyAccount(String accountName, String accountPassword) {
		for (AppUser ap : allAccs) {
			System.out.println("\nName: |" + ap.getNickname() + "| Pass |" + ap.getPassword() + "|");
			if (accountName.equals(ap.getNickname()) && accountPassword.equals(ap.getPassword()))
				if (ap.getIsPlayer() == true) {
					return "player";
				} else return "admin";
		}
		return "error";
	}
}

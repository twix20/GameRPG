package Menu_uzytkownka;

import java.util.Date;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import Models.Admin;
import Models.AppUser;
import Models.Mage;
import Models.Warrior;

public class LoginScreen {
	private DataBase dataBase;
	public LoginScreen(DataBase dataBase){
		this.dataBase = dataBase;
	}
	public void register(String login, String password, String accountType) {
		
		AccountRepository accountRepo = dataBase.getAccountRepository();
		AppUser user = accountRepo.GetByLoginPassword(login, password);
		if(user == null) {
			
			AppUser userToDb = null;
			if(accountType == "WARRIOR") {
				Warrior warr = new Warrior();
				warr.setCurrentHp(100);
				warr.setMaxHp(100);
				userToDb = warr;
			}else if(accountType == "MAG") {
				Mage mag = new Mage();
				mag.setCurrentHp(100);
				mag.setMaxHp(100);
				userToDb = mag;
			}else if(accountType == "ADMIN") {
				Admin admin = new Admin();
				userToDb = admin;
			}
			
			userToDb.setType(accountType);
			userToDb.setNickname(login);
			userToDb.setPassword(password);
			userToDb.setRegisterDate(new Date());
			accountRepo.Add(userToDb);
		}
		
		// TODO gui wybor classy
		// w zaleznosci od wybranej classy dodajemy do ekwipunku
		// przedmity z bazy
		
		// mozna tu odrazu zaladowac postac z bazy jezeli taki player 
		// istnieje w bazie lub to jest Admin
		
		
		// na koncu tworzenie AppUsera
	}
}

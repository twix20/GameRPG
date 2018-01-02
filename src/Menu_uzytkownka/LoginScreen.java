package Menu_uzytkownka;

import java.util.Date;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import Models.Admin;
import Models.AppUser;
import Models.Player;

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
			if(accountType == "ADMIN") {
				Admin newAdmin = new Admin();
				userToDb = newAdmin;
			}else if(accountType == "PLAYER") {
				Player newPlayer = new Player();
				newPlayer.setCurrentHp(100);
				newPlayer.setMaxHp(100);
				//TODO: dodac przypisanie poczatkowych przedmiotow dla gracza
			}
			
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

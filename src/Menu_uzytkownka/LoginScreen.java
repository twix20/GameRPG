package Menu_uzytkownka;

import DataAccessLayer.DataBase;

public class LoginScreen {
	private DataBase dataBase;
	public LoginScreen(DataBase dataBase){
		this.dataBase = dataBase;
	}
	public void register(String login, String password) {
		// TODO sprawdzenie w bazie czy istnieje taki player
		// jezeli nie, to dodanie do bazy
		
		// TODO gui wybor classy
		// w zaleznosci od wybranej classy dodajemy do ekwipunku
		// przedmity z bazy
		
		// mozna tu odrazu zaladowac postac z bazy jezeli taki player 
		// istnieje w bazie lub to jest Admin
		
		
		// na koncu tworzenie AppUsera
	}
}

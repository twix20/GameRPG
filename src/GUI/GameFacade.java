package GUI;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import DataAccessLayer.ItemRepository;
import DataAccessLayer.RepositoryFactory;

import java.util.Date;
import java.util.List;
import java.util.Set;

import Models.*;

public class GameFacade {
	final String ACCOUNT_DOESNT_EXIST = "error"; 
	final String ACCOUNT_CREATION_SUCCESS = "success";
	
	private DataBase db = new DataBase(new RepositoryFactory());
	private List<AppUser> allAccs = db.getAccountRepository().GetAll();
	
	
	public Statement RegisterUser(String accountName, String accountPassword) {
		if (accountName.equals("") || accountPassword.equals(""))
			return new Statement(ACCOUNT_DOESNT_EXIST);
		
		String accountStatus = VerifyAccount(accountName, accountPassword).getInformation();
		
		if(accountStatus != ACCOUNT_DOESNT_EXIST)
			return new Statement(ACCOUNT_DOESNT_EXIST);
		
		Player newPlayer = new Player();
		newPlayer.setNickname(accountName);
		newPlayer.setPassword(accountPassword);
		newPlayer.setCurrentHp(100);
		newPlayer.setMaxHp(100);
		newPlayer.setRegisterDate(new Date());
		
		//TODO. add default item to player
		
		AccountRepository accRepo = getDataBase().getAccountRepository();
		accRepo.Add(newPlayer);
		
		return new Statement(ACCOUNT_CREATION_SUCCESS);
	}
	
	//DO POPRAWY
	public void ModifyItem(Item itemDb, String name, int price, StatisticsBag statisticsBag, int basicAttribute) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		
		//Item itemDb = itemRepo.GetById(itemIdToChange);
		
		//Set properties to update
		itemDb.setName(name);
		itemDb.setPrice(price);
		itemDb.setStatistics((Set<Statistic>) statisticsBag.values());
		if (itemDb instanceof AttackItem)
			((AttackItem)itemDb).setDamage(basicAttribute);
		else if (itemDb instanceof DefensiveItem)
			((DefensiveItem)itemDb).setDefDamage(basicAttribute);
		
		itemRepo.Update(itemDb);
	}
	
	//PRAWDOPODOBNIE TEZ DO POPRAWY
	public void AddItem(Item itemToAdd) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		itemRepo.Add(itemToAdd);
	}
	
	public void RemoveItem(Item itemToRemove) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		Item itemDb = itemRepo.GetById(itemToRemove.getId());
		
		if(itemDb != null)
			itemRepo.Remove(itemDb);
	}
	
	public Statement VerifyAccount(String accountName, String accountPassword) {
		AccountRepository accRepo = getDataBase().getAccountRepository();
		AppUser user = accRepo.GetByLoginPassword(accountName, accountPassword);
		
		if(user == null)
			return new Statement(ACCOUNT_DOESNT_EXIST);
		
		if(user instanceof Player)
			return new Statement("player", user) ;
		else return new Statement("admin", user) ;
	}
	
	public DataBase getDataBase() {
		return db;
	}

	public Statement ItemBuy(AppUser user, Item item) {
		// TODO Auto-generated method stub
		return new Statement("error"); // analogiczne zwracane wartosci co przy przy rejestracji
		
	}

	public void ItemSell(AppUser user, Item item) {
		// TODO Auto-generated method stub
		
	}

	public void UseItemInEQ(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void ConsumeItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void Rest(AppUser user) {
		// TODO Auto-generated method stub
		
	}

	public Statement Attack(AppUser attacker, AppUser target) {
		// TODO Auto-generated method stub
		return new Statement("killed", 10); //pierwszy parametr survived/killed, drugi to wartosc za ile zaatakowal
	}
}

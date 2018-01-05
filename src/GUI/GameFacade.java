package GUI;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import DataAccessLayer.ItemRepository;
import DataAccessLayer.RepositoryFactory;

import java.util.Date;
import java.util.List;
import Models.*;

public class GameFacade {
	final String ACCOUNT_DOESNT_EXIST = "error"; 
	final String ACCOUNT_CREATION_SUCCESS = "success";
	final String ACCOUNT_CREATION_FAILURE = "failure";
	
	private DataBase db = new DataBase(new RepositoryFactory());
	private List<AppUser> allAccs = db.getAccountRepository().GetAll();
	
	
	public String RegisterUser(String accountName, String accountPassword) {
		String accountStatus = VerifyAccount(accountName, accountPassword);
		
		if(accountStatus != ACCOUNT_DOESNT_EXIST)
			return ACCOUNT_CREATION_FAILURE;
		
		Player newPlayer = new Player();
		newPlayer.setNickname(accountName);
		newPlayer.setPassword(accountPassword);
		newPlayer.setCurrentHp(100);
		newPlayer.setMaxHp(100);
		newPlayer.setRegisterDate(new Date());
		
		//TODO. add default item to player
		
		AccountRepository accRepo = getDataBase().getAccountRepository();
		accRepo.Add(newPlayer);
		
		return ACCOUNT_CREATION_SUCCESS;
	}
	
	public void ModifyItem(Integer itemIdToChange, Item itemUpdated) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		
		Item itemDb = itemRepo.GetById(itemIdToChange);
		
		//Set properties to update
		itemDb.setName(itemUpdated.getName());
		itemDb.setPrice(itemUpdated.getPrice());
		itemDb.setStatistics(itemUpdated.getStatisticsSet());
		
		itemRepo.Update(itemDb);
	}
	
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
	
	public String VerifyAccount(String accountName, String accountPassword) {
		AccountRepository accRepo = getDataBase().getAccountRepository();
		AppUser user = accRepo.GetByLoginPassword(accountName, accountPassword);
		
		if(user == null)
			return ACCOUNT_DOESNT_EXIST;
	
		return user instanceof Player ? "player" : "admin";
	}
	
	public DataBase getDataBase() {
		return db;
	}
}

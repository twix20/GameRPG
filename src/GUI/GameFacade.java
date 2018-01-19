package GUI;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import DataAccessLayer.ItemRepository;
import DataAccessLayer.RepositoryFactory;

import java.util.Date;
import java.util.List;
import java.util.Set;

import Models.*;
import Pole_walki.Battlefield;
import Sklep.Shop;

public class GameFacade {
	final String ACCOUNT_DOESNT_EXIST = "error"; 
	final String ACCOUNT_CREATION_SUCCESS = "success";
	
	private DataBase db = new DataBase(new RepositoryFactory());
	private Shop shop = new Shop(db);
	
	public Battlefield battleField;
	
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
		newPlayer.getEquipment().setGold(200);
		
		//TODO. add default item to player
		
		AccountRepository accRepo = getDataBase().getAccountRepository();
		accRepo.SaveOrUpdate(newPlayer);
		
		return new Statement(ACCOUNT_CREATION_SUCCESS);
	}
	
	public void ModifyItem(int itemToModifyId, Item modifiedItem) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		
		Item itemDb = itemRepo.GetById(itemToModifyId);
		
		//Set properties to update
		itemDb.setName(modifiedItem.getName());
		itemDb.setPrice(modifiedItem.getPrice());
		itemDb.setBaisicAttribute(modifiedItem.getBaisicAttribute());
		itemDb.setStatistics(modifiedItem.getStatistics().getStatisticSet());
		
		itemRepo.SaveOrUpdate(itemDb);
	}
	
	public void AddItem(Item itemToAdd) {
		ItemRepository itemRepo = getDataBase().getItemRepository();
		itemRepo.SaveOrUpdate(itemToAdd);
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
		else 
			return new Statement("admin", user) ;
	}
	
	public DataBase getDataBase() {
		return db;
	}

	public Statement ItemBuy(AppUser user, Item item) {
		return shop.ItemBuy(user, item);
	}

	public void ItemSell(AppUser user, Item item) {
		shop.ItemSell(user, item);
	}
	
	public void ToggleEquipeItemInEQ(Player player, Item itemToToggle) {
		PlayerItem itemToToggleEquipe = player.getEquipment().getPlayerItemByItemId(itemToToggle.getId());
		
		//Cant toggle healingPotion
		if(itemToToggleEquipe.getItem() instanceof UseableItem)
			return;
		
		boolean shouldToggle = true;
		Set<PlayerItem> playerItems = player.getEquipment().getPlayerItems();
		for(PlayerItem it : playerItems) {
			//Its not the same item
			if(it.getItem().getId() == itemToToggleEquipe.getPk().getItem().getId()) continue;
			
			//If item is toggleabble
			if((itemToToggle instanceof AttackItem && it.getItem() instanceof AttackItem)
					|| (itemToToggle instanceof DefensiveItem && it.getItem() instanceof DefensiveItem))
		    {
				//if item int EQ is already equiped abort toggle
				if(it.isEquiped() == true) {
					shouldToggle = false;
					
					break;
				}
			}
		}
		
		if(shouldToggle)
			itemToToggleEquipe.setEquiped(!itemToToggleEquipe.isEquiped());
		
		AccountRepository accRepo = db.getAccountRepository();
		accRepo.SaveOrUpdate(player);
	}

	public void ConsumeItem(int playerItemId) {		
		this.battleField.Use(playerItemId);
	}

	public void Rest(Player user) {
		this.battleField.Rest();
	}

	public Statement Attack(Player attacker, Player target) {
		int dmgToDeal = this.battleField.GetCurrentPlayerDmg();
		boolean survived = this.battleField.Attack();
		
		if(survived)
			return new Statement("survived", dmgToDeal);
		
		return new Statement("killed", dmgToDeal); //pierwszy parametr survived/killed, drugi to wartosc za ile zaatakowal
	}
}

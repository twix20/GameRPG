package Models;

import DataAccessLayer.BattleFieldHistoryRepository;
import DataAccessLayer.ItemRepository;
import DataAccessLayer.PlayerRepository;
import DataAccessLayer.RepositoryFactory;
import DataAccessLayer.StatisticRepository;

public class DataBase {
	private PlayerRepository accountRepository;
	private ItemRepository itemRepository;
	private BattleFieldHistoryRepository battleFieldHistoryRepository;
	private StatisticRepository statisticRepository;
    
	private RepositoryFactory repoFactory;
    DataBase(RepositoryFactory repoFactory){
    	this.repoFactory = repoFactory;
    }
	public PlayerRepository getAccountRepository() {
		return accountRepository;
	}
	public ItemRepository getItemRepository() {
		return itemRepository;
	}
	public BattleFieldHistoryRepository getBattleFieldHistoryRepository() {
		return battleFieldHistoryRepository;
	}
	public StatisticRepository getStatisticRepository() {
		return statisticRepository;
	}

}

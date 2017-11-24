package DataAccessLayer;

import org.hibernate.SessionFactory;

public class DataBase {
	private PlayerRepository accountRepository;
	private ItemRepository itemRepository;
	private BattleFieldHistoryRepository battleFieldHistoryRepository;
	private StatisticRepository statisticRepository;
	
	private RepositoryFactory repoFactory;
	
	//private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
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

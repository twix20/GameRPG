package DataAccessLayer;

import org.hibernate.SessionFactory;

public class RepositoryFactory {
	
	public AccountRepository CreateAccountRepository(SessionFactory sessionFactory) {
		return new AccountRepository(sessionFactory);
	}
	public ItemRepository CreateItemRepository(SessionFactory sessionFactory) {
		return new ItemRepository(sessionFactory);
	}
	public BattleFieldHistoryRepository CreateBattleFieldHistoryRepository(SessionFactory sessionFactory) {
		return new BattleFieldHistoryRepository(sessionFactory);
	}
	public StatisticRepository CreateStatisticRepository(SessionFactory sessionFactory) {
		return new StatisticRepository(sessionFactory);
	}
}

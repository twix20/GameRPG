package DataAccessLayer;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Models.*;

public class DataBase {
	private AccountRepository accountRepository;
	private ItemRepository itemRepository;
	private BattleFieldHistoryRepository battleFieldHistoryRepository;
	private StatisticRepository statisticRepository;

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry)

						.addAnnotatedClass(Statistic.class)
						.addAnnotatedClass(StatisticType.class)

						.addAnnotatedClass(Item.class)
						.addAnnotatedClass(PlayerItem.class)

						.addAnnotatedClass(AttackItem.class)
						.addAnnotatedClass(Sword.class)
						.addAnnotatedClass(Wand.class)
						.addAnnotatedClass(Ammunition.class)
						.addAnnotatedClass(Bow.class)

						.addAnnotatedClass(DefensiveItem.class)
						.addAnnotatedClass(Shield.class)
						.addAnnotatedClass(Armor.class)

						.addAnnotatedClass(UseableItem.class)
						.addAnnotatedClass(HealingPotion.class)

						.addAnnotatedClass(AppUser.class).addAnnotatedClass(Player.class).addAnnotatedClass(Admin.class)
						.addAnnotatedClass(Mage.class).addAnnotatedClass(Warrior.class)

						.addAnnotatedClass(BattlefieldActionsHistory.class).addAnnotatedClass(BattlefieldHistory.class);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				System.out.println("SessionFactory creation failed " + e.getMessage());
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				throw e;
			}
		}
		return sessionFactory;
	}

	public static void Dispose() {
		if (sessionFactory != null)
			sessionFactory.close();

		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public DataBase(RepositoryFactory repoFactory) {
		SessionFactory sessionFactory = getSessionFactory();

		this.accountRepository = repoFactory.CreateAccountRepository(sessionFactory);
		this.itemRepository = repoFactory.CreateItemRepository(sessionFactory);
		this.battleFieldHistoryRepository = repoFactory.CreateBattleFieldHistoryRepository(sessionFactory);
		this.statisticRepository = repoFactory.CreateStatisticRepository(sessionFactory);
	}

	public AccountRepository getAccountRepository() {
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

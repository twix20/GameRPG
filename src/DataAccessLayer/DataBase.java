package DataAccessLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Models.Statistic;
import Models.StatisticType;

public class DataBase {
	private PlayerRepository accountRepository;
	private ItemRepository itemRepository;
	private BattleFieldHistoryRepository battleFieldHistoryRepository;
	private StatisticRepository statisticRepository;
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	private Session session;
	
	  public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	      try {
	    	  registry = new StandardServiceRegistryBuilder()
	  	            .configure()
	  	            .build();
	  	
	        // Create MetadataSources
	  	    MetadataSources sources = new MetadataSources(registry)
	  	    		.addAnnotatedClass(Statistic.class)
	  	    		.addAnnotatedClass(StatisticType.class);
	  	
	  	    // Create Metadata
	  	    Metadata metadata = sources.getMetadataBuilder().build();
	  	
	  	    // Create SessionFactory
	  	    sessionFactory = metadata.getSessionFactoryBuilder().build();

	      } catch (Exception e) {
	        System.out.println("SessionFactory creation failed");
	        if (registry != null) {
	          StandardServiceRegistryBuilder.destroy(registry);
	        }
	      }
	    }
	    return sessionFactory;
	  }

	  public static void shutdown() {
	    if (registry != null) {
	      StandardServiceRegistryBuilder.destroy(registry);
	    }
	  }
	  
	  public void Dispose() {
		  session.close();
	  }
	
    public DataBase(RepositoryFactory repoFactory) {
    	
    	SessionFactory sessionFactory = getSessionFactory();
    	session = sessionFactory.openSession();
    
    	this.accountRepository = repoFactory.CreateAccountRepository(sessionFactory);
    	this.itemRepository = repoFactory.CreateItemRepository(sessionFactory);
    	this.battleFieldHistoryRepository = repoFactory.CreateBattleFieldHistoryRepository(sessionFactory);
    	this.statisticRepository = repoFactory.CreateStatisticRepository(sessionFactory);
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

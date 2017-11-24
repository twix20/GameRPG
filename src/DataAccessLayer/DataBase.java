package DataAccessLayer;

import java.util.HashMap;
import java.util.Map;

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
	
	private RepositoryFactory repoFactory;
	
	//Hibernate
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	      try {
	        StandardServiceRegistryBuilder registryBuilder = 
	            new StandardServiceRegistryBuilder();

	        Map<String, String> settings = new HashMap<>();
	        settings.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
	        settings.put("hibernate.connection.url", "jdbc:oracle://localhost:3306/BORAJI");
	        settings.put("hibernate.connection.username", "DBUSER");
	        settings.put("hibernate.connection.password", "oracle");
	        settings.put("hibernate.show_sql", "true");
	        settings.put("hibernate.hbm2ddl.auto", "update");

	        registryBuilder.applySettings(settings);

	        registry = registryBuilder.build();

	        MetadataSources sources = new MetadataSources(registry)
	            .addAnnotatedClass(Statistic.class)
	            .addAnnotatedClass(StatisticType.class);

	        Metadata metadata = sources.getMetadataBuilder().build();

	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	      } catch (Exception e) {
	        System.out.println("SessionFactory creation failed " + e.getMessage());
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

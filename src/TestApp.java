import java.util.List;

import DataAccessLayer.*;
import Models.*;

public class TestApp {

  public static void main(String[] args) {

    DataBase db = new DataBase(new RepositoryFactory());
    
    ItemRepository repo = db.getItemRepository();
    List<Item> all = repo.GetAll();
    
    for(Item x : all) {
    	System.out.println("name: " + x.getName());
    	
    	StatisticsBag allStatsForItem = x.getStatistics();
    	
    	for(Statistic s : allStatsForItem.values()) {
    		
    		System.out.println("StatId: " + s.getId() + " StatName: " + s.getStatisticType().getName() + " value: " + s.getValue());
    	}
    }
    
    //StatisticRepository statRpo = db.getStatisticRepository();
    //List<Statistic> allStat = statRpo.GetAll();
    
    db.Dispose();
  }
}
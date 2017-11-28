import java.util.List;

import DataAccessLayer.DataBase;
import DataAccessLayer.ItemRepository;
import DataAccessLayer.RepositoryFactory;
import DataAccessLayer.StatisticRepository;
import Models.*;

public class TestApp {

  public static void main(String[] args) {

    DataBase db = new DataBase(new RepositoryFactory());
    
    ItemRepository repo = db.getItemRepository();
    
    List<Item> all = repo.GetAll();
    
   
    db.Dispose();
  }
}
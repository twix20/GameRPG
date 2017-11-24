import java.util.List;

import DataAccessLayer.DataBase;
import DataAccessLayer.RepositoryFactory;
import DataAccessLayer.StatisticRepository;
import Models.*;

public class TestApp {

  public static void main(String[] args) {

    DataBase db = new DataBase(new RepositoryFactory());
    
    StatisticRepository sr = db.getStatisticRepository();
    
    List<Statistic> all = sr.GetAll();
    
   
    db.Dispose();
  }
}
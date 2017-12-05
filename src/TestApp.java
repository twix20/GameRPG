import java.util.List;

import DataAccessLayer.*;
import Models.*;

public class TestApp {

  public static void main(String[] args) {

    DataBase db = new DataBase(new RepositoryFactory());
    
    AccountRepository accRepo = db.getAccountRepository();
    List<AppUser> allAccs = accRepo.GetAll();
    
    BattleFieldHistoryRepository bfhRepo = db.getBattleFieldHistoryRepository();
    List<BattlefieldHistory> allBfh = bfhRepo.GetAll();
    
    db.Dispose();
  }
}
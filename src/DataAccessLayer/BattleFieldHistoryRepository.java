package DataAccessLayer;
import java.util.ArrayList;

import org.hibernate.SessionFactory;

import Models.BattlefieldHistory;


public class BattleFieldHistoryRepository extends Repository<BattlefieldHistory>{
	
	public BattleFieldHistoryRepository(SessionFactory sessionFactory) {
		super(BattlefieldHistory.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	ArrayList<BattlefieldHistory> GetByBattleFieldId(){
		throw new UnsupportedOperationException ("TODO");
	}
	
}

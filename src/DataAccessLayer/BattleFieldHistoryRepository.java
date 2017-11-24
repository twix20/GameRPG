package DataAccessLayer;
import java.util.ArrayList;

import org.hibernate.SessionFactory;

import Models.BattleFieldHistory;


public class BattleFieldHistoryRepository extends Repository<BattleFieldHistory>{
	
	public BattleFieldHistoryRepository(SessionFactory sessionFactory) {
		super(BattleFieldHistory.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	ArrayList<BattleFieldHistory> GetByBattleFieldId(){
		throw new UnsupportedOperationException ("TODO");
	}
	
}

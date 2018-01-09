package DataAccessLayer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;

import Models.BattlefieldActionsHistory;
import Models.BattlefieldHistory;

public class BattleFieldHistoryRepository extends Repository<BattlefieldHistory, Integer>{
	
	public BattleFieldHistoryRepository(SessionFactory sessionFactory) {
		super(BattlefieldHistory.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public BattlefieldHistory GetForBattleField(Integer battlefieldId){
		
		runInSession(session -> {		
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<BattlefieldHistory> criteriaQuery = criteriaBuilder.createQuery(BattlefieldHistory.class);
			
			Root<BattlefieldHistory> bfhistoryRoot = criteriaQuery.from(BattlefieldHistory.class);
			Root<BattlefieldActionsHistory> actionsRoot = criteriaQuery.from(BattlefieldActionsHistory.class);
			
			Predicate predicate1 = criteriaBuilder.equal(actionsRoot.get("BattlefieldId"), battlefieldId);
			Predicate predicate2 = criteriaBuilder.equal(bfhistoryRoot.get("id"), battlefieldId);
		
			criteriaQuery = criteriaQuery.select(bfhistoryRoot);
	        criteriaQuery.where(predicate1, predicate2);
	        
			Query q = session.createQuery(criteriaQuery);
			entity = (BattlefieldHistory)q.getSingleResult();
		});
		
		return entity;
	}

}

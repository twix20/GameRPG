package DataAccessLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Models.Item;

public class ItemRepository extends Repository<Item, Integer>{
	public ItemRepository(SessionFactory sessionFactory) {
		super(Item.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Item> GetAllForPlayer(String playerId){
		
		throw new UnsupportedOperationException ("TODO");
	}
	
	public Item FindItemByName(String itemName){
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
			Root<Item> itemRoot = criteriaQuery.from(Item.class);
			

			Predicate predicate1 = criteriaBuilder.equal(itemRoot.get("name"), itemName);
	        
	        criteriaQuery.where(predicate1);
	        
			Query q = session.createQuery(criteriaQuery);
			entity = (Item)q.getSingleResult();
					      
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}	
		
		return entity;
	}

}

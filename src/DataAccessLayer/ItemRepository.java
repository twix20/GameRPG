package DataAccessLayer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;

import Models.Item;

public class ItemRepository extends Repository<Item, Integer>{
	public ItemRepository(SessionFactory sessionFactory) {
		super(Item.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public Item GetByName(String itemName){
		
		runInSession(session -> {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
			Root<Item> itemRoot = criteriaQuery.from(Item.class);
			

			Predicate predicate1 = criteriaBuilder.equal(itemRoot.get("name"), itemName);
	        
	        criteriaQuery.where(predicate1);
	        
			Query q = session.createQuery(criteriaQuery);
			
			getSingleWithoutNullException(q);
		});
		
		return entity;
	}

}

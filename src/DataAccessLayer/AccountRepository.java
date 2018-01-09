package DataAccessLayer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import Models.AppUser;

public class AccountRepository extends Repository<AppUser, String> {
	public AccountRepository(SessionFactory sessionFactory) {
		super(AppUser.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public AppUser GetByLoginPassword(String login, String password) {
		
		runInSession(session -> {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<AppUser> criteriaQuery = criteriaBuilder.createQuery(AppUser.class);
			Root<AppUser> userRoot = criteriaQuery.from(AppUser.class);
			
			Predicate predicate1 = criteriaBuilder.equal(userRoot.get("nickname"), login);
			Predicate predicate2 = criteriaBuilder.equal(userRoot.get("password"), password);
	        
	        criteriaQuery.where(predicate1, predicate2);
	        
			Query q = session.createQuery(criteriaQuery);
			
			getSingleWithoutNullException(q);
		});
		
		return entity;
	}
}

package DataAccessLayer;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.Query;
import javax.persistence.criteria.*;

import org.hibernate.*;

public abstract class Repository<T, ID extends Serializable> {
	protected SessionFactory sessionFactory;
	protected Class<T> type;
	
	
	protected List<T> allFetched = null;
	protected T entity = null;
	

	public Repository(Class<T> type, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.type = type;
	}

	public void SaveOrUpdate(T model) {
		
		runInSession(session -> {
			session.saveOrUpdate(model);
		});
	}
	
	public void Detach(T model) {
		runInSession(session -> {
			session.evict(model);
		});
	}
	
	
	
	public void Merge(T model) {
		
		runInSession(session -> {
			session.merge(model);
		});
		
	}

	public void Remove(T model) {
		
		runInSession(session -> {
			session.delete(model);
		});

	}

	public boolean Update(T model) {
		throw new UnsupportedOperationException("TODO");
	}

	public T GetById(ID id) {
		
		runInSession(session -> {
			entity = (T) session.get(type, id);
		});
		
		return entity;
	}

	public List<T> GetAll() {
		
		runInSession(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(this.type);
			
			Root<T> root = query.from(this.type);
			query.select(root);
			Query q = session.createQuery(query);
			
			allFetched = q.getResultList();
		});
		
		return allFetched;
	}
	
	protected void runInSession(Consumer<Session> action) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			action.accept(session);
			
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}		
	}
}
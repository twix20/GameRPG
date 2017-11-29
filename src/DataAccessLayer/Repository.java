package DataAccessLayer;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class Repository<T> {
	private SessionFactory sessionFactory;
	private Class<T> type;

	public Repository(Class<T> type, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.type = type;
	}

	public boolean Add(T model) {
		throw new UnsupportedOperationException("TODO");
	}

	public boolean Remove(T model) {
		throw new UnsupportedOperationException("TODO");
	}

	public boolean Update(T model) {
		throw new UnsupportedOperationException("TODO");
	}

	public T GetById(T model) {
		throw new UnsupportedOperationException("TODO");
	}

	public List<T> GetAll() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(this.type);

		Root<T> root = query.from(this.type);
		query.select(root);
		Query q = session.createQuery(query);
		List<T> allFetched = q.getResultList();

		tx.commit();
		return allFetched;
	}
}
package DataAccessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Models.Statistic;

public abstract class Repository <T extends Serializable> {
	private SessionFactory sessionFactory;
	private Class<T> type;
	
	public Repository(Class<T> type, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.type = type;
	}
	
	public boolean Add(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	public boolean Remove(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	public boolean Update(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	public T GetById(T model)	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	public List<T> GetAll()	{
	      Session session = sessionFactory.getCurrentSession();
	      
	      Transaction tx = session.beginTransaction();
	      Criteria crit = session.createCriteria(type);
	      
	      List<T> allFetched = crit.list();
	      
	      tx.commit();
	  return allFetched;
	}
	

}
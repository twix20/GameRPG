import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DataAccessLayer.DataBase;
import DataAccessLayer.RepositoryFactory;
import Models.Statistic;

public class TestApp {
  public static void main(String[] args) {
	//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		
		//creating seession factory object
		SessionFactory factory=cfg.buildSessionFactory();
		
		//creating session object
		Session session=factory.openSession();
	  
	  
    /*Session session = null;

    DataBase db = new DataBase(new RepositoryFactory());
    
    try {
      session = db.getSessionFactory().openSession();
      
      CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
      CriteriaQuery<Statistic> criteriaQuery = criteriaBuilder.createQuery(Statistic.class);
      Root<Statistic> root = criteriaQuery.from(Statistic.class);
      criteriaQuery.select(root);
      
      Query query = session.createQuery(criteriaQuery);
      
      @SuppressWarnings("unchecked")
	  List<Statistic> statAll = query.getResultList();
      
      for (Statistic entity : statAll) {
    	    System.out.println(entity.toString());
    	}
      
    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
      }
    }

    db.shutdown();*/
  }
}
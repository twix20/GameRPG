package DataAccessLayer;

import org.hibernate.SessionFactory;

import Models.Statistic;

public class StatisticRepository extends Repository<Statistic>{

	public StatisticRepository(SessionFactory sessionFactory) {
		super(Statistic.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

}

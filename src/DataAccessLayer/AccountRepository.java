package DataAccessLayer;

import org.hibernate.SessionFactory;

import Models.AppUser;

public class AccountRepository extends Repository<AppUser, String> {
	public AccountRepository(SessionFactory sessionFactory) {
		super(AppUser.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public AppUser GetByLoginPassword(String login, String password) {
		return null;
	}
}

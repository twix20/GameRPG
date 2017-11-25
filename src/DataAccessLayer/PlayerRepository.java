package DataAccessLayer;

import org.hibernate.SessionFactory;

import Models.Player;

public class PlayerRepository extends Repository<Player> {
	public PlayerRepository(SessionFactory sessionFactory) {
		super(Player.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	public Player GetByLoginPassword(String login, String password) {
		return null;
	}
}

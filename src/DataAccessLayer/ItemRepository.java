package DataAccessLayer;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import Models.Item;

public class ItemRepository extends Repository<Item>{
	public ItemRepository(SessionFactory sessionFactory) {
		super(Item.class, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	ArrayList<Item> GetAllForPlayer(int playerId){
		
		throw new UnsupportedOperationException ("TODO");
	}

}

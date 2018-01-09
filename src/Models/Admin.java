package Models;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hibernate.Session;

import DataAccessLayer.DataBase;
import DataAccessLayer.ItemRepository;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends AppUser {
	
	@Transient
	private DataBase dataBase;
	
	public Admin() {}
	public Item addItem(Item it) {
		ItemRepository r = dataBase.getItemRepository();
		r.SaveOrUpdate(it);
		
		return it;
	}
	public Item editItem(Item it) {
		ItemRepository r = dataBase.getItemRepository();
		r.SaveOrUpdate(it);
		
		return it;
	}
	public void deleteItem(Item it) {
		ItemRepository r = dataBase.getItemRepository();
		r.Remove(it);
	}
	public void showMatchHisory() {
		
	}
	public Item findItemByName(String name) {
		ItemRepository r = dataBase.getItemRepository();
		
		Item item = r.GetByName(name);
		
		return item;
	}
	public DataBase getDataBase() {
		return dataBase;
	}
	
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
}

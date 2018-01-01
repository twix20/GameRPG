package Models;

import javax.persistence.*;

import DataAccessLayer.DataBase;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends AppUser {
	
	@Transient
	private DataBase dataBase;
	
	public Admin() {}
	
	public Item addItem(Item it) {
		return null;
	}
	public Item editItem(int id) {
		return null;
	}
	public Item deleteItem(int id) {
		return null;
	}
	public void showMatchHisory() {
		
	}
	public Item findItemByName(String name) {
		return null;
	}
	public DataBase getDataBase() {
		return dataBase;
	}
	
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	public Boolean getIsPlayer() {
		return false;
	}
}

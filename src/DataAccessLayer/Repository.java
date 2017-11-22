package DataAccessLayer;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Repository <T extends Serializable> {
	boolean Add(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	boolean Remove(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	boolean Update(T model)
	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	T GetById(T model)	{
		throw new UnsupportedOperationException ("TODO");
	}
	
	ArrayList<T> GetAll()	{
		throw new UnsupportedOperationException ("TODO");
	}
	

}
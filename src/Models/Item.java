package Models;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Item")
@DiscriminatorColumn(name="Type", discriminatorType=DiscriminatorType.STRING)
public abstract class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private int id;
        
    @Column(name = "Name")
    private String name;
    
	@Column(name = "Price")
	private int price;
	
	//private int durability;
	
	@ManyToMany(cascade = { CascadeType.ALL }, targetEntity=Statistic.class)
	@JoinTable(
			name = "Item_Statistic_XREF", 
			joinColumns = { @JoinColumn(name = "Item_Id") }, 
			inverseJoinColumns = { @JoinColumn(name = "Statistic_Id") }
			)
	private Set<Statistic> statistics = new HashSet<Statistic>();
	
	public Item() {}
	
	public Item(int id, String name, int price, StatisticsBag statistics){
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setStatistics(new HashSet<Statistic>(statistics.values()));
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public StatisticsBag getStatistics() {
		return new StatisticsBag(statistics);
	}

	public void setStatistics(Set<Statistic> statistics) {
		this.statistics = statistics;
	}

/*	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}*/
}

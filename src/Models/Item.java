package Models;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@DiscriminatorColumn(name="Type", discriminatorType=DiscriminatorType.STRING)
public class Item {
        
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	protected int id;
        
    @Column(name = "Name")
	protected String name;
    
    @Column(name = "MaxDurability")
    protected int maxDurability;
       
	@Column(name = "Price")
	protected int price;
	
	@Column(name = "Type")
	protected String type;
	
	protected StatisticsBag statistics;
   
	public Item() {}
	
	public Item(int id, String name, int price, StatisticsBag statistics){
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setStatistics(statistics);
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
	
    public int getMaxDurability() {
		return maxDurability;
	}

	public void setMaxDurability(int maxDurability) {
		this.maxDurability = maxDurability;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public StatisticsBag getStatistics() {
		return statistics;
	}

	public void setStatistics(StatisticsBag statistics) {
		this.statistics = statistics;
	}
}

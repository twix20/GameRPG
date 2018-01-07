package Models;

import javax.persistence.*;

@Entity
@Table(name = "Statistic")
public class Statistic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="StatisticType_Id", foreignKey=@ForeignKey(name="Statistic_StatisticType"))
	private StatisticType statisticType;
	
	@Column(name = "Value")
	private int value;
	
	public Statistic() {}
	
	public Statistic(StatisticType type, int value) {
		this.statisticType = type;
		this.setValue(value);
	}

	public int getId() {
		return id;
	}
	
	public StatisticType getStatisticType() {
		return statisticType;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	/* Chcemy znac wszystkie itemy ktore maja dana statystyke? chyba nie
    @ManyToMany(mappedBy = "statistics")
    private Set<Item> items = new HashSet<>();

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	*/
	
}

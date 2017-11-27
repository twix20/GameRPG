package Models;

import javax.persistence.*;

@Entity
@Table(name = "Statistic")
public class Statistic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
        @JoinColumn(name="StatisticType_Id",foreignKey=@ForeignKey(name="Statistic_StatisticType"))
	private StatisticType statisticType;
	
	@Column(name = "Value")
	private int value;
	
	public Statistic() {}
	
	public Statistic(int id, StatisticType type, int value) {
		this.id = id;
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
}

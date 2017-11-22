package Models;

import java.io.Serializable;

public class Statistic implements Serializable{
	private static final long serialVersionUID = -1643972581721255276L;
	
	private StatisticType statisticType;
	private String name;
	private int value;
	
	public Statistic(StatisticType type, int value) {
		this.statisticType = type;
		this.setValue(value);
	}

	public StatisticType getStatisticType() {
		return statisticType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

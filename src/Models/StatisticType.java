package Models;

import javax.persistence.*;

@Entity
@Table(name = "StatisticType")
public class StatisticType
{
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	public StatisticType() {}
	
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
	
	public StatisticTypeEnum getTypeEnum() {
		return StatisticTypeEnum.values()[this.id];
	}
}



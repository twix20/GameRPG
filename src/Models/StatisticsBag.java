package Models;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatisticsBag {
	private Map<StatisticTypeEnum, Statistic> allStatistics;
	
	public StatisticsBag() {
		allStatistics = new HashMap<>();
	}
	
	public StatisticsBag(Collection<Statistic> statistics) {
		this();
		
		for(Statistic s: statistics)
			allStatistics.put(s.getStatisticType().getTypeEnum(), s);
	}
	
	public void addStatistic(Statistic stat) {
		if(allStatistics.containsKey(stat.getStatisticType().getTypeEnum())) {
			
			Statistic existingStat = allStatistics.get(stat.getStatisticType().getTypeEnum());
			int newValue = existingStat.getValue() + stat.getValue();
			
			existingStat.setValue(newValue);
			return;
		}
		
		allStatistics.put(stat.getStatisticType().getTypeEnum(), stat);
	}
	public int getStatisticValue(StatisticTypeEnum statType) {
		return allStatistics.containsKey(statType) ? 
				allStatistics.get(statType).getValue(): 0;
	}
	
	public void removeStatistic(StatisticTypeEnum statType, int valueToRemove) {
		if(!allStatistics.containsKey(statType)) return;
		
		Statistic existingStat = allStatistics.get(statType);
		int newValue = existingStat.getValue() - valueToRemove;
		
		if(newValue < 0) newValue = 0;
		
		existingStat.setValue(newValue);
		
		allStatistics.put(statType, existingStat);
	}
	
	public Collection<Statistic> values(){
		return this.allStatistics.values();
	}
	
	public Set<Statistic> getStatisticSet(){
		return new HashSet<Statistic>(allStatistics.values());
	}
}

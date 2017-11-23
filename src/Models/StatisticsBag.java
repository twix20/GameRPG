package Models;

import java.util.HashMap;

public class StatisticsBag {
	private HashMap<StatisticTypeEnum, Statistic> allStatistics = new HashMap<>();
	
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
}

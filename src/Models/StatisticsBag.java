package Models;

import java.util.HashMap;

public class StatisticsBag {
	private HashMap<StatisticType, Statistic> allStatistics = new HashMap<>();
	
	public void addStatistic(Statistic stat) {
		if(allStatistics.containsKey(stat.getStatisticType())) {
			
			Statistic existingStat = allStatistics.get(stat.getStatisticType());
			int newValue = existingStat.getValue() + stat.getValue();
			
			existingStat.setValue(newValue);
			return;
		}
		
		allStatistics.put(stat.getStatisticType(), stat);
	}
	
	public int getStatisticValue(StatisticType statType) {
		return allStatistics.containsKey(statType) ? 
				allStatistics.get(statType).getValue(): 0;
	}
	
	public void removeStatistic(StatisticType statType, int valueToRemove) {
		if(!allStatistics.containsKey(statType)) return;
		
		Statistic existingStat = allStatistics.get(statType);
		int newValue = existingStat.getValue() - valueToRemove;
		
		if(newValue < 0) newValue = 0;
		
		existingStat.setValue(newValue);
		
		allStatistics.put(statType, existingStat);
	}
}

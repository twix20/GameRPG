package Models;

import java.util.*;

public enum StatisticTypeEnum {
	Hp(1), Mp(2), DealDmg(3), Def(4), Agi(6);

	private int dbId;

	private static Map<Integer, StatisticTypeEnum> map = new HashMap<Integer, StatisticTypeEnum>();

	static {
		for (StatisticTypeEnum statEnum : StatisticTypeEnum.values()) {
			map.put(statEnum.dbId, statEnum);
		}
	}

	private StatisticTypeEnum(final int dbId) {
		this.dbId = dbId;
	}

	public static StatisticTypeEnum valueOf(int dbId) {
		return map.get(dbId);
	}
	
    public int getDbId() {
        return dbId;
    }
}

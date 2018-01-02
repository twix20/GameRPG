import java.util.List;

import DataAccessLayer.*;
import Models.*;

public class TestApp {

	public static void main(String[] args) {
		DataBase db = new DataBase(new RepositoryFactory());
		
		ItemRepository itemRepo = db.getItemRepository();
		Item i = itemRepo.FindItemByName("Miecz Grabarza ksiezyca");
		System.out.format("Id: %d Name: %s\n", i.getId(), i.getName());

		AccountRepository accRepo = db.getAccountRepository();
		AppUser userByLoginPasword = accRepo.GetByLoginPassword("FakePlayer1", "123");
		System.out.format("Id: %d Nickname: %s\n", userByLoginPasword.getId(), userByLoginPasword.getNickname());
		
		List<AppUser> allAccs = accRepo.GetAll();

		Player p = (Player) allAccs.get(0);
		Equipment eq = p.getEquipment();
		for (PlayerItem item : eq.getPlayerItems()) {

			System.out.println(item.getItem().getName());

			StatisticsBag stats = item.getItem().getStatistics();

			for (Statistic s : stats.values()) {

				System.out.format("StatId: %d Name: %s Value: %d\n", 
						s.getStatisticType().getId(),
						s.getStatisticType().getName(), 
						s.getValue()
				);

			}

		}

		BattleFieldHistoryRepository bfhRepo = db.getBattleFieldHistoryRepository();
		List<BattlefieldHistory> allBfh = bfhRepo.GetAll();

		DataBase.Dispose();
	}
}
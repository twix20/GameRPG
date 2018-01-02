package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


<<<<<<< HEAD:src/TestApp.java
	public static void main(String[] args) {
		DataBase db = new DataBase(new RepositoryFactory());
		
		ItemRepository itemRepo = db.getItemRepository();
		Item i = itemRepo.FindItemByName("Miecz Grabarza ksiezyca");
		System.out.format("Id: %d Name: %s\n", i.getId(), i.getName());
=======
@SuppressWarnings("restriction")
public class GUI_Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("guiRPG.fxml"));
		primaryStage.setTitle("RPG simulator");
		primaryStage.setScene(new Scene(root, 1274, 774));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		
			
		/*DataBase db = new DataBase(new RepositoryFactory());
>>>>>>> origin/michal:src/GUI/GUI_Main.java

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

		DataBase.Dispose();*/
}

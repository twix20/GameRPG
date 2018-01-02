package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
}

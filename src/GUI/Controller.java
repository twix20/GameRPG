package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import DataAccessLayer.DataBase;
import Models.AppUser;
import Models.Armor;
import Models.AttackItem;
import Models.BattlefieldActionsHistory;
import Models.BattlefieldHistory;
import Models.DefensiveItem;
import Models.HealingPotion;
import Models.Item;
import Models.Player;
import Models.PlayerItem;
import Models.Shield;
import Models.Spear;
import Models.Statistic;
import Models.StatisticType;
import Models.StatisticsBag;
import Models.Sword;

@SuppressWarnings("restriction")
public class Controller implements Initializable {
	private GameFacade gameFacade = new GameFacade();  // <<--- dostep do fasady
	private AppUser userL;
	private AppUser userR;
	//---------------------------------------
	//---------------------------------------	
	
	//Views
	@FXML
	private AnchorPane AddPanelL;
	@FXML
	private AnchorPane AddPanelR;
	@FXML
	private AnchorPane AdminPanelL;
	@FXML
	private AnchorPane AdminPanelR;
	@FXML
	private AnchorPane BattlefieldPanelL;
	@FXML
	private AnchorPane BattlefieldPanelR;
	@FXML
	private AnchorPane EQPanelL;
	@FXML
	private AnchorPane EQPanelR;
	@FXML
	private AnchorPane HistoryPanelL;
	@FXML
	private AnchorPane HistoryPanelR;
	@FXML
	private AnchorPane LoginPanelL;
	@FXML
	private AnchorPane LoginPanelR;
	@FXML
	private AnchorPane ModifyPanelL;
	@FXML
	private AnchorPane ModifyPanelR;
	@FXML
	private AnchorPane PlayerPanelL;
	@FXML
	private AnchorPane PlayerPanelR;
	@FXML
	private AnchorPane PickItemPanelL;
	@FXML
	private AnchorPane PickItemPanelR;
	@FXML
	private AnchorPane RemovePanelL;
	@FXML
	private AnchorPane RemovePanelR;
	@FXML
	private AnchorPane ShopPanelL;
	@FXML
	private AnchorPane ShopPanelR;
	@FXML
	private AnchorPane WelcomePanelL;
	@FXML
	private AnchorPane WelcomePanelR;
	@FXML
	private AnchorPane RegisterPanelL;
	@FXML
	private AnchorPane RegisterPanelR;
	
	//---------------------------------------
	//---------------------------------------
	//Text Area
	@FXML
	private TextArea ChatTextArea;
	
	//---------------------------------------
	//---------------------------------------
	//Text Fields
	@FXML
	private TextField AccountTextFieldL;
	@FXML
	private TextField AccountTextFieldR; 
	@FXML
	private TextField PasswordTextFieldL;
	@FXML
	private TextField PasswordTextFieldR;
	
	@FXML
	private TextField AccountRegisterTextFieldL;
	@FXML
	private TextField AccountRegisterTextFieldR; 
	@FXML
	private TextField PasswordRegisterTextFieldL;
	@FXML
	private TextField PasswordRegisterTextFieldR;
	
	@FXML
	private TextField NameModifyTextFieldL;
	@FXML
	private TextField NameModifyTextFieldR;
	@FXML
	private TextField PriceModifyTextFieldL;
	@FXML
	private TextField PriceModifyTextFieldR;
	@FXML
	private TextField BasicAttributeModifyTextFieldL;
	@FXML
	private TextField BasicAttributeModifyTextFieldR;
	@FXML
	private TextField ValueOfSAModifyTextFieldL;
	@FXML
	private TextField ValueOfSAModifyTextFieldR;
	
	@FXML
	private TextField NameAddTextFieldL;
	@FXML
	private TextField NameAddTextFieldR;
	@FXML
	private TextField PriceAddTextFieldL;
	@FXML
	private TextField PriceAddTextFieldR;
	@FXML
	private TextField BasicAttributeAddTextFieldL;
	@FXML
	private TextField BasicAttributeAddTextFieldR;
	@FXML
	private TextField ValueOfSAAddTextFieldL;
	@FXML
	private TextField ValueOfSAAddTextFieldR;
	
	//---------------------------------------
	//---------------------------------------
	//Labels
	@FXML
	private Label LoginErrorLabelL;
	@FXML
	private Label LoginErrorLabelR;
	@FXML
	private Label WelcomePlayerLabelL;
	@FXML
	private Label WelcomePlayerLabelR;
	@FXML
	private Label WelcomeAdminLabelL;
	@FXML
	private Label WelcomeAdminLabelR;
	@FXML
	private Label MoneyEQLabelL;
	@FXML
	private Label MoneyEQLabelR;
	@FXML
	private Label MoneyShopLabelL;
	@FXML
	private Label MoneyShopLabelR;
	@FXML
	private Label SuccessRegisterLabelL;
	@FXML
	private Label SuccessRegisterLabelR;
	@FXML
	private Label FailureRegisterLabelL;
	@FXML
	private Label FailureRegisterLabelR;
	@FXML
	private Label BattlefieldNameLabelL;
	@FXML
	private Label BattlefieldNameLabelR;
	
	//---------------------------------------
	//---------------------------------------
	//TreeViews
	@FXML
	private TreeView<String> TreeModifyL;
	@FXML
	private TreeView<String> TreeModifyR;
	@FXML
	private TreeView<String> TreeAddL;
	@FXML
	private TreeView<String> TreeAddR;
	@FXML
	private TreeView<String> TreeRemoveL;
	@FXML
	private TreeView<String> TreeRemoveR;
	
	//---------------------------------------
	//---------------------------------------
	//TableViews
	@FXML
	private TableView<TableRow> HistoryTableViewL;
	@FXML
	private TableView<TableRow> HistoryTableViewR;
	@FXML
	private TableView<TableRow> SpecifyHistoryTableViewL;
	@FXML
	private TableView<TableRow> SpecifyHistoryTableViewR;
	
	@FXML
	private TableView<TableRow> EQTableViewL;
	@FXML
	private TableView<TableRow> EQTableViewR;
	
	@FXML
	private TableView<TableRow> ShopTableViewL;
	@FXML
	private TableView<TableRow> ShopTableViewR;
	
	@FXML
	private TableView<TableRow> PickItemTableViewL;
	@FXML
	private TableView<TableRow> PickItemTableViewR;
	
	//---------------------------------------
	//---------------------------------------
	//TableViews Columns
	@FXML
	private TableColumn<TableRow,String> IDHistoryColumnL;
	@FXML
	private TableColumn<TableRow,String> IDHistoryColumnR;
	@FXML
	private TableColumn<TableRow,String> p1NameColumnL;
	@FXML
	private TableColumn<TableRow,String> p1NameColumnR;
	@FXML
	private TableColumn<TableRow,String> p2NameColumnL;
	@FXML
	private TableColumn<TableRow,String> p2NameColumnR;
	@FXML
	private TableColumn<TableRow,String> winNameColumnL;
	@FXML
	private TableColumn<TableRow,String> winNameColumnR;
	
	@FXML
	private TableColumn<TableRow,String> WhoColumnSpecifyHistoryL;
	@FXML
	private TableColumn<TableRow,String> WhoColumnSpecifyHistoryR;
	@FXML
	private TableColumn<TableRow,String> ActionColumnSpecifyHistoryL;
	@FXML
	private TableColumn<TableRow,String> ActionColumnSpecifyHistoryR;
	@FXML
	private TableColumn<TableRow,String> ValueColumnSpecifyHistoryL;
	@FXML
	private TableColumn<TableRow,String> ValueColumnSpecifyHistoryR;
	
	@FXML
	private TableColumn<TableRow,String> ShopNameColumnL;
	@FXML
	private TableColumn<TableRow,String> ShopNameColumnR;
	@FXML
	private TableColumn<TableRow,String> ShopBAColumnL;
	@FXML
	private TableColumn<TableRow,String> ShopBAColumnR;
	@FXML
	private TableColumn<TableRow,String> ShopSAColumnL;
	@FXML
	private TableColumn<TableRow,String> ShopSAColumnR;
	@FXML
	private TableColumn<TableRow,String> ShopPriceColumnL;
	@FXML
	private TableColumn<TableRow,String> ShopPriceColumnR;
	
	@FXML
	private TableColumn<TableRow,String> EQNameColumnL;
	@FXML
	private TableColumn<TableRow,String> EQNameColumnR;
	@FXML
	private TableColumn<TableRow,String> EQBAColumnL;
	@FXML
	private TableColumn<TableRow,String> EQBAColumnR;
	@FXML
	private TableColumn<TableRow,String> EQSAColumnL;
	@FXML
	private TableColumn<TableRow,String> EQSAColumnR;
	@FXML
	private TableColumn<TableRow,String> EQUsedColumnL;
	@FXML
	private TableColumn<TableRow,String> EQUsedColumnR;
	
	@FXML
	private TableColumn<TableRow,String> PickItemNameColumnL;
	@FXML
	private TableColumn<TableRow,String> PickItemNameColumnR;
	@FXML
	private TableColumn<TableRow,String> PickItemAttributeColumnL;
	@FXML
	private TableColumn<TableRow,String> PickItemAttributeColumnR;
	
	
	
	//---------------------------------------
	//---------------------------------------
	//ChoiceBoxes
	@FXML
	private ChoiceBox<String> SpecialAttributeModifyChoiceBoxL;
	@FXML
	private ChoiceBox<String> SpecialAttributeModifyChoiceBoxR;
	@FXML
	private ChoiceBox<String> ItemTypeAddChoiceBoxL;
	@FXML
	private ChoiceBox<String> ItemTypeAddChoiceBoxR;
	@FXML
	private ChoiceBox<String> SpecialAttributeAddChoiceBoxL;
	@FXML
	private ChoiceBox<String> SpecialAttributeAddChoiceBoxR;
	
	//---------------------------------------
	//---------------------------------------
	//ToggleButtons
	@FXML
	private ToggleButton ReadyButtonL;
	@FXML
	private ToggleButton ReadyButtonR;
	
	//---------------------------------------
	//---------------------------------------
	//RadioButtons
	@FXML
	private RadioButton BuyRadioButtonL;
	@FXML
	private RadioButton BuyRadioButtonR;
	@FXML
	private RadioButton SellRadioButtonL;
	@FXML
	private RadioButton SellRadioButtonR;
	
	
	//---------------------------------------
		//---------------------------------------
		//Actions
		//welcome panel
		public void ToRegisterL() {
			WelcomePanelL.setVisible(false);
			RegisterPanelL.setVisible(true);
		}
		public void ToRegisterR() {
			WelcomePanelR.setVisible(false);
			RegisterPanelR.setVisible(true);
		}
		
		public void ToLoginL() {
			WelcomePanelL.setVisible(false);
			LoginPanelL.setVisible(true);
		}
		public void ToLoginR() {
			WelcomePanelR.setVisible(false);
			LoginPanelR.setVisible(true);
		}
		//----------------------------------
		//register panel
		public void RegisterBackToWelcomeL() {
			FailureRegisterLabelL.setVisible(false);
			SuccessRegisterLabelL.setVisible(false);
			RegisterPanelL.setVisible(false);
			WelcomePanelL.setVisible(true);
		}
		public void RegisterBackToWelcomeR() {
			FailureRegisterLabelR.setVisible(false);
			SuccessRegisterLabelR.setVisible(false);
			RegisterPanelR.setVisible(false);
			WelcomePanelR.setVisible(true);
		}

		public void RegisterL() {
			Statement komunikat = gameFacade.RegisterUser(AccountRegisterTextFieldL.getText(), PasswordRegisterTextFieldL.getText());
			switch (komunikat.getInformation()) {
			case "success":
				FailureRegisterLabelL.setVisible(false);
				SuccessRegisterLabelL.setVisible(true);
				break;
			case "failure":
				SuccessRegisterLabelL.setVisible(false);
				FailureRegisterLabelL.setVisible(true);
				break;
			};
		}
		public void RegisterR() {
			Statement komunikat = gameFacade.RegisterUser(AccountRegisterTextFieldL.getText(), PasswordRegisterTextFieldL.getText());
			switch (komunikat.getInformation()) {
			case "success":
				FailureRegisterLabelR.setVisible(false);
				SuccessRegisterLabelR.setVisible(true);
				break;
			case "failure":
				SuccessRegisterLabelR.setVisible(false);
				FailureRegisterLabelR.setVisible(true);
				break;
			};
		}
		//----------------------------------
		//login panel
		public void LoginBackToWelcomeL() {
			LoginErrorLabelL.setVisible(false);
			LoginPanelL.setVisible(false);
			WelcomePanelL.setVisible(true);
		}
		public void LoginBackToWelcomeR() {
			LoginErrorLabelL.setVisible(false);
			LoginPanelR.setVisible(false);
			WelcomePanelR.setVisible(true);
		}
		
		public void LogInL() {
			Statement komunikat = gameFacade.VerifyAccount(AccountTextFieldL.getText(), PasswordTextFieldL.getText());
			switch (komunikat.getInformation()) {
			case "admin":
				userL = komunikat.getUser();
				WelcomeAdminLabelL.setText("Welcome " + userL.getNickname());
				LoginErrorLabelL.setVisible(false);
				LoginPanelL.setVisible(false);
				AdminPanelL.setVisible(true);
				break;
			case "player":
				userL = komunikat.getUser();
				WelcomePlayerLabelL.setText("Welcome " + userL.getNickname());
				LoginErrorLabelL.setVisible(false);
				LoginPanelL.setVisible(false);
				PlayerPanelL.setVisible(true);
				break;
			case "error":
				LoginErrorLabelL.setVisible(true);
				break;
			};
		}
		public void LogInR() {
			Statement komunikat = gameFacade.VerifyAccount(AccountTextFieldR.getText(), PasswordTextFieldR.getText());
			switch (komunikat.getInformation()) {
			case "admin":
				userR = komunikat.getUser();
				WelcomeAdminLabelR.setText("Welcome " + userR.getNickname());
				LoginErrorLabelR.setVisible(false);
				LoginPanelR.setVisible(false);
				AdminPanelR.setVisible(true);
				break;
			case "player":
				userR = komunikat.getUser();
				WelcomePlayerLabelR.setText("Welcome " + userR.getNickname());
				LoginErrorLabelR.setVisible(false);
				LoginPanelR.setVisible(false);
				PlayerPanelR.setVisible(true);
				break;
			case "error":
				LoginErrorLabelR.setVisible(true);
				break;
			};
		}
		
		//----------------------------------
		//----------------------------------
		//admin panel
		public void ToModifyL() {
			AdminPanelL.setVisible(false);
			ModifyPanelL.setVisible(true);
		}
		public void ToModifyR() {
			AdminPanelR.setVisible(false);
			ModifyPanelR.setVisible(true);
		}
		
		public void ToAddL() {
			AdminPanelL.setVisible(false);
			AddPanelL.setVisible(true);
		}
		public void ToAddR() {
			AdminPanelR.setVisible(false);
			AddPanelR.setVisible(true);
		}

		public void ToRemoveL() {
			AdminPanelL.setVisible(false);
			RemovePanelL.setVisible(true);
		}
		public void ToRemoveR() {
			AdminPanelR.setVisible(false);
			RemovePanelR.setVisible(true);
		}
		
		public void ToHistoryL() {
			AdminPanelL.setVisible(false);
			HistoryPanelL.setVisible(true);
		}
		public void ToHistoryR() {
			AdminPanelR.setVisible(false);
			HistoryPanelR.setVisible(true);
		}

		public void AdminBackToLoginL() {
			AdminPanelL.setVisible(false);
			LoginPanelL.setVisible(true);
		}
		public void AdminBackToLoginR() {
			AdminPanelR.setVisible(false);
			LoginPanelR.setVisible(true);
		}
		//----------------------------------
		//Modify panel
		public void ModifyBackToAdminL() {
			ModifyPanelL.setVisible(false);
			AdminPanelL.setVisible(true);
		}
		public void ModifyBackToAdminR() {
			ModifyPanelR.setVisible(false);
			AdminPanelR.setVisible(true);
		}
		
		public void ModifyTreeSourceL() {
			Item i = FindLastSelectedItem(TreeModifyL);
			if (i == null) {
				NameModifyTextFieldL.setText("---");
				PriceModifyTextFieldL.setText("---");
				BasicAttributeModifyTextFieldL.setText("---");
				ValueOfSAModifyTextFieldL.setText("---");
				SpecialAttributeModifyChoiceBoxL.setValue("NULL");
			} else {
				NameModifyTextFieldL.setText(i.getName());
				PriceModifyTextFieldL.setText(new Integer(i.getPrice()).toString());
								
				if (i instanceof HealingPotion) {
					BasicAttributeModifyTextFieldL.setText(new Integer(((HealingPotion) i).getHealing()).toString());
					ValueOfSAModifyTextFieldL.setText("---");
				} else {
					Collection<Statistic> stats = i.getStatistics().values();
					if (i instanceof AttackItem) {
						BasicAttributeModifyTextFieldL.setText(new Integer(((AttackItem)i).getDamage()).toString());
					} else {
						BasicAttributeModifyTextFieldL.setText(new Integer(((DefensiveItem)i).getDefDamage()).toString());
					}
					if (stats.size() > 0) {
						SpecialAttributeModifyChoiceBoxL.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
						ValueOfSAModifyTextFieldL.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					} else {
						ValueOfSAModifyTextFieldL.setText("---");
						SpecialAttributeModifyChoiceBoxL.setValue("NULL");
					}
				}
			}
		}
		public void ModifyTreeSourceR() {
			Item i = FindLastSelectedItem(TreeModifyR);
			if (i == null) {
				NameModifyTextFieldR.setText("---");
				PriceModifyTextFieldR.setText("---");
				BasicAttributeModifyTextFieldR.setText("---");
				ValueOfSAModifyTextFieldR.setText("---");
				SpecialAttributeModifyChoiceBoxR.setValue("NULL");
			} else {
				NameModifyTextFieldR.setText(i.getName());
				PriceModifyTextFieldR.setText(new Integer(i.getPrice()).toString());
								
				if (i instanceof HealingPotion) {
					BasicAttributeModifyTextFieldR.setText(new Integer(((HealingPotion) i).getHealing()).toString());
					ValueOfSAModifyTextFieldR.setText("---");
				} else {
					Collection<Statistic> stats = i.getStatistics().values();
					if (i instanceof AttackItem) {
						BasicAttributeModifyTextFieldR.setText(new Integer(((AttackItem)i).getDamage()).toString());
					} else {
						BasicAttributeModifyTextFieldR.setText(new Integer(((DefensiveItem)i).getDefDamage()).toString());
					}
					if (stats.size() > 0) {
						SpecialAttributeModifyChoiceBoxR.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
						ValueOfSAModifyTextFieldR.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					} else {
						ValueOfSAModifyTextFieldR.setText("---");
						SpecialAttributeModifyChoiceBoxR.setValue("NULL");
					}
				}
			}
		}
		
		public void ModifyApplyL() {
			StatisticsBag sb = new StatisticsBag();
			Item item = FindLastSelectedItem(TreeModifyL);

			switch (SpecialAttributeModifyChoiceBoxL.getSelectionModel().getSelectedItem()) {
			case "Hp":
				sb.addStatistic(new Statistic(1, new StatisticType(1, "Hp"), new Integer(ValueOfSAModifyTextFieldL.getText())));
				break;
			case "Mp":
				sb.addStatistic(new Statistic(2, new StatisticType(2, "Mp"), new Integer(ValueOfSAModifyTextFieldL.getText())));
				break;
			case "Str":
				sb.addStatistic(new Statistic(5, new StatisticType(5, "Str"), new Integer(ValueOfSAModifyTextFieldL.getText())));
				break;
			case "Agi":
				sb.addStatistic(new Statistic(6, new StatisticType(6, "Agi"), new Integer(ValueOfSAModifyTextFieldL.getText())));
				break;
			}					
			gameFacade.ModifyItem(item, NameModifyTextFieldL.getText(), new Integer(PriceModifyTextFieldL.getText()),
					sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
			TreeModifyL.setRoot(MakeTreeRootFromDataBase());
		}
		public void ModifyApplyR() {
			StatisticsBag sb = new StatisticsBag();
			Item item = FindLastSelectedItem(TreeModifyR);

			switch (SpecialAttributeModifyChoiceBoxR.getSelectionModel().getSelectedItem()) {
			case "Hp":
				sb.addStatistic(new Statistic(1, new StatisticType(1, "Hp"), new Integer(ValueOfSAModifyTextFieldR.getText())));
				break;
			case "Mp":
				sb.addStatistic(new Statistic(2, new StatisticType(2, "Mp"), new Integer(ValueOfSAModifyTextFieldR.getText())));
				break;
			case "Str":
				sb.addStatistic(new Statistic(5, new StatisticType(5, "Str"), new Integer(ValueOfSAModifyTextFieldR.getText())));
				break;
			case "Agi":
				sb.addStatistic(new Statistic(6, new StatisticType(6, "Agi"), new Integer(ValueOfSAModifyTextFieldR.getText())));
				break;
			}					
			gameFacade.ModifyItem(item, NameModifyTextFieldR.getText(), new Integer(PriceModifyTextFieldR.getText()), 
					sb, new Integer(BasicAttributeModifyTextFieldR.getText()).intValue());
			TreeModifyR.setRoot(MakeTreeRootFromDataBase());
		}
		//----------------------------------
		//Add panel
		public void AddBackToAdminL() {
			AddPanelL.setVisible(false);
			AdminPanelL.setVisible(true);
		}
		public void AddBackToAdminR() {
			AddPanelR.setVisible(false);
			AdminPanelR.setVisible(true);
		}
		
		public void AddApplyL() {
			StatisticsBag sb = new StatisticsBag();
			
			switch (SpecialAttributeAddChoiceBoxL.getSelectionModel().getSelectedItem()) {
			case "Hp":
				sb.addStatistic(new Statistic(1, new StatisticType(1, "Hp"), new Integer(ValueOfSAAddTextFieldL.getText())));
				break;
			case "Mp":
				sb.addStatistic(new Statistic(2, new StatisticType(2, "Mp"), new Integer(ValueOfSAAddTextFieldL.getText())));
				break;
			case "Str":
				sb.addStatistic(new Statistic(5, new StatisticType(5, "Str"), new Integer(ValueOfSAAddTextFieldL.getText())));
				break;
			case "Agi":
				sb.addStatistic(new Statistic(6, new StatisticType(6, "Agi"), new Integer(ValueOfSAAddTextFieldL.getText())));
				break;
			}	
			Item item = null;
			int id = gameFacade.getDataBase().getItemRepository().GetAll().size() + 1;	
			switch (ItemTypeAddChoiceBoxL.getSelectionModel().getSelectedItem()) {
			case "Sword":
				item = new Sword(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;
			case "Spear":
				item = new Spear(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;
			case "Armor":
				item = new Armor(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;
			case "Shield":
				item = new Shield(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;
			/*case "HealingPotion":
				item = new Sword(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;*/
			}
			gameFacade.AddItem(item);
			TreeAddL.setRoot(MakeTreeRootFromDataBase());
		}
		public void AddApplyR() {
			StatisticsBag sb = new StatisticsBag();
			
			switch (SpecialAttributeAddChoiceBoxR.getSelectionModel().getSelectedItem()) {
			case "Hp":
				sb.addStatistic(new Statistic(1, new StatisticType(1, "Hp"), new Integer(ValueOfSAAddTextFieldR.getText())));
				break;
			case "Mp":
				sb.addStatistic(new Statistic(2, new StatisticType(2, "Mp"), new Integer(ValueOfSAAddTextFieldR.getText())));
				break;
			case "Str":
				sb.addStatistic(new Statistic(5, new StatisticType(5, "Str"), new Integer(ValueOfSAAddTextFieldR.getText())));
				break;
			case "Agi":
				sb.addStatistic(new Statistic(6, new StatisticType(6, "Agi"), new Integer(ValueOfSAAddTextFieldR.getText())));
				break;
			}	
			Item item = null;
			int id = gameFacade.getDataBase().getItemRepository().GetAll().size() + 1;	
			switch (ItemTypeAddChoiceBoxR.getSelectionModel().getSelectedItem()) {
			case "Sword":
				item = new Sword(id, NameAddTextFieldR.getText(), new Integer(PriceAddTextFieldR.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldR.getText()).intValue());
				break;
			case "Spear":
				item = new Spear(id, NameAddTextFieldR.getText(), new Integer(PriceAddTextFieldR.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldR.getText()).intValue());
				break;
			case "Armor":
				item = new Armor(id, NameAddTextFieldR.getText(), new Integer(PriceAddTextFieldR.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldR.getText()).intValue());
				break;
			case "Shield":
				item = new Shield(id, NameAddTextFieldR.getText(), new Integer(PriceAddTextFieldR.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldR.getText()).intValue());
				break;
			/*case "HealingPotion":
				item = new Sword(id, NameAddTextFieldL.getText(), new Integer(PriceAddTextFieldL.getText()).intValue(),
						sb, new Integer(BasicAttributeModifyTextFieldL.getText()).intValue());
				break;*/
			}
			gameFacade.AddItem(item);
			TreeAddR.setRoot(MakeTreeRootFromDataBase());
		}
		//----------------------------------
		//Remove panel
		public void RemoveBackToAdminL() {
			RemovePanelL.setVisible(false);
			AdminPanelL.setVisible(true);
		}
		public void RemoveBackToAdminR() {
			RemovePanelR.setVisible(false);
			AdminPanelR.setVisible(true);
		}
		
		public void RemoveApplyL() {
			gameFacade.RemoveItem(FindLastSelectedItem(TreeRemoveL));
		}
		public void RemoveApplyR() {
			gameFacade.RemoveItem(FindLastSelectedItem(TreeRemoveR));
		}
		//----------------------------------
		//History panel
		public void HistoryBackToAdminL() {
			if (SpecifyHistoryTableViewL.isVisible() == true) {
				SpecifyHistoryTableViewL.setVisible(false);
				HistoryTableViewL.setVisible(true);
			} else {
				HistoryPanelL.setVisible(false);
				AdminPanelL.setVisible(true);
			}
		}
		public void HistoryBackToAdminR() {
			if (SpecifyHistoryTableViewR.isVisible() == true) {
				SpecifyHistoryTableViewR.setVisible(false);
				HistoryTableViewR.setVisible(true);
			} else {
				HistoryPanelR.setVisible(false);
				AdminPanelR.setVisible(true);
			}
		}
			
		public void HistorySpecifyL() {
			int id = new Integer(HistoryTableViewL.selectionModelProperty().getValue().getSelectedItem().getA());
			SpecifyHistoryTableViewL.setItems(SpecifyHistoryTabelByID(id));
			
			HistoryTableViewL.setVisible(false);
			SpecifyHistoryTableViewL.setVisible(true);		
		}
		public void HistorySpecifyR() {
			int id = new Integer(HistoryTableViewR.selectionModelProperty().getValue().getSelectedItem().getA());
			SpecifyHistoryTableViewR.setItems(SpecifyHistoryTabelByID(id));
			
			HistoryTableViewR.setVisible(false);
			SpecifyHistoryTableViewR.setVisible(true);
		}
		
		//----------------------------------
		//----------------------------------
		//Player panel
		public void PlayerBackToLoginL() {
			PlayerPanelL.setVisible(false);
			LoginPanelL.setVisible(true);
		}
		public void PlayerBackToLoginR() {
			PlayerPanelR.setVisible(false);
			LoginPanelR.setVisible(true);
		}
		
		public void ToEQL() {
			EQTableViewL.setItems(ConvertEQToTable(((Player)userL).getEquipment().getPlayerItems()));
			MoneyEQLabelL.setText("Money " + new Integer(((Player)userL).getEquipment().getGold()).toString());
			PlayerPanelL.setVisible(false);
			EQPanelL.setVisible(true);
		}
		public void ToEQR() {
			EQTableViewR.setItems(ConvertEQToTable(((Player)userR).getEquipment().getPlayerItems()));
			MoneyEQLabelR.setText("Money " + new Integer(((Player)userR).getEquipment().getGold()).toString());
			PlayerPanelR.setVisible(false);
			EQPanelR.setVisible(true);
		}
		
		public void ToShopL() {
			MoneyShopLabelL.setText("Money " + new Integer(((Player)userL).getEquipment().getGold()).toString());
			PlayerPanelL.setVisible(false);
			ShopPanelL.setVisible(true);
		}
		public void ToShopR() {
			MoneyShopLabelR.setText("Money " + new Integer(((Player)userR).getEquipment().getGold()).toString());
			PlayerPanelR.setVisible(false);
			ShopPanelR.setVisible(true);
		}
		
		public void ToBattlefield() {
			if (ReadyButtonL.isSelected() == true && ReadyButtonR.isSelected() == true) {
				Random r = new Random();
				if ((r.nextInt() % 101) > 50)
					BlockGUI(true);
				else BlockGUI(false);
				
				PlayerPanelL.setVisible(false);
				PlayerPanelR.setVisible(false);
				BattlefieldPanelL.setVisible(true);
				BattlefieldPanelR.setVisible(true);
				BattlefieldNameLabelL.setText("Gracz " + userL.getNickname() + " -> " + new Integer(((Player)userL).getCurrentHp()).toString() + "Hp\n");
				BattlefieldNameLabelR.setText("Gracz " + userR.getNickname() + " -> " + new Integer(((Player)userR).getCurrentHp()).toString() + "Hp\n");
			}
		}
		//----------------------------------
		//EQ panel
		public void EQBackToPlayerL() {
			EQPanelL.setVisible(false);
			PlayerPanelL.setVisible(true);
		}
		public void EQBackToPlayerR() {
			EQPanelR.setVisible(false);
			PlayerPanelR.setVisible(true);
		}
		
		public void UseItemL() {
			gameFacade.UseItemInEQ(FindItemByName(EQTableViewL.selectionModelProperty().getValue().getSelectedItem().getA()));
		}
		public void UseItemR() {
			gameFacade.UseItemInEQ(FindItemByName(EQTableViewR.selectionModelProperty().getValue().getSelectedItem().getA()));
		}
		//----------------------------------
		//Shop panel
		public void ShopBackToPlayerL() {
			ShopPanelL.setVisible(false);
			PlayerPanelL.setVisible(true);
		}
		public void ShopBackToPlayerR() {
			ShopPanelR.setVisible(false);
			PlayerPanelR.setVisible(true);
		}
		
		public void RadioButtonsSelectBuyL() {
			ShopTableViewL.setItems(ConvertShopBuyToTable(gameFacade.getDataBase().getItemRepository().GetAll()));
			SellRadioButtonL.setSelected(false);
			SellRadioButtonL.setDisable(false);
			BuyRadioButtonL.setDisable(true);
		}
		public void RadioButtonsSelectSellL() {
			ShopTableViewL.setItems(ConvertShopBuyToTable(((Player)userL).getEquipment().getPlayerItems()));
			BuyRadioButtonL.setSelected(false);	
			BuyRadioButtonL.setDisable(false);
			SellRadioButtonL.setDisable(true);
		}
		public void RadioButtonsSelectBuyR() {
			ShopTableViewR.setItems(ConvertShopBuyToTable(gameFacade.getDataBase().getItemRepository().GetAll()));
			SellRadioButtonR.setSelected(false);
			SellRadioButtonR.setDisable(false);
			BuyRadioButtonR.setDisable(true);
		}
		public void RadioButtonsSelectSellR() {
			ShopTableViewR.setItems(ConvertShopBuyToTable(((Player)userR).getEquipment().getPlayerItems()));
			BuyRadioButtonR.setSelected(false);
			BuyRadioButtonR.setDisable(false);
			SellRadioButtonR.setDisable(true);
		}
		
		public void BuyOrSellL() {
			Statement komunikat = new Statement("success");
			Item item = FindItemByName(ShopTableViewL.selectionModelProperty().getValue().getSelectedItem().getA());
			if (BuyRadioButtonL.isArmed())
				komunikat = gameFacade.ItemBuy(userL, item);
			else {
				gameFacade.ItemSell(userL, item);
				ShopTableViewL.setItems(ConvertShopBuyToTable(((Player)userL).getEquipment().getPlayerItems()));
			}
			
			if (komunikat.getInformation().equals("error"))
					ChatTextArea.appendText("Graczowi " + userL.getNickname() + " nie powiodlo sie kupic " + item.getName() + " bo mial za malo pieniedzy\n");
			else if (BuyRadioButtonL.isArmed())
				ChatTextArea.appendText("Gracz " + userL.getNickname() + " kupil " + item.getName() + "\n");
			else ChatTextArea.appendText("Gracz " + userL.getNickname() + " sprzedal " + item.getName() + "\n");
			
			MoneyShopLabelL.setText("Money " + new Integer(((Player)userL).getEquipment().getGold()).toString());
		}
		public void BuyOrSellR() {
			Statement komunikat = new Statement("success");
			Item item = FindItemByName(ShopTableViewR.selectionModelProperty().getValue().getSelectedItem().getA());
			if (BuyRadioButtonR.isArmed())
				komunikat = gameFacade.ItemBuy(userR, item);
			else {
				gameFacade.ItemSell(userR, item);
				ShopTableViewR.setItems(ConvertShopBuyToTable(((Player)userR).getEquipment().getPlayerItems()));
			}
			
			if (komunikat.getInformation().equals("error"))
					ChatTextArea.appendText("Graczowi " + userR.getNickname() + " nie powiodlo sie kupic " + item.getName() + " bo mial za malo pieniedzy");
			else if (BuyRadioButtonR.isArmed())
				ChatTextArea.appendText("Gracz " + userR.getNickname() + " kupil " + item.getName());
			else ChatTextArea.appendText("Gracz " + userR.getNickname() + " sprzedal " + item.getName());
			
			MoneyShopLabelR.setText("Money " + new Integer(((Player)userR).getEquipment().getGold()).toString());
		}
		//----------------------------------
		//Battlefield panel
		public void AttackL() {
			Statement komunikat = null;
			komunikat = gameFacade.Attack(userL, userR);
			
			ChatTextArea.appendText("Gracz " + userL.getNickname() + " zaatakowal " + userR.getNickname() + " i wybil mu "
					+ new Integer(komunikat.getValue()).toString() + " obrazen!\n");
			if (komunikat.getInformation().equals("killed")) {
				BattlefieldPanelL.setVisible(false); 
				BattlefieldPanelR.setVisible(false);
				BattlefieldPanelL.setDisable(false); //odblokowanie obu
				BattlefieldPanelR.setDisable(false);
				ChatTextArea.appendText("Gracz " + userL.getNickname() + " ZABIL " + userR.getNickname() + "\n");
				ReadyButtonL.setSelected(false);
				ReadyButtonR.setSelected(false);
				PlayerPanelL.setVisible(true);
				PlayerPanelR.setVisible(true);
			} else {
				BattlefieldNameLabelR.setText("Gracz " + userR.getNickname() + " -> " + new Integer(((Player)userR).getCurrentHp()).toString() + "Hp\n");
				BlockGUI(true);
			}
		}
		public void AttackR() {
			Statement komunikat = null;
			komunikat = gameFacade.Attack(userR, userL);
			
			ChatTextArea.appendText("Gracz " + userR.getNickname() + " zaatakowal " + userL.getNickname() + " i wybil mu "
					+ new Integer(komunikat.getValue()).toString() + " obrazen!\n");
			if (komunikat.getInformation().equals("killed")) {
				BattlefieldPanelL.setVisible(false); 
				BattlefieldPanelR.setVisible(false);
				BattlefieldPanelL.setDisable(false); //odblokowanie obu
				BattlefieldPanelR.setDisable(false);
				ChatTextArea.appendText("Gracz " + userR.getNickname() + " ZABIL " + userL.getNickname() + "\n");
				ReadyButtonL.setSelected(false);
				ReadyButtonR.setSelected(false);
				PlayerPanelL.setVisible(true);
				PlayerPanelR.setVisible(true);
			} else {
				BattlefieldNameLabelL.setText("Gracz " + userL.getNickname() + " -> " + new Integer(((Player)userL).getCurrentHp()).toString() + "Hp\n");
				BlockGUI(false);
			}
		}
		
		public void RestL() {
			gameFacade.Rest(userL);
			ChatTextArea.appendText("Gracz " + userL.getNickname() + " odpoczal i zregenerowal troche zdrowia\n");
			BattlefieldNameLabelL.setText("Gracz " + userL.getNickname() + " -> " + new Integer(((Player)userL).getCurrentHp()).toString() + "Hp\n");
			BlockGUI(true);
		}
		public void RestR() {
			gameFacade.Rest(userR);
			ChatTextArea.appendText("Gracz " + userR.getNickname() + " odpoczal i zregenerowal troche zdrowia\n");
			BattlefieldNameLabelR.setText("Gracz " + userR.getNickname() + " -> " + new Integer(((Player)userR).getCurrentHp()).toString() + "Hp\n");
			BlockGUI(false);
		}
		
		public void ToUseItemL() {
			PickItemTableViewL.setItems(ConvertUseItemsToTable(((Player)userL).getEquipment().getPlayerItems()));
			BattlefieldPanelL.setVisible(false);
			PickItemPanelL.setVisible(true);
		}
		public void ToUseItemR() {
			PickItemTableViewR.setItems(ConvertUseItemsToTable(((Player)userR).getEquipment().getPlayerItems()));
			BattlefieldPanelR.setVisible(false);
			PickItemPanelR.setVisible(true);
		}
		//----------------------------------
		//Pick Item panel
		public void PickItemBackToBattlefieldL() {
			PickItemPanelL.setVisible(false);
			BattlefieldPanelL.setVisible(true);
		}
		public void PickItemBackToBattlefieldR() {
			PickItemPanelR.setVisible(false);
			BattlefieldPanelR.setVisible(true);
		}
		
		public void ConsumeItemL() {
			Item item = FindItemByName(PickItemTableViewL.selectionModelProperty().getValue().getSelectedItem().getA());
			gameFacade.ConsumeItem(item);
			ChatTextArea.appendText("Gracz " + userL.getNickname() + " uzyl " + item.getName() + " i uleczyl sie za " 
					+ new Integer(((HealingPotion)item).getHealing()).toString() + "Hp\n");
			BattlefieldNameLabelL.setText("Gracz " + userL.getNickname() + " -> " + new Integer(((Player)userL).getCurrentHp()).toString() + "Hp\n");
			PickItemBackToBattlefieldL();
			BlockGUI(true);
		}
		public void ConsumeItemR() {
			Item item = FindItemByName(PickItemTableViewR.selectionModelProperty().getValue().getSelectedItem().getA());
			gameFacade.ConsumeItem(item);
			ChatTextArea.appendText("Gracz " + userR.getNickname() + " uzyl " + item.getName() + " i uleczyl sie za " 
					+ new Integer(((HealingPotion)item).getHealing()).toString() + "Hp\n");
			BattlefieldNameLabelR.setText("Gracz " + userR.getNickname() + " -> " + new Integer(((Player)userR).getCurrentHp()).toString() + "Hp\n");
			PickItemBackToBattlefieldR();
			BlockGUI(false);
		}
		
		
		//----------------------------------
		//----------------------------------
		//Other methods
		public Controller() {}
		
		private TreeItem<String> MakeTreeRootFromDataBase() {
			TreeItem<String> rootItem = new TreeItem<String>("Items");
			rootItem.setExpanded(true);
			
			//000000000000000000000000000
			TreeItem<String> defensiveItems = new TreeItem<String> ("Defensive Items");            
            rootItem.getChildren().add(defensiveItems);
            defensiveItems.setExpanded(true);
            
            TreeItem<String> armorItems = new TreeItem<String> ("Armor Items");            
            defensiveItems.getChildren().add(armorItems);
            armorItems.setExpanded(true);
            
            TreeItem<String> shieldItems = new TreeItem<String> ("Shield Items");            
            defensiveItems.getChildren().add(shieldItems);
            shieldItems.setExpanded(true);
            
            //000000000000000000000000000
            TreeItem<String> attackItems = new TreeItem<String> ("Attack Items");            
            rootItem.getChildren().add(attackItems);
            attackItems.setExpanded(true);
            
            TreeItem<String> swordItems = new TreeItem<String> ("Sword Items");            
            attackItems.getChildren().add(swordItems);
            swordItems.setExpanded(true);
            
            TreeItem<String> spearItems = new TreeItem<String> ("Spear Items");            
            attackItems.getChildren().add(spearItems);
            spearItems.setExpanded(true);
            
            //000000000000000000000000000
            TreeItem<String> usableItems = new TreeItem<String> ("Usable Items");            
            rootItem.getChildren().add(usableItems);
            usableItems.setExpanded(true);
            
            TreeItem<String> healingPotionItems = new TreeItem<String> ("Healing Potion Items");            
            usableItems.getChildren().add(healingPotionItems);
            
          //000000000000000000000000000
          //000000000000000000000000000
            
            DataBase db = gameFacade.getDataBase();
			List<Item> allItems = db.getItemRepository().GetAll();
			
			for (Item i : allItems) {
				TreeItem<String> item = new TreeItem<String> (i.getName());
				if (i instanceof Armor) {
					armorItems.getChildren().add(item);
				} else if (i instanceof Shield) {
					shieldItems.getChildren().add(item);
				} else if (i instanceof Sword) {
					swordItems.getChildren().add(item);
				} else if (i instanceof Spear) {
					spearItems.getChildren().add(item);
				}
				else if (i instanceof HealingPotion) {
					healingPotionItems.getChildren().add(item);
				}
			}
			
			return rootItem;
		}
		
		private Item FindLastSelectedItem(TreeView<String> treeView) {
			String name = treeView.getSelectionModel().getSelectedItem().getValue();
			
			DataBase db = gameFacade.getDataBase();
			List<Item> allItems = db.getItemRepository().GetAll();
			
			for (Item i : allItems) {
				if(name.equals(i.getName())) {
					return i;
				}
			}
			return null;
		}
		
		private Item FindItemByName(String name) {		
			DataBase db = gameFacade.getDataBase();
			List<Item> allItems = db.getItemRepository().GetAll();
			
			for (Item i : allItems) {
				if(name.equals(i.getName())) {
					return i;
				}
			}
			return null;
		}

		
		public static class TableRow { //struktura przechowywujaca potrzebna do tableView
			public String a, b, c, d;
			TableRow(String a, String b) {
				this.a = a;
				this.b = b;
			}
			TableRow(String a, String b, String c) {
				this.a = a;
				this.b = b;
				this.c = c;
			}
			TableRow(String a, String b, String c, String d) {
				this.a = a;
				this.b = b;
				this.c = c;
				this.d = d;
			}
			
			public String getA() { return a; }
			public String getB() { return b; }
			public String getC() { return c; }
			public String getD() { return d; }
		}
		
		private ObservableList<TableRow> ConvertHistoryToTable() {
			DataBase db = gameFacade.getDataBase();
			List<BattlefieldHistory> history = db.getBattleFieldHistoryRepository().GetAll();
			
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			for (BattlefieldHistory h : history) {
				data.add(new TableRow(new Integer(h.getId()).toString(), h.getPlayer1().getNickname(), 
						h.getPlayer2().getNickname(), h.getWhoWonPlayerId().getNickname()));
			}
			return data;
		}
		
		private ObservableList<TableRow> SpecifyHistoryTabelByID(int id) {
			DataBase db = gameFacade.getDataBase();
			List<BattlefieldHistory> history = db.getBattleFieldHistoryRepository().GetAll();
			Set<BattlefieldActionsHistory> actions = null;
			for (BattlefieldHistory h : history) {
				if (h.getId() == id) {
					actions = h.getActions();
					break;
				}
			}
			
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			for (BattlefieldActionsHistory a : actions) {
				data.add(new TableRow(a.getActionByPlayer().getNickname(), a.getActionDescription(), new Integer(a.getValue()).toString()));
			}
			return data;
		}
		
		
		private ObservableList<TableRow> ConvertShopBuyToTable(List<Item> items) {		
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			for (Item i : items) {
				if (i instanceof AttackItem)
					data.add(new TableRow(i.getName(), new Integer(((AttackItem)i).DealDamage()).toString(),
							((Statistic) i.getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
									new Integer(((Statistic) i.getStatistics().values().toArray()[0]).getValue()).toString(), 
							new Integer(i.getPrice()).toString()));
				else if (i instanceof DefensiveItem)
					data.add(new TableRow(i.getName(), new Integer(((DefensiveItem)i).getDefDamage()).toString(),
							((Statistic) i.getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
									new Integer(((Statistic) i.getStatistics().values().toArray()[0]).getValue()).toString(), 
							new Integer(i.getPrice()).toString()));
				else if (i instanceof HealingPotion)
					data.add(new TableRow(i.getName(), new Integer(((HealingPotion)i).getHealing()).toString(),
							"---", 
							new Integer(i.getPrice()).toString()));
			}
			return data;
		}
		private ObservableList<TableRow> ConvertShopBuyToTable(Set<PlayerItem> items) {		
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			for (PlayerItem i : items) {
				if (i.getItem() instanceof AttackItem)
					data.add(new TableRow(i.getItem().getName(), new Integer(((AttackItem)i.getItem()).DealDamage()).toString(),
							((Statistic) i.getItem().getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
									new Integer(((Statistic) i.getItem().getStatistics().values().toArray()[0]).getValue()).toString(), 
							new Integer(i.getItem().getPrice()).toString()));
				else if (i.getItem() instanceof DefensiveItem)
					data.add(new TableRow(i.getItem().getName(), new Integer(((DefensiveItem)i.getItem()).getDefDamage()).toString(),
							((Statistic) i.getItem().getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
									new Integer(((Statistic) i.getItem().getStatistics().values().toArray()[0]).getValue()).toString(), 
							new Integer(i.getItem().getPrice()).toString()));
				else if (i.getItem() instanceof HealingPotion)
					data.add(new TableRow(i.getItem().getName(), new Integer(((HealingPotion)i.getItem()).getHealing()).toString(),
							"---", 
							new Integer(i.getItem().getPrice()).toString()));
			}
			return data;
		}
		
		private ObservableList<TableRow> ConvertEQToTable(Set<PlayerItem> items) {		
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			String equiped;
			for (PlayerItem i : items) {
				if (i.isEquiped()) equiped = "*";
				else equiped = "";
						
				if (i.getItem() instanceof AttackItem)
					data.add(new TableRow(i.getItem().getName(), new Integer(((AttackItem)i.getItem()).DealDamage()).toString(),
							((Statistic) i.getItem().getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
							new Integer(((Statistic) i.getItem().getStatistics().values().toArray()[0]).getValue()).toString(), equiped));
				else if (i.getItem() instanceof DefensiveItem)
					data.add(new TableRow(i.getItem().getName(), new Integer(((DefensiveItem)i.getItem()).getDefDamage()).toString(),
							((Statistic) i.getItem().getStatistics().values().toArray()[0]).getStatisticType().getName() + " " +
							new Integer(((Statistic) i.getItem().getStatistics().values().toArray()[0]).getValue()).toString(), equiped));
				else if (i.getItem() instanceof HealingPotion)
					data.add(new TableRow(i.getItem().getName(), new Integer(((HealingPotion)i.getItem()).getHealing()).toString(),
							"---", 
							new Integer(i.getItem().getPrice()).toString()));
			}
			return data;
		}
		
		private ObservableList<TableRow> ConvertUseItemsToTable(Set<PlayerItem> items) {		
			ObservableList<TableRow> data = FXCollections.observableArrayList();
			
			for (PlayerItem i : items) {
				if (i.getItem() instanceof HealingPotion)
					data.add(new TableRow(i.getItem().getName(), new Integer(((HealingPotion)i.getItem()).getHealing()).toString()));
			}
			return data;
		}
		//----------------------------------
		//----------------------------------
		private void BlockGUI(Boolean left) {
			if (left == true) {
				BattlefieldPanelL.setDisable(true);
				BattlefieldPanelR.setDisable(false);
			} else {
				BattlefieldPanelR.setDisable(true);
				BattlefieldPanelL.setDisable(false);
			}
		}
		//----------------------------------
		//----------------------------------
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {			
			TreeModifyL.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeModifyChoiceBoxL.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi", "NULL"));
			
			TreeModifyR.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeModifyChoiceBoxR.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi", "NULL"));
			
			
			TreeAddL.setRoot(MakeTreeRootFromDataBase());
			ItemTypeAddChoiceBoxL.setItems(FXCollections.observableArrayList(
					"Armor", "Shield", "Sword", "Spear"));
			SpecialAttributeAddChoiceBoxL.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi", "NULL"));
			
			TreeAddR.setRoot(MakeTreeRootFromDataBase());
			ItemTypeAddChoiceBoxR.setItems(FXCollections.observableArrayList(
					"Armor", "Shield", "Sword", "Spear"));
			SpecialAttributeAddChoiceBoxR.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi", "NULL"));
			
			
			TreeRemoveL.setRoot(MakeTreeRootFromDataBase());
			TreeRemoveR.setRoot(MakeTreeRootFromDataBase());
			
			
			HistoryTableViewL.setItems(ConvertHistoryToTable());
			HistoryTableViewR.setItems(ConvertHistoryToTable());
			
			ShopTableViewL.setItems(ConvertShopBuyToTable(gameFacade.getDataBase().getItemRepository().GetAll()));
			ShopTableViewR.setItems(ConvertShopBuyToTable(gameFacade.getDataBase().getItemRepository().GetAll()));
			
			//-------------------------------------------------------------------------------------
			IDHistoryColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			IDHistoryColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			
			p1NameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			p1NameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			
			p2NameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			p2NameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			
			winNameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			winNameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			//-------------------------------------------------------------------------------------
			WhoColumnSpecifyHistoryL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			WhoColumnSpecifyHistoryR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			
			ActionColumnSpecifyHistoryL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			ActionColumnSpecifyHistoryR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			
			ValueColumnSpecifyHistoryL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			ValueColumnSpecifyHistoryR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			//-------------------------------------------------------------------------------------
			ShopNameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			ShopNameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			
			ShopBAColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			ShopBAColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			
			ShopSAColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			ShopSAColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			
			ShopPriceColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			ShopPriceColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			//-------------------------------------------------------------------------------------
			EQNameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			EQNameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			
			EQBAColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			EQBAColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			
			EQSAColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			EQSAColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("C"));
			
			EQUsedColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			EQUsedColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("D"));
			//-------------------------------------------------------------------------------------
			PickItemNameColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			PickItemNameColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("A"));
			
			PickItemAttributeColumnL.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
			PickItemAttributeColumnR.setCellValueFactory(new PropertyValueFactory<TableRow,String>("B"));
		}
}


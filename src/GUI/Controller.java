package GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collection;
import java.util.List;
import DataAccessLayer.DataBase;
import Models.Armor;
import Models.BattlefieldHistory;
import Models.HealingPotion;
import Models.Item;
import Models.Shield;
import Models.Statistic;
import Models.StatisticTypeEnum;
import Models.Sword;

@SuppressWarnings("restriction")
public class Controller {
	private GameFacade gameFacade = new GameFacade();  // <<--- dostep do fasady
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
	private TableView<HistoryRow> HistoryTableViewL;
	@FXML
	private TableView<HistoryRow> HistoryTableViewR;
	@FXML
	private TableView<HistoryRow> SpecifyHistoryTableViewL;
	@FXML
	private TableView<HistoryRow> SpecifyHistoryTableViewR;
	
	@FXML
	private TableView<String> EQTableViewL;
	@FXML
	private TableView<String> EQTableViewR;
	
	//---------------------------------------
	//---------------------------------------
	//ChoiceBoxes
	@FXML
	private ChoiceBox<String> SpecialAttributeModifyChoiceBoxL;
	@FXML
	private ChoiceBox<String> SpecialAttributeModifyChoiceBoxR;
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
			switch (gameFacade.RegisterUser(AccountRegisterTextFieldL.getText(), PasswordRegisterTextFieldL.getText())) {
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
			switch (gameFacade.RegisterUser(AccountRegisterTextFieldR.getText(), PasswordRegisterTextFieldR.getText())) {
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
			switch (gameFacade.VerifyAccount(AccountTextFieldL.getText(), PasswordTextFieldL.getText())) {
			case "admin":
				LoginErrorLabelL.setVisible(false);
				LoginPanelL.setVisible(false);
				AdminPanelL.setVisible(true);
				break;
			case "player":
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
			switch (gameFacade.VerifyAccount(AccountTextFieldR.getText(), PasswordTextFieldR.getText())) {
			case "admin":
				LoginErrorLabelR.setVisible(false);
				LoginPanelR.setVisible(false);
				AdminPanelR.setVisible(true);
				break;
			case "player":
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
			TreeModifyL.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeModifyChoiceBoxL.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi"));
			AdminPanelL.setVisible(false);
			ModifyPanelL.setVisible(true);
		}
		public void ToModifyR() {
			TreeModifyR.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeModifyChoiceBoxR.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi"));
			AdminPanelR.setVisible(false);
			ModifyPanelR.setVisible(true);
		}
		
		public void ToAddL() {
			TreeAddL.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeAddChoiceBoxL.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi"));
			AdminPanelL.setVisible(false);
			AddPanelL.setVisible(true);
		}
		public void ToAddR() {
			TreeAddR.setRoot(MakeTreeRootFromDataBase());
			SpecialAttributeAddChoiceBoxR.setItems(FXCollections.observableArrayList(
					"Hp", "Mp", "Str", "Agi"));
			AdminPanelR.setVisible(false);
			AddPanelR.setVisible(true);
		}

		public void ToRemoveL() {
			TreeRemoveL.setRoot(MakeTreeRootFromDataBase());
			AdminPanelL.setVisible(false);
			RemovePanelL.setVisible(true);
		}
		public void ToRemoveR() {
			TreeRemoveR.setRoot(MakeTreeRootFromDataBase());
			AdminPanelR.setVisible(false);
			RemovePanelR.setVisible(true);
		}
		
		public void ToHistoryL() {
			HistoryTableViewL.setItems(ConvertHistoryToTable());
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
			} else {
				NameModifyTextFieldL.setText(i.getName());
				PriceModifyTextFieldL.setText(new Integer(i.getPrice()).toString());
			
				Collection<Statistic> stats = i.getStatistics().values();					
				if (i instanceof HealingPotion) {
					BasicAttributeModifyTextFieldL.setText("---");
					SpecialAttributeModifyChoiceBoxL.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
					ValueOfSAModifyTextFieldL.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
				} else {
					BasicAttributeModifyTextFieldL.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					if (stats.size() > 1) {
						SpecialAttributeModifyChoiceBoxL.getSelectionModel().select(((Statistic) stats.toArray()[1]).getStatisticType().getName());
						ValueOfSAModifyTextFieldL.setText(new Integer(((Statistic) stats.toArray()[1]).getValue()).toString());
					} else ValueOfSAModifyTextFieldL.setText("---");
				}
				
				/*ValueOfSAModifyTextFieldL.setText("---");
				for (Statistic stat : stats) {
					if (i instanceof HealingPotion) {
						BasicAttributeModifyTextFieldL.setText("---");
						SpecialAttributeModifyChoiceBoxL.getSelectionModel().select(stat.getStatisticType().getName());
						ValueOfSAModifyTextFieldL.setText(new Integer(stat.getValue()).toString());
					} else {
						if (stat.getStatisticType().getTypeEnum().equals(StatisticTypeEnum .DealDmg) 
								|| stat.getStatisticType().getTypeEnum().equals(StatisticTypeEnum .Armor)) {
							BasicAttributeModifyTextFieldL.setText(new Integer(stat.getValue()).toString());
						} 
						else {
							SpecialAttributeModifyChoiceBoxL.getSelectionModel().select(stat.getStatisticType().getName());
							ValueOfSAModifyTextFieldL.setText(new Integer(stat.getValue()).toString());
						}
					}
				}*/
			}
		}
		public void ModifyTreeSourceR() {
			Item i = FindLastSelectedItem(TreeModifyR);
			if (i == null) {
				NameModifyTextFieldR.setText("---");
				PriceModifyTextFieldR.setText("---");
				BasicAttributeModifyTextFieldR.setText("---");
				ValueOfSAModifyTextFieldR.setText("---");
			} else {
				NameModifyTextFieldR.setText(i.getName());
				PriceModifyTextFieldR.setText(new Integer(i.getPrice()).toString());
			
				Collection<Statistic> stats = i.getStatistics().values();
				if (i instanceof HealingPotion) {
					BasicAttributeModifyTextFieldR.setText("---");
					SpecialAttributeModifyChoiceBoxR.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
					ValueOfSAModifyTextFieldR.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
				} else {
					BasicAttributeModifyTextFieldR.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					if (stats.size() > 1) {
						SpecialAttributeModifyChoiceBoxR.getSelectionModel().select(((Statistic) stats.toArray()[1]).getStatisticType().getName());
						ValueOfSAModifyTextFieldR.setText(new Integer(((Statistic) stats.toArray()[1]).getValue()).toString());
					} else ValueOfSAModifyTextFieldR.setText("---");
				}
			}
		}
		
		public void ModifyApplyL() {
			gameFacade.ModifyItem(FindLastSelectedItem(TreeModifyL), NameModifyTextFieldL.getText(), 
					PriceModifyTextFieldL.getText(), BasicAttributeModifyTextFieldL.getText(), 
					SpecialAttributeModifyChoiceBoxL.getSelectionModel().getSelectedItem(), ValueOfSAModifyTextFieldL.getText());
			TreeModifyL.setRoot(MakeTreeRootFromDataBase());
		}
		public void ModifyApplyR() {
			gameFacade.ModifyItem(FindLastSelectedItem(TreeModifyR), NameModifyTextFieldR.getText(), 
					PriceModifyTextFieldR.getText(), BasicAttributeModifyTextFieldR.getText(), 
					SpecialAttributeModifyChoiceBoxR.getSelectionModel().getSelectedItem(), ValueOfSAModifyTextFieldR.getText());
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
		
		/*public void AddTreeSourceL() {
			Item i = FindLastSelectedItem(TreeModifyR);
			if (i == null) {
				NameAddTextFieldL.setText("---");
				PriceAddTextFieldL.setText("---");
				BasicAttributeAddTextFieldL.setText("---");
				ValueOfSAAddTextFieldL.setText("---");
			} else {
				NameAddTextFieldL.setText(i.getName());
				PriceAddTextFieldL.setText(new Integer(i.getPrice()).toString());
			
				Collection<Statistic> stats = i.getStatistics().values();
				if (i instanceof HealingPotion) {
					BasicAttributeAddTextFieldL.setText("---");
					SpecialAttributeAddChoiceBoxL.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
					ValueOfSAAddTextFieldL.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
				} else {
					BasicAttributeAddTextFieldL.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					if (stats.size() > 1) {
						SpecialAttributeAddChoiceBoxL.getSelectionModel().select(((Statistic) stats.toArray()[1]).getStatisticType().getName());
						ValueOfSAAddTextFieldL.setText(new Integer(((Statistic) stats.toArray()[1]).getValue()).toString());
					} else ValueOfSAAddTextFieldL.setText("---");
				}
			}
		}
		public void AddTreeSourceR() {
			Item i = FindLastSelectedItem(TreeModifyR);
			if (i == null) {
				NameAddTextFieldR.setText("---");
				PriceAddTextFieldR.setText("---");
				BasicAttributeAddTextFieldR.setText("---");
				ValueOfSAAddTextFieldR.setText("---");
			} else {
				NameAddTextFieldR.setText(i.getName());
				PriceAddTextFieldR.setText(new Integer(i.getPrice()).toString());
			
				Collection<Statistic> stats = i.getStatistics().values();
				if (i instanceof HealingPotion) {
					BasicAttributeAddTextFieldR.setText("---");
					SpecialAttributeAddChoiceBoxR.getSelectionModel().select(((Statistic) stats.toArray()[0]).getStatisticType().getName());
					ValueOfSAAddTextFieldR.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
				} else {
					BasicAttributeAddTextFieldR.setText(new Integer(((Statistic) stats.toArray()[0]).getValue()).toString());
					if (stats.size() > 1) {
						SpecialAttributeAddChoiceBoxR.getSelectionModel().select(((Statistic) stats.toArray()[1]).getStatisticType().getName());
						ValueOfSAAddTextFieldR.setText(new Integer(((Statistic) stats.toArray()[1]).getValue()).toString());
					} else ValueOfSAAddTextFieldR.setText("---");
				}
			}
		}
		*/
		
		public void AddApplyL() {
			gameFacade.AddItem(NameAddTextFieldL.getText(), PriceAddTextFieldL.getText(), BasicAttributeAddTextFieldL.getText(), 
					SpecialAttributeAddChoiceBoxL.getSelectionModel().getSelectedItem(), ValueOfSAAddTextFieldL.getText());
			TreeAddL.setRoot(MakeTreeRootFromDataBase());
		}
		public void AddApplyR() {
			gameFacade.AddItem(NameAddTextFieldL.getText(), PriceAddTextFieldL.getText(), BasicAttributeAddTextFieldL.getText(), 
					SpecialAttributeAddChoiceBoxL.getSelectionModel().getSelectedItem(), ValueOfSAAddTextFieldL.getText());
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
				
		}
		public void HistorySpecifyR() {
			
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
			PlayerPanelL.setVisible(false);
			EQPanelL.setVisible(true);
		}
		public void ToEQR() {
			PlayerPanelR.setVisible(false);
			EQPanelR.setVisible(true);
		}
		
		public void ToShopL() {
			PlayerPanelL.setVisible(false);
			ShopPanelL.setVisible(true);
		}
		public void ToShopR() {
			PlayerPanelR.setVisible(false);
			ShopPanelR.setVisible(true);
		}
		
		public void ToBattlefield() {
			if (ReadyButtonL.isSelected() == true && ReadyButtonR.isSelected() == true) {
				PlayerPanelL.setVisible(false);
				PlayerPanelR.setVisible(false);
				BattlefieldPanelL.setVisible(true);
				BattlefieldPanelR.setVisible(true);
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
			
		}
		public void UseItemR() {
			
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
		
		public void RadioButtonsSelectBuyL() { // do uzupelnienia - wyswietlanie odpowiednie
			SellRadioButtonL.setSelected(false);
			SellRadioButtonL.setDisable(false);
			BuyRadioButtonL.setDisable(true);
		}
		public void RadioButtonsSelectSellL() {
			BuyRadioButtonL.setSelected(false);	
			BuyRadioButtonL.setDisable(false);
			SellRadioButtonL.setDisable(true);
		}
		public void RadioButtonsSelectBuyR() {
			SellRadioButtonR.setSelected(false);
			SellRadioButtonR.setDisable(false);
			BuyRadioButtonR.setDisable(true);
		}
		public void RadioButtonsSelectSellR() {
			BuyRadioButtonR.setSelected(false);
			BuyRadioButtonR.setDisable(false);
			SellRadioButtonR.setDisable(true);
		}
		
		public void BuyOrSellL() {
			
		}
		public void BuyOrSellR() {
			
		}
		//----------------------------------
		//Battlefield panel
		public void AttackL() {
			
		}
		public void AttackR() {
			
		}
		
		public void RestL() {
			
		}
		public void RestR() {
			
		}
		
		public void ToUseItemL() {
			BattlefieldPanelL.setVisible(false);
			PickItemPanelL.setVisible(true);
		}
		public void ToUseItemR() {
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
			
		}
		public void ConsumeItemR() {
			
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
            
            TreeItem<String> wandItems = new TreeItem<String> ("Wand Items");            
            attackItems.getChildren().add(wandItems);
            wandItems.setExpanded(true);
            
            TreeItem<String> bowItems = new TreeItem<String> ("Bow Items");            
            attackItems.getChildren().add(bowItems);
            bowItems.setExpanded(true);
            
            TreeItem<String> ammunitionItems = new TreeItem<String> ("Ammunition Items");            
            attackItems.getChildren().add(ammunitionItems);
            ammunitionItems.setExpanded(true);
            
            //000000000000000000000000000
            TreeItem<String> usableItems = new TreeItem<String> ("Usable Items");            
            rootItem.getChildren().add(usableItems);
            usableItems.setExpanded(true);
            
            TreeItem<String> healingPotionItems = new TreeItem<String> ("Healing Potion Items");            
            usableItems.getChildren().add(healingPotionItems);
            healingPotionItems.setExpanded(true);
            
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

		
		private static class HistoryRow { //struktura przechowywujaca potrzebna do tableView
			public String Player1_name, Player2_name, Who_win;
			HistoryRow(String a, String b, String c) {
				this.Player1_name = a;
				this.Player2_name = b;
				this.Who_win = c;
			}
		}
		
		private ObservableList<HistoryRow> ConvertHistoryToTable() {
			DataBase db = gameFacade.getDataBase();
			List<BattlefieldHistory> history = db.getBattleFieldHistoryRepository().GetAll();
			
			ObservableList<HistoryRow> data = FXCollections.observableArrayList();
			for (BattlefieldHistory h : history) {
				data.add(new HistoryRow(h.getPlayer1().getNickname(), h.getPlayer2().getNickname(), h.getWhoWonPlayerId().getNickname()));
			}
			return data;
		}


}


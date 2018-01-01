package GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

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
	
	//---------------------------------------
	//---------------------------------------
	//TreeViews
	@FXML
	private TreeView TreeModifyL;
	@FXML
	private TreeView TreeModifyR;
	@FXML
	private TreeView TreeAddL;
	@FXML
	private TreeView TreeAddR;
	@FXML
	private TreeView TreeRemoveL;
	@FXML
	private TreeView TreeRemoveR;
	
	//---------------------------------------
	//---------------------------------------
	//TableViews
	@FXML
	private TableView HistoryTableViewL;
	@FXML
	private TableView HistoryTableViewR;
	@FXML
	private TableView SpecifyHistoryTableViewL;
	@FXML
	private TableView SpecifyHistoryTableViewR;
	
	@FXML
	private TableView EQTableViewL;
	@FXML
	private TableView EQTableViewR;
	
	//---------------------------------------
	//---------------------------------------
	//ChoiceBoxes
	@FXML
	private ChoiceBox SpecialAttributeModifyChoiceBoxL;
	@FXML
	private ChoiceBox SpecialAttributeModifyChoiceBoxR;
	@FXML
	private ChoiceBox SpecialAttributeAddChoiceBoxL;
	@FXML
	private ChoiceBox SpecialAttributeAddChoiceBoxR;
	
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
		RegisterPanelL.setVisible(false);
		WelcomePanelL.setVisible(true);
	}
	public void RegisterBackToWelcomeR() {
		RegisterPanelR.setVisible(false);
		WelcomePanelR.setVisible(true);
	}

	public void RegisterL() {
		
	}
	public void RegisterR() {
		
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
	
	public void ModifyApplyL() {
		
	}
	public void ModifyApplyR() {
		
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
		
	}
	public void AddApplyR() {
		
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
		
	}
	public void RemoveApplyR() {
		
	}
	//----------------------------------
	//History panel
	public void HistoryBackToAdminL() {
		HistoryPanelL.setVisible(false);
		AdminPanelL.setVisible(true);
	}
	public void HistoryBackToAdminR() {
		HistoryPanelR.setVisible(false);
		AdminPanelR.setVisible(true);
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
}


package Test.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import DataAccessLayer.AccountRepository;
import DataAccessLayer.DataBase;
import GUI.GameFacade;
import GUI.Statement;
import Models.Admin;
import Models.AppUser;
import Models.Player;

import static org.mockito.Mockito.*;

public class GameFacadeVerifyAccountTest {
	@Test
	public void GameFacade_VerifyAccount_EmptyLoginTest() {
		InvalidCredidentialHelper("", "sadasd");
	}
	
	@Test
	public void GameFacade_VerifyAccount_EmptyPasswordTest() {
		InvalidCredidentialHelper("asdasd", "");
	}
	
	@Test
	public void GameFacade_VerifyAccount_GivenCredidential_UserDoestnExist()
	{
		GivenCredidentialHelper(GameFacade.ACCOUNT_DOESNT_EXIST, null);
	}
	
	@Test
	public void GameFacade_VerifyAccount_GivenCredidential_AdminDoesExist()
	{
		GivenCredidentialHelper("admin", new Admin());
	}
	
	@Test
	public void GameFacade_VerifyAccount_GivenCredidential_PlayerDoesExist()
	{
		GivenCredidentialHelper("player", new Player());
	}
	
	private static void GivenCredidentialHelper(String expectedInformation, AppUser userFromDb)
	{
		DataBase dbMock = mock(DataBase.class);
		AccountRepository accRepoMock = mock(AccountRepository.class);

		when(accRepoMock.GetByLoginPassword(anyString(), anyString())).thenReturn(userFromDb);
		when(dbMock.getAccountRepository()).thenReturn(accRepoMock);
		
		GameFacade facade = new GameFacade(dbMock);
		Statement r = facade.VerifyAccount("notempty", "notempty");
		
		assertTrue(r.getInformation() == expectedInformation);
	}
	
	private static void InvalidCredidentialHelper(String login, String password)
	{
		DataBase dbMock = mock(DataBase.class);
		GameFacade facade = new GameFacade(dbMock);
		
		Statement r = facade.VerifyAccount(login, password);
		
		assertTrue(r.getInformation() == GameFacade.ACCOUNT_DOESNT_EXIST);
	}
}

package Module1_Login_Test;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LiberyFiles.BaseClass;
import LiberyFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabMenuPage;


public class SwagLabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TcId;
	

	@BeforeClass
	public void OpenBrowser() throws IOException 
	{
		intializeBrowser();
		
		login=new SwagLabLoginPage(driver);
		home=new SwagLabHomePage(driver);
		menu=new SwagLabMenuPage(driver);	
	}
	
	@BeforeMethod
	public void LoginToApp() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		login.InpSwagLabLoginPageUN(UtilityClass.TestData(1, 0));
		Thread.sleep(2000);
		login.InpSwagLabLoginPagePw(UtilityClass.TestData(1, 1));
		Thread.sleep(2000);
		login.ClickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
		
	}
	@Test
	
	public void TC1() throws EncryptedDocumentException, IOException 
	{
		String actTitle = home.VerifyTitle();
		String expTitle=UtilityClass.TestData(1, 2);   // getting wrong title to fail TC and get Failed TC Screenshot ..correct title pn (1,2)
        assertEquals(actTitle, expTitle); 
	}
	
	@AfterMethod
	public void LogOutApp(ITestResult s1) throws InterruptedException, IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.CaptureSS(driver, 101);
			
		}
		
		home.ClickSwagLabMenuBtn();
		Thread.sleep(2000);
		menu.ClickSwagLabMenuPageLogOutBtn();
		Thread.sleep(2000);
	}
	
	public void CloseBrowser() 
	{
		driver.close();
	}

}

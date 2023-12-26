package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwagLabLoginPage 
{
	@FindBy(xpath = "//input[@id='user-name']") private WebElement Username;
	@FindBy(xpath = "//input[@id='password']") private WebElement Password;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement LoginBtn;
	
	
	public SwagLabLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void InpSwagLabLoginPageUN(String username) 
	{
	   Username.sendKeys(username);	
	}
	
	public void InpSwagLabLoginPagePw(String password) 
	{
	  Password.sendKeys(password);	
	}
	
	public void ClickSwagLabLoginPageLoginBtn() 
	{
		LoginBtn.click();	
	}
	
	
	
	
	
	
}

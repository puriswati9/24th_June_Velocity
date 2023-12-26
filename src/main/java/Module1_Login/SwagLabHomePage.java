package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//button[text()='Open Menu']")  private WebElement MenuBtn;
	
	public SwagLabHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyTitle () 
	{
		String actTitle = driver.getTitle();
		
		return actTitle;
	}
	
	public void ClickSwagLabMenuBtn() 
	{
		MenuBtn.click();
	}

}

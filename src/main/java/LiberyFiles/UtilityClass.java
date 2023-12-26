package LiberyFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String  TestData(int rowIndex,int CellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\OneDrive\\velocity\\Automation\\selenium\\TestData Framework\\Testdata.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF1");
		
		String value = sh.getRow(rowIndex).getCell(CellIndex).getStringCellValue();
		
		 return value;
	}
	
	public static void CaptureSS(WebDriver driver , int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Admin\\eclipse-workspace\\24 June_Velocity_Selenium\\Screenshot\\TCID"+TCID+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	public static String GetTD_Using_PropertiesFile(String key) throws IOException 
	{
		//FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\24 June_Velocity_Selenium\\src\\POM_DDF__TestNG_BaseClass_UtlilityClass_FailedTCSS_PropertyFile\\TestData.properties");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
			
	}
	

}

package vTiger.Organizations.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationWithChemical {
@Test(groups = "SmokeSuite")
	public void createOrganizationwithChemicalTest() throws IOException {
	
//step 1:create all the object
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
//step 2:Read all the req data
		//read data from propertyFile
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");
		
//read data from excel sheet
		String ORGNAME = eutil.readDDataFromExcel("Organization", 13, 2)+jutil.getRandomNumber();
		String INDUSTRYTYPE = eutil.readDDataFromExcel("Organization", 13, 3);
		
		//step 3:launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser name");
		}
	wutil.minimizeWindow(driver);	
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	//step 4:login to the application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//step 5:inspect on organization name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	//step 6:
	WebElement ele = driver.findElement(By.name("industry"));
	wutil.handledropDown(ele, INDUSTRYTYPE);
	//step 7:save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String INDUSTRYNAME = driver.findElement(By.id("dtlview_Industry")).getText();
	if(INDUSTRYNAME.equals(INDUSTRYTYPE)) {
		System.out.println(INDUSTRYNAME+"pass");
	}
	else
	{
		System.out.println(INDUSTRYNAME+"fail");
	}
	//step 8:logout inspect
	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wutil.handlemouseHover(driver,logout);
//step 9:click on signout
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}

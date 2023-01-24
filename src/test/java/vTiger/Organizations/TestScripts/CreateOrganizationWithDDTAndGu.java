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

public class CreateOrganizationWithDDTAndGu {
	@Test

	public  void createOrganizationwithDDTandGUTest() throws IOException {
   //step 1:create object for all the utility files
		JavaUtility jutil=new JavaUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		
		//step 2:read all the req data
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");
		
		String ORGNAME = eutil.readDDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
		
		//step 3:launch the browser:
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
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
		
		//step 4:login to application
		//inspect on username
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//inspect on password
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//inspect on login
		driver.findElement(By.id("submitButton")).click();
		//inspect on organizations
		driver.findElement(By.linkText("Organizations")).click();
		//inspect on lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//inspect on organization name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//inspect on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//inspect orgHeader
		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println(ORGHEADER+"pass");
		}
		else
		{
			System.out.println(ORGHEADER+"fail");
		}
		//step 9:log out of application
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));		
		wutil.handlemouseHover(driver, ele);
		//inspect on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}}

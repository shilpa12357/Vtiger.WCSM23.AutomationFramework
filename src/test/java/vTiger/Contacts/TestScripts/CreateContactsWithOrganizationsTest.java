package vTiger.Contacts.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactsWithOrganizationsTest {
     @Test
	public void createContactwithorg() throws IOException {
		//step 1:create method
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility() ;
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility()  ;
		
		//step 2:read all the data req
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String Password = putil.readDataFRromPropertyFile("password");
		
		//data from excelsheet
		String LASTNAME = eutil.readDDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eutil.readDDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
		
		//Step 3:launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		wutil.minimizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		//step 4:login to the application
		//inspect on username
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//inspect on password
		driver.findElement(By.name("user_password")).sendKeys(Password);
		//inspect on login
		driver.findElement(By.id("submitButton")).click();
		
		//step 5:navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 6:click on organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 7:create new organization and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8:validate
		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		//steps 9 create contact
		driver.findElement(By.linkText("Contacts")).click();
		//step 10:click on lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//step 11:create new contact wid mandatory info
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//step 12:choose the organization
		//inspect the look up image of organization present in contact
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wutil.switchToWindow(driver, "Accounts");
		//inspect the search operation
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		//INSPECT ON SEARCH btn
		driver.findElement(By.name("search")).click();
		//choose the organization name and perform click option
		driver.findElement(By.xpath("//a[text()= '"+ORGNAME+"']")).click();
		                           //dynamic xpath
		//switch back 
		wutil.switchToWindow(driver, "Contacts");
		//step 13:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 14:validate
		
		String ORGHEADER1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

Assert.assertTrue(ORGHEADER1.contains(LASTNAME));
		
		
		
	}

}

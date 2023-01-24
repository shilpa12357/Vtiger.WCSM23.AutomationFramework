package vTiger.Organizations.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationWithIndustry {
	@Test

	public  void createOrganizationwithIndustryTest() throws IOException {
//step 1:create all the objects
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//step 2:Read all the required data
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");
		
		//read data from excel sheet
		String ORGNAME = eutil.readDDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.readDDataFromExcel("Organization", 4, 3);
		
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
				wutil.maximizeQWindow(driver);
				wutil.waitForPageLoad(driver);
				driver.get(URL);
				
		//step 4:login to the application
				//inspect the username
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//inspect the apssword
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//inspect the loginbtn
				driver.findElement(By.id("submitButton")).click();
				//inspect on organization
				driver.findElement(By.linkText("Organizations")).click();
				//inspect on lookup image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				//inspect on organization name
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				//inspect on industry
				WebElement ele = driver.findElement(By.name("industry"));
				wutil.handledropDown(ele, INDUSTRY);
				//step 5:click on save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//step 6:validate
				//inspect on healthcare
				  String INDUSTRYNAME = driver.findElement(By.id("dtlview_Industry")).getText();
				  if(INDUSTRYNAME.equals(INDUSTRY))
				  {
					  System.out.println(INDUSTRYNAME+"pass");
				  }
				  else
				  {
					  System.out.println(INDUSTRYNAME+"fail");
				  }
	}
}

				
				 
				


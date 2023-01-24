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

public class CreateOrganizationWithIndustryAndType {
	@Test

	public  void createOrganizationwithIndustryTypeTest() throws IOException {
//step 1:Create Object
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
//step 2:read all the data req for scripting
	//read data from propertyfile
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");

//read data from excel sheet
		String ORGNAME = eutil.readDDataFromExcel("Organization", 16, 2)+jutil.getRandomNumber();
		String INDUSTRYTYPE = eutil.readDDataFromExcel("Organization", 16, 3);
		String TYPE = eutil.readDDataFromExcel("Organization", 16, 4);
		
	//step 3:launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid ");
		}
		wutil.minimizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
//login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step 4:click on organization link and look up image
		driver.findElement(By.linkText("Organizations")).click();
		//click on ,ook up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//inspect on organization name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//inspect on industry dropdown
		WebElement ele = driver.findElement(By.name("industry"));
		wutil.handledropDown(ele, INDUSTRYTYPE);
		//inspect on type dropdown
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		wutil.handledropDown(ele1, TYPE);
//inspect on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//validate the industrytype
		String INDUSTRYHEADER = driver.findElement(By.id("dtlview_Industry")).getText();
		if(INDUSTRYHEADER.equals(INDUSTRYTYPE))
		{
			System.out.println(INDUSTRYHEADER +"pass");
			
		}
		else
		{
			System.out.println(INDUSTRYHEADER+" fail");
		}
		//validate on tyope
		 String TYPEHEADER = driver.findElement(By.id("dtlview_Type")).getText();
		 if(TYPEHEADER.equals(TYPE))
		 {
			 System.out.println(TYPEHEADER+" pass");
		 }
		 else
		 {
			 System.out.println(TYPEHEADER +" fail");
		 }
		
		
	}

}

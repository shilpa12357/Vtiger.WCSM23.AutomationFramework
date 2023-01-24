package vTiger.GenericUtilities;
/**
 * this class contains all the basic annotation
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public WebDriver driver=null;
	public  static WebDriver sdriver;//tgis is used for taking screenshot
	
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsconfig() {
		System.out.println("======Database connection successful");
	}
	//@Parameters("browser")
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcconfig() throws IOException
	 {
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver=driver;
			System.out.println("========"+BROWSER+"chrome");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver=driver;
			System.out.println("========"+BROWSER+"firefox");

		}
		else {
			System.out.println("invalid browser name");
			
		}
		wutil.minimizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmconfig() throws IOException {
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("login successful");
		
	}
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amconfig() {
		HomePage hp=new HomePage(driver);
		hp.logoutApp(driver);
		System.out.println("logout successful");
		
	}
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acconfig() {
		driver.quit();
		System.out.println("========browser closedsd");
	}
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asconfig() {
		
		System.out.println("======Database connection closed");

	}
}

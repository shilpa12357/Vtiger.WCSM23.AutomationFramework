package vTiger.Organizations.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;



public class CreateMultipleOrganizationWithDataProvider {
	
	//step 1:create all objct for utility file
	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaUtility jutil=new JavaUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
@Test(dataProvider="orgname")
public void createOrgTest(String ORGNAME,String INDUSTRYTYPE) throws IOException {
	//read all the data from req dataproperty and execlsheet
	//read data from propertyfile
	String BROWSER = putil.readDataFRromPropertyFile("browser");
	String URL = putil.readDataFRromPropertyFile("url");
	String USERNAME = putil.readDataFRromPropertyFile("username");
	String PASSWORD = putil.readDataFRromPropertyFile("password");
	//read data from excel sheet
	  ORGNAME = ORGNAME+jutil.getRandomNumber();
	
	//launch the browser
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	wutil.minimizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	//login to the app
	LoginPage lp=new LoginPage(driver);
	lp.LoginToApp(USERNAME, PASSWORD);
	//go to homepage and click on organization
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	//click on look up image on Organizations page
	OrganizationsPage op=new OrganizationsPage(driver);
	op.lookupImg();
	//go to create new OrganizationsPage and fill on the mandatory details
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganizatio(ORGNAME, INDUSTRYTYPE);
	//validate
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String ORGHEADER = oip.getOrgHeader();
	if(ORGHEADER.contains(ORGNAME))
	{
		System.out.println(ORGHEADER+"pass");
	}
	else
	{
		System.out.println(ORGHEADER+"fail");
	}
	hp.logoutApp(driver);
	
}
@DataProvider(name="orgname")
public  Object[][] getData() throws EncryptedDocumentException, IOException{
	Object[][] data = eutil.readMultipleData("MultipleOrg");
	return data;
	
}
}

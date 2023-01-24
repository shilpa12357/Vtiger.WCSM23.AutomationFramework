package vTiger.Contacts.TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactswithPomPagesTest {
@Test
	public void createContactswidOrganizationTest() throws IOException {
//step 1:create all object of utility
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
	
		//step 2:read all the req data
		//read all the data from property file
		String BROWSER = putil.readDataFRromPropertyFile("browser");
		String URL = putil.readDataFRromPropertyFile("url");
		String USERNAME = putil.readDataFRromPropertyFile("username");
		String PASSWORD = putil.readDataFRromPropertyFile("password");
		
//read all the data from excelsheet
		String LASTNAME = eutil.readDDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eutil.readDDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
		String LEADSOURCE = eutil.readDDataFromExcel("Contacts", 7, 4);
		
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
		else
		{
			System.out.println("invalid browesr");
		}
		wutil.minimizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		//step 4:login to the application
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		//step 5:come to homepage and click on organization link
		HomePage hp=new HomePage(driver);
		
		hp.clickOnOrganizationLink();
		Reporter.log("organization clicked");
		
		//step 6:come to organizations page and click on organizationlookupimage
		OrganizationsPage op=new OrganizationsPage(driver);
		op.lookupImg();
		Reporter.log("click on org look up image");
		
		
		//step 7:come to create new organizationsPage
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createNewOrganizatio(ORGNAME);
		Reporter.log("new organization page");
		
		//step 8:validation of organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
     String ORGHEADER = oip.getOrgHeader();	
     Assert.assertTrue(ORGHEADER.contains(ORGNAME));
     //step 9:go to homepage click on contacts

     hp.clickOnContactLink();
     
     //step 10:come to contacts page and click on contacts look up image
     ContactsPage cp=new ContactsPage(driver);
     cp.clickonContactimg();
     String acttitle=driver.getTitle();
     System.out.println(acttitle);
     String exptitle= "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
     Assert.assertEquals(acttitle, exptitle);
     
		//step 7:come to create newcontact  page and fill the mandatoryfield
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
cncp.createnewcontact(LASTNAME, driver, ORGNAME, LEADSOURCE);
		
		//step 8:validation
		//come to contactinfopage and validate the header
		ContactInfoPage cip=new ContactInfoPage(driver) ;
		String CONTACTHEADER = cip.contactheader();
		Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
				
		hp.logoutApp(driver);
	}

}

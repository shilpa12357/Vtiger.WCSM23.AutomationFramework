

	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import vTiger.GenericUtilities.BaseClass;
	import vTiger.GenericUtilities.ExcelFileUtility;
	import vTiger.GenericUtilities.JavaUtility;
	import vTiger.GenericUtilities.PropertyFileUtility;
	import vTiger.GenericUtilities.WebDriverUtility;
	import vTiger.ObjectRepository.CreateNewOrganizationPage;
	import vTiger.ObjectRepository.HomePage;
	import vTiger.ObjectRepository.LoginPage;
	import vTiger.ObjectRepository.OrganizationInfoPage;
	import vTiger.ObjectRepository.OrganizationsPage;

	@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)

	public class Demojava extends BaseClass
	  {

	@Test(groups = "RegressionSuite")
	public void CreateNewOrgwithIndustryTest() throws EncryptedDocumentException, IOException {
		//b.read data from excel sheet
			String ORGNAME = eutil.readDDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
			String INDUSTRYNAME = eutil.readDDataFromExcel("Organization", 4, 3);
		//step 3:launch the browser

			
			//step 5:homePage
	       HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();       
	//step 6:Organizationspage
	       OrganizationsPage op=new OrganizationsPage(driver);  
	       op.lookupImg();
	       
	       //step 7:CreateNewOrganization page
	       CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
	       cnp.createNewOrganizatio(ORGNAME, INDUSTRYNAME);
	//step 8:validation
	       OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	      String ORGHEADER = oip.getOrgHeader();
	    Assert.assertTrue(ORGHEADER.contains(ORGNAME));//true
	    
	    
	}
	}





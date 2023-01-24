package vTiger.Organizations.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganization2Page;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage2;
import vTiger.ObjectRepository.Organization2Page;
import vTiger.ObjectRepository.OrganizationInformationPage2;

public class CreateOrgWithMember extends BaseClass {
	@Test
	public void createOrgWIthMembderTest() throws EncryptedDocumentException, IOException
	{
		//read data from excel sheet
		String ORGNAME = eutil.readDDataFromExcel("Organization", 19, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.readDDataFromExcel("Organization", 19, 3);
		
		HomePage2 hp2=new HomePage2(driver);
		hp2.clickonOrganization();
		
		Organization2Page opg=new Organization2Page(driver);
		opg.clickonOrglookupimg();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganizatio(ORGNAME);
		
		
		
		CreateNewOrganization2Page cno2=new CreateNewOrganization2Page(driver);
		cno2.createNewOrganization(ORGNAME, driver, INDUSTRY);
    //valid
    OrganizationInformationPage2 oip2=new OrganizationInformationPage2(driver) ;
    String ORGHEADER = oip2.organizationheader();
    Assert.assertTrue(ORGHEADER.contains(ORGNAME));
    hp2.clickonLogout(driver);
    
    
	}

}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
//Innitialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization

	private WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}


	private WebElement getIndustryDropdown() {
		return industryDropdown;
	}


	private WebElement getSaveBtn() {
		return saveBtn;
	}
//business libraries
	/**
	 * this method will create new organization and save
	 * @param ORGNAME
	 */
	public void createNewOrganizatio(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
		
	}
	/**
	 * this method will create new Organization with industry and save
	 * @param ORGNAME 
	 * @param INDUSTRYNAME 
	 */
	public void createNewOrganizatio(String ORGNAME, String INDUSTRYNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
      handledropDown(industryDropdown,INDUSTRYNAME );
      saveBtn.click();
		
		
	}
	

}

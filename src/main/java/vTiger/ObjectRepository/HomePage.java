package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
//declaration
	//inspect on organization
	@FindBy(linkText="Organizations")
	private WebElement ORganizationLnk;
	
//inspect on contactLink
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
//inspect on oppartunity
	@FindBy(linkText="Opportunities")
	private WebElement OppartunitiesLnk;
	
//inspect on Administrator
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
//inspect on signout
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
//initialization
public HomePage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}
//utilization

public WebElement getORganizationLink() {
	return ORganizationLnk;
}

public WebElement getContactsLink() {
	return ContactsLnk;
}

public WebElement getOppartunitiesLink() {
	return OppartunitiesLnk;
}

public WebElement getAministratorlink() {
	return AdministratorImg;
}

public WebElement getSigoutLink() {
	return signoutLnk;
}
//businessLibraries
//this method will click on organization link
public void clickOnOrganizationLink() {
	ORganizationLnk.click();
	
}
//this method will click on contactslink
public void clickOnContactLink() {
	ContactsLnk.click();
	
}
//this methid will click on oppartunities link
public void clickOnOppartunitiesLink() {
	OppartunitiesLnk.click();
	
}
//this method will logout of application
public void logoutApp(WebDriver driver) {
	handlemouseHover(driver, AdministratorImg);
	signoutLnk.click();
	
}

	



}




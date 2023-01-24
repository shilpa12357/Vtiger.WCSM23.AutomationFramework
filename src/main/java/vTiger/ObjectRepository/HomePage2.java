package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage2 extends WebDriverUtility {
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement conlink;
	
	@FindBy(linkText="Leads")
	private WebElement leadlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	
	public HomePage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//getters method

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getConlink() {
		return conlink;
	}

	public WebElement getLeadlink() {
		return leadlink;
	}
	private WebElement getLogoutbtn() {
		return administratorimg;
	}

	private WebElement getSignoutbtn() {
		return signoutbtn;
	}

	//business libraies
	public void clickonOrganization() {
		orglink.click();
		
	}
	public void clickoncontacts() {
		conlink.click();
		
	}
	public void clickonleads() {
		leadlink.click();
		
	}
	public void clickonLogout(WebDriver driver) {
		handlemouseHover(driver, administratorimg);
		signoutbtn.click();
		
		
	}
	
	

}

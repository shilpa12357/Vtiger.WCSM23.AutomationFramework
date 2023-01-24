package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrglookupimg;
	
	
//innitialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization


	public WebElement getLookupimg() {
		return CreateOrglookupimg;
	}
	
//business libraries
	/**
	 * this method will click on create oganization look up image
	 */
	public void lookupImg() {
		CreateOrglookupimg.click();
	}
	

}

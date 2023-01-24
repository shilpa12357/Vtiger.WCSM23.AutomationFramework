package vTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement OrgHeaderText;
	
//Initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
 //business libraries
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	public String getOrgHeader() {
		return OrgHeaderText.getText();
		
	}
	
}

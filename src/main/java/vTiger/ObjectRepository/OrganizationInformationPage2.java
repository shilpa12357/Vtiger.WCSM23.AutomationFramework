package vTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage2 {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Orghd;
	
	public OrganizationInformationPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//getters method
	private WebElement getOrghd() {
		return Orghd;
	}
	
//business libraries
	public String organizationheader() {
		return Orghd.getText();
		
	}

}

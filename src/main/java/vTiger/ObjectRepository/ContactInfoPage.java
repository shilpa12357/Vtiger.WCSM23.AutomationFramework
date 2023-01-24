package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contacthdr;
	
	//innitialization
	public ContactInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	private WebElement getContacthdr() {
		return contacthdr;
	}
//business libraries
	public String contactheader() {
		return contacthdr.getText();
	}
}

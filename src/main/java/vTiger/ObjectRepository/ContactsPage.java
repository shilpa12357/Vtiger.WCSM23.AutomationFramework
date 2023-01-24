package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement Contactslookupimglnk;
	
	
	//innitialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	
	public WebElement getContactslnk() {
		return Contactslookupimglnk;
	}
		
//business libraries
	/**
	 * this method will click on create contact look up image
	 */
		public void clickonContactimg() {
			Contactslookupimglnk.click();
			
	
		}
	
	
	
	
	







	
	}



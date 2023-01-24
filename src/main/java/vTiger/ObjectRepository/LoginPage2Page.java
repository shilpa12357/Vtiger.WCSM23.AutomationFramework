package vTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class LoginPage2Page extends WebDriverUtility {
	@FindBy(name="user_name")
	private WebElement usernametb;
	
	@FindBy(name="user_password")
	private WebElement passwordtb;
	
	@FindBy(id="submitButton")
	private WebElement logintb;
	
	public LoginPage2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//getters method

	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getLogintb() {
		return logintb;
	}
	//business libraries
	public void Login(String user, String pwd) {
		usernametb.sendKeys(user);
		passwordtb.sendKeys(pwd);
		logintb.click();
		
		
	}


}

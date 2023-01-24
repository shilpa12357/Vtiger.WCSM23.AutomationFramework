package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage   {//rule  1:create a pom class for every web page
	//rule 2:class name should be the title of the page and ending with word page
	//rule 3:identify the webElement using findBy,findAll,findBys annotation
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginEdt;
	
	
	//rule 4:create a constructor to innitialize the variable/webElements
	public LoginPage(WebDriver driver)
	{
PageFactory.initElements(driver, this);	
}
	//rule 5:provide getters to access the webElements


	
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}
	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}
	public WebElement getLoginEdt() {
		return LoginEdt;
	}



	
	//rule 6:business libraries
	public void LoginToApp(String USERNAME, String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		LoginEdt.click();
		
		
	}
	

	
	
	

}

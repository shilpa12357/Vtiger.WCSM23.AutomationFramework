package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization2Page {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orglookupimg;
	
	public Organization2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//getters method

	public WebElement getOrglookupimg() {
		return orglookupimg;
	}
	
	//business libraries
	public void clickonOrglookupimg() {
		orglookupimg.click();
	}

}

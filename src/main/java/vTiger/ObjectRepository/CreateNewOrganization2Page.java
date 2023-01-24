package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganization2Page extends WebDriverUtility {
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement membertb;
	
	@FindBy(name="industry")
	private WebElement industrytb;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="search_text")
	private WebElement searchtb;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	public CreateNewOrganization2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//getters method
	private WebElement getOrgname() {
		return orgname;
	}

	private WebElement getMembertb() {
		return membertb;
	}
	

	private WebElement getSearchtb() {
		return searchtb;
	}
	private WebElement getSearchbtn() {
		return searchbtn;
	}
	private WebElement getIndustrytb() {
		return industrytb;
	}
	private WebElement getSavebtn() {
		return savebtn;
	}
	

	
//business libraries
 public void createNewOrganization(String ORGNAME, WebDriver driver, String INDUSTRY) {
	 orgname.sendKeys(ORGNAME);
	 membertb.click();
	 switchToWindow(driver, "Accounts");

	 searchtb.sendKeys(ORGNAME);
	 searchbtn.click();
	 driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();

	 switchToWindow(driver, "Accounts&action");
	 handledropDown(industrytb, INDUSTRY);
	 
	 
	 
	 
	 
 }
}

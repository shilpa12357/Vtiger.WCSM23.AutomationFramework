package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {
//declaration
	@FindBy(name="lastname")
	private WebElement lastnametb;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::  img[@alt='Select']")
	private WebElement Organizationimg;
	
	@FindBy(name="search_text")
	private WebElement searchedt;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(name="leadsource")
	private WebElement leadtb;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	//innitialization
	public CreateNewContactsPage(WebDriver  driver) {
		PageFactory.initElements(driver, this);
	}
	//utilizations
	private WebElement getLastnametb() {
		return lastnametb;
	}
	private WebElement getOrganizationimg() {
		return Organizationimg;
	}
	private WebElement getSearchedt() {
		return searchedt;
	}
	private WebElement getSearchbtn() {
		return searchbtn;
	}
	private WebElement getLeadtb() {
		return leadtb;
		
		
	}
	private WebElement getSavebtn() {
		return savebtn;
	}
	//utilization
	//business library
	/**
	 * this method describes create contact with leadsource and organization name and save it
	 * @param LAstNAME
	 * @param driver
	 * @param ORGNAME
	 * @param LEADSOURCE
	 * @param INDUSTRY 
	 */
	public void createnewcontact(String LAstNAME, WebDriver driver,String ORGNAME,  String INDUSTRY) {
		lastnametb.sendKeys(LAstNAME);
		Organizationimg.click();
		switchToWindow(driver, "Accounts");
		searchedt.sendKeys(ORGNAME);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
      handledropDown(leadtb, INDUSTRY);
      savebtn.click();
		
	}
	/**
	 * this method describe create contact with last name 
	 * @param LASTNAME
	 */
	public void createnewcontact(String LASTNAME ) {
		lastnametb.sendKeys(LASTNAME);
		savebtn.click();
		
	}
	
}

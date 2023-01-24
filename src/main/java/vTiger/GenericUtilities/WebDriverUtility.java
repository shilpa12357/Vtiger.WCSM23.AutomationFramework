package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this method consist of generic methodsrelated to webdriver actions
 * @author maver
 *
 */

public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeQWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window 
	 * @param driver
	 */
  public void minimizeWindow(WebDriver driver) {
	  driver.manage().window().minimize();
	  
  }
  /**
   * this method will waitfor 20 sec all the elements to get loaded
   * @param driver
   */
  public void waitForPageLoad(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
  }
  /**this method will wait until particular element becomes visible
   * 
   * @param driver
   */
  public void waitForElementTobeVisisble(WebDriver driver,WebElement element) {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOf(element));
	  
  }
  /**
   * this method will wait until a particular element becomes clickable
   * @param driver
   * @param element
   */
  public void waitForElementTobeClickable(WebDriver driver,WebElement element) {
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20)) ;
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  /**
   * this method will handle the dropdown using the index
   * @param element
   * @param index
   */
  public void handledropDown(WebElement element, int index) {
	  Select s=new Select(element);
	  s.selectByIndex(index);
	  
  }
  /**
   * this method will handle the dropdown using value
   * @param element
   * @param text
   */
  public void handledropDown(WebElement element,String value ) {
	  Select s=new Select(element);
	  s.selectByValue(value);
  }
  /**
   * this method willhandle the dropdown using text
   * @param text
   * @param element
   */
  public void handledropDown(String text,WebElement element) {
	  Select s=new Select(element);
	  s.selectByVisibleText(text);
  }
  /**
   * this method will handle the mousehover
   * @param driver
   * @param element
   */
  public void handlemouseHover(WebDriver driver, WebElement element) {
	  Actions a=new Actions(driver);
			  a.moveToElement(element).perform();
	  
  }
  /**
   * this method will perform doubleclick anywhere on the page
   * @param driver
   */
  public void doubleClick(WebDriver driver) {
	  Actions a=new Actions(driver);
	  a.doubleClick().perform();
  }
  
  

  
  /**
   * this method is ued to perform doubleclick on a particular element
   * @param driver
   * @param element
   */
  public void doubbleClick(WebDriver driver, WebElement element) {
	  Actions a =new Actions(driver);
	  a.doubleClick(element).perform();
  }
  
  /**
   * this method will perform rightclick actions on a particular element
   * @param driver
   * @param element
   */
  
  public void handlerighetClick(WebDriver driver, WebElement element) {
	  Actions a=new Actions(driver);
	  a.contextClick(element).perform();
  }
  /**
   * this method will perform rightclick anywhere on the page
   * @param driver
   */
  public void handlerightClick(WebDriver driver) {
	  Actions a=new Actions(driver);
	  a.contextClick().perform();
  }
  /**
   * this method is used to perform draganddrop
   * @param driver
   * @param src
   * @param dest
   */
  public void dragandDrop(WebDriver driver, WebElement src, WebElement dest) {
	  Actions a=new Actions(driver);
	  a.dragAndDrop(src, dest);
  }
  /**
   * this method will switch to frames based on index
   * @param driver
   * @param frameIndex
   */
  public void switchToFrames(WebDriver driver, int frameIndex ) {
	  driver.switchTo().frame(frameIndex);
	  
  }
  /**
   * this method will switch to frame based on the frame name or frameId
   * @param driver
   * @param frameOrId
   */
  public void switchToFrames(WebDriver driver, String frameNameOrId) {
	  driver.switchTo().frame(frameNameOrId);
	  
  }
  /**
   * this method will perform the action based on webelement
   * @param driver
   * @param frameElement
   */
  public void switchToFrames(WebDriver driver, WebElement frameElement) {
	  driver.switchTo().frame(frameElement);
  }
  /**
   * this method will switch back to immediate parent
   * @param driver
   */
  public void switchToparentFrame(WebDriver driver) {
	  driver.switchTo().parentFrame();
	  
  }
  /**
   * this method will switch back to the very first frame
   * @param driver
   */
  public void switchTodefaultContent(WebDriver driver) {
	  driver.switchTo().defaultContent();
	  
  }
  /**
   * this method will accept the alert popup
   * @param driver
   */
  public void acceptAlert(WebDriver driver) {
	  driver.switchTo().alert().accept();
	  
  }
  /**
   * this method will dismiss the alertpopup
   * @param driver
   */
  public void dismissAlertpopup(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
  }
  /**
   * this method will get the text of alert popupand return it to the caller
   * @param driver
   * @return
   */
  public String getAlertText(WebDriver driver) {
	 return  driver.switchTo().alert().getText();
	  
  }
  /**
   * this method will switch to the window based on the partial window title
   * @param driver
   * @param partialwinTitle
   */
  public void switchToWindow(WebDriver driver, String partialwinTitle) {
	  //step 1:capture all the windowId
	  Set<String> winIds = driver.getWindowHandles();
	  
	  //step 2:extract all the individual winId
		  for(String winId:winIds)
			  
		  {//step 3:capture the current windowTitle
			  String currentTitle = driver.switchTo().window(winId).getTitle();
			  
			  //step 4:compare the current window title with the req title
			  if(currentTitle.contains(partialwinTitle)) {
				  break;
			  }
	  }
	  
  }
  public String takeScreenshot(WebDriver driver, String ScreenshotsName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".\\Screenshots\\"+ScreenshotsName+".png");
	FileUtils.copyFile(src, dest);
	return dest.getAbsolutePath();//for extent reports
	  
  }
  /**
   * this method will scroll downwards randomly
   * @param driver
   */
  public void scrollActions(WebDriver driver) {
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)", "");
	  
  }
  /**
   * this method will scroll downwards until the specific element
   * @param driver
   * @param element
   */
  public void scrollOption(WebDriver driver,WebElement element) {
	  	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  	int y = element.getLocation().getY();
	  	js.executeScript("windows.scrollBy(0,"+y+")", element);
	  	  

  }
  
}

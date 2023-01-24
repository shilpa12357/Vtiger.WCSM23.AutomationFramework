package vTiger.Organizations.TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganizationwithDDt {
	@Test

	public  void createOrganizationwithDDTTest() throws EncryptedDocumentException, IOException {
		Random ran=new Random();
		int random = ran.nextInt(1000);
 //step 1: read all the data
		/*read data from property file*/
		FileInputStream fisp =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
       String BROWSER = p.getProperty("browser");
       String URL = p.getProperty("url");
      String USERNAME = p.getProperty("username");
     String PWD = p.getProperty("password");
     
     /*read data from excel sheet*/
     FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
     Workbook wb = WorkbookFactory.create(fise);
    String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+random;
     
       WebDriver driver=null;
		//step 2:launch the browser
    if(BROWSER.equalsIgnoreCase("chrome"))
    {
    	 driver = new ChromeDriver();
    }
    else if(BROWSER.equalsIgnoreCase("firefox"))
    {
    	driver=new FirefoxDriver();
    }
    else
    {
    	System.out.println("invalid browser name");
    }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//step 3:login to the application

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PWD);
         driver.findElement(By.id("submitButton")).click();
         
		//step 4:click on organization link
         driver.findElement(By.linkText("Organizations")).click();
		
		//step 5:click on create organization look up image
         
         driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 6:create organization with mandatory details
         driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step 7:save
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8:validate
          String HEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
          if(HEADER.contains(ORGNAME))
          {
        	  System.out.println(HEADER+"pass");
          }
          else
          {
        	  System.out.println("fail");
          }
          
         		
		//step 9:logout of app
         WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Actions a=new Actions(driver);
         a.moveToElement(logout).perform();
         driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}

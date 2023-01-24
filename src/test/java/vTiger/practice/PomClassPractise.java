package vTiger.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.ObjectRepository.LoginPage;

public class PomClassPractise {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil=new PropertyFileUtility();
   WebDriver driver=new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get("http://localhost:8888/");
   LoginPage lp=new LoginPage(driver);
   
lp.LoginToApp("admin", "admin")  ; 
   
  
   

	}

}

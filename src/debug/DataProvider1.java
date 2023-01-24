package debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@DataProvider(name="login")
	public Object getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="admin";
		obj[0][1]="manager";
		
		obj[1][0]="xyz";
		obj[1][1]="123456";
		
		obj[2][0]="#$32shi*";
		obj[2][1]="sh&$$2@p#";
		
		return obj;
	}
	@Test(dataProvider="login")
	public void tc1(String username, String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
	}

}

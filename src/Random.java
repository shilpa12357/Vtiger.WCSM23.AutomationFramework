import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Random {
	@DataProvider(name="logindata")
	public Object[][] getData() {
		Object[][] obj=new Object[2][3];
		obj[0][0]="admin";
		obj[1][0]="manager";
		
		obj[0][1]="xyz";
		obj[1][1]="123456";
		
		obj[0][2]="#$32shi*";
		obj[1][2]="sh&$$2@p#";
		
		return obj;
	}
		
	
	@Test(dataProvider="logindata")
	public void datatest(String username,String password) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
	}
		

}

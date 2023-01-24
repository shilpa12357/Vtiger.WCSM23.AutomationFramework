import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
@DataProvider(name="logindata")
public Object[] []getData() {
	Object[][]obj= {{"shilpa.mohanty@gmail.com","shilpamohanty"},
			{"xyz@gmail.com","xyz"},{"mno@gmail.com","ghui"}};
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

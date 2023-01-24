package debug;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDebug {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement ele=driver.findElement(By.id("email"));
		ele.sendKeys("shilpa.mohantysonu@gmail.com");
		WebElement pass=driver.findElement(By.id("pass"));
		pass.sendKeys("shilpamohanty");
		WebElement login=driver.findElement(By.name("login"));
		login.click();
		String title=driver.getTitle();
		System.out.println(title);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
	}

}

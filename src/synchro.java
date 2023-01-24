import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class synchro {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
try {
driver.get("https://www.flipkart.com/");
System.out.println("page loaded");
}
catch(Exception e) {
	System.out.println("page not loaded");
}
driver.close();
	
}
}
package debug;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Vtiger {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement ele = driver.findElement(By.name("user_name"));
ele.clear();
ele.sendKeys("admin");
WebElement ele1 = driver.findElement(By.name("user_password"));
ele1.clear();
ele1.sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("(//td[@class='tabUnSelected'])[4]")).click();
driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
WebElement fn = driver.findElement(By.name("salutationtype"));
Select s=new Select(fn);
s.selectByValue("Ms.");
driver.findElement(By.name("firstname")).sendKeys("shilpa");
driver.findElement(By.name("lastname")).sendKeys("mohanty");
driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
String parent = driver.getWindowHandle();
Set<String> child = driver.getWindowHandles();
for(String c:child)
{
	driver.switchTo().window(c);
}
driver.findElement(By.xpath("//a[text()='vtiger']")).click();
driver.switchTo().window(parent);

driver.findElement(By.id("title")).sendKeys("shilpamom");
driver.findElement(By.id("department")).sendKeys("accounting");
driver.findElement(By.id("email")).sendKeys("shilpamohanty@gmail.com");
driver.findElement(By.id("assistant")).sendKeys("vaanyaziva");
driver.findElement(By.id("assistantphone")).sendKeys("9830608179");
driver.findElement(By.name("emailoptout")).click();
driver.findElement(By.name("reference")).click();
driver.findElement(By.id("phone")).sendKeys("25645117");
driver.findElement(By.id("mobile")).sendKeys("9830608179");
driver.findElement(By.id("homephone")).sendKeys("25645117");
driver.findElement(By.id("otherphone")).sendKeys("567890432");
driver.findElement(By.id("fax")).sendKeys("9098754");
driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
Set<String> child1 = driver.getWindowHandles();
{
	for(String b:child1)
	{
		driver.switchTo().window(b);
	}
	driver.findElement(By.id("1")).click();
	driver.switchTo().window(parent);
	WebElement save =driver.findElement(By.name("button"));
	Point loc = save.getLocation();
	int x = loc.getX();
	int y = loc.getY();
	JavascriptExecutor js=(JavascriptExecutor) driver;

    Thread.sleep(3000);
    save.click();
    

}


	}

}

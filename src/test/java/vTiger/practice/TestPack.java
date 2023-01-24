package vTiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPack {

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
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("wipro");
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[3]")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("tickersymbol")).sendKeys("vaanya");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String c:child)
		{
			driver.switchTo().window(c);
		}
		driver.findElement(By.id("1")).click();
		driver.switchTo().window(parent);

		WebElement industry = driver.findElement(By.name("industry"));
		Select s=new Select(industry);
		s.selectByValue("Construction");
		WebElement save = driver.findElement(By.name("button"));
		save.click();
	    
	    
		}

	

	}



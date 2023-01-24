package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Test01 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://firelawn.com/");
		driver.findElement(By.name("fl_login_btn")).click();
		driver.findElement(By.xpath("//span[text()='Create Account']")).click();
		driver.findElement(By.id("fl_firstName_Shopper")).sendKeys("shilpa");
		driver.findElement(By.id("fl_lastName_Shopper")).sendKeys("mohanty");
		driver.findElement(By.id("fl_female_Shopper")).click();
		driver.findElement(By.id("fl_phoneNumber_Shopper")).sendKeys("+919830608179");
		driver.findElement(By.id("fl_email_Shopper")).sendKeys("shilpa.mohantysonu@gmail.com");
		driver.findElement(By.id("fl_password_Shopper")).sendKeys("1Shilpaziva$4");
		driver.findElement(By.id("fl_confirmPassword_Shopper")).sendKeys("1Shilpaziva$4");
		driver.findElement(By.id("fl_tc_Shopper")).click();
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		String title=driver.getTitle();
Reporter.log(title, true);
	}

}

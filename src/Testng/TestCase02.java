package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase02 {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.get("https://firelawn.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.id("fl_login_btn")).click();
driver.findElement(By.id("fl_email")).sendKeys("shilpa.mohantysonu@gmail.com");
driver.findElement(By.id("fl_password")).sendKeys("1Shilpaziva$4");
driver.findElement(By.xpath("//span[text()='Login']")).click();

WebElement e = driver.findElement(By.xpath("//a[text()='Women']"));

Actions a=new Actions(driver);
a.moveToElement(e).perform();
WebElement c = driver.findElement(By.xpath("//a[text()='Western Wear']"));
a.moveToElement(c).perform();
WebElement f = driver.findElement(By.xpath("(//a[text()='Tshirts'])[1]"));
f.click();
driver.findElement(By.xpath("\r\n"
		+ "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeSmall MuiButton-outlinedSizeSmall  css-k58djc']")).click();
driver.findElement(By.xpath("(//*[local-name()='svg' and@stroke='currentColor'])[1]"));

driver.findElement(By.xpath("//span[text()='Buy Now']")).click();
driver.findElement(By.xpath("//span[text()='Add New Address']")).click();
driver.findElement(By.name("addressType1")).click();
driver.findElement(By.id("outlined-size-small")).sendKeys("shilpa");
driver.findElement(By.id("outlined-size-small")).sendKeys("2/1 t.n biswas road,kolkata");
driver.findElement(By.xpath("(//fieldset[@class='jss21 MuiOutlinedInput-notchedOutline'])[3]")).sendKeys("5th street parkcircus");
driver.findElement(By.id("outlined-size-small")).sendKeys("quest mall");
WebElement ele = driver.findElement(By.id("demo-simple-select-placeholder-label"));
ele.click();
Select s=new Select(ele);
s.selectByVisibleText("India");
WebElement ele1 = driver.findElement(By.id("demo-simple-select-placeholder-label"));
ele1.click();
s.selectByValue("State");
WebElement ele2 = driver.findElement(By.xpath("demo-simple-select-placeholder-label"));
s.selectByValue("City");
driver.findElement(By.id("outlined-adornment-pincode")).sendKeys("700035");
driver.findElement(By.id("outlined-size-small")).sendKeys("9830608179");
driver.findElement(By.xpath("//button[text()='Add Address']")).click();
	}

}

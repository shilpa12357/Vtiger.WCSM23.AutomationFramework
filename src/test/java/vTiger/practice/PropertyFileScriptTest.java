package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertyFileScriptTest {
	@Test
	public void filescriPT() throws IOException{
		WebDriver driver=new ChromeDriver();

	 
//step 1:read the file in java readable format using file InputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		
		//step 2:Create object for Properties class and import it into java.util
		
		Properties p=new Properties();
		
		
		//step 3: load the file input stream
		p.load(fis);
		
		
		
		//step 4:provide the key and read the value
		String URL =p.getProperty("url");
		driver.get(URL);
		String USER = p.getProperty("username");
		driver.findElement(By.name("user_name")).sendKeys(USER);
		String PWD = p.getProperty("password");
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println(URL);
	
		
		
		
	}

}

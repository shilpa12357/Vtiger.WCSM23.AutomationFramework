package vTiger.practice;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	public class Practise {
	
		
		public static void main(String[] args) throws IOException {
			
			Random ran = new Random();
			int random = ran.nextInt(1000);
			
			//Step 1: Read All the Data
			 /*Read the data from Property File*/
			FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();
			pObj.load(fisp);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			 /*Read the data from Excel Sheet*/
			FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+random;
			
			WebDriver driver=null;
			
			//Step 2: Launch the browser - Run time polymorphism - driver
			if (BROWSER.equalsIgnoreCase("chrome")) 
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("fIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid Browser name");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			
			//Step 3: Login to Application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//Step 4: Click on Organizations link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 5: Click on Create Organization look up image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step 6: Create Organization with mandatory details
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
			//Step 7: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 8: Validate
			String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(orgHeader.contains(ORGNAME))
			{
				System.out.println(orgHeader+" PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			
			//Step 9: Logout of App
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			
			
			
			
			
			
			
			
			
		}

	}


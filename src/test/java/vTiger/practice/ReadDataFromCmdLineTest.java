package vTiger.practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
	@Test
	public void readData() {
		String BROWSER = System.getProperty("Browser");//it is going to accept run time parameter
		System.out.println(BROWSER);
		
		
		String URL = System.getProperty("url");
		System.out.println("url");
		
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
		
		
		
	}

}

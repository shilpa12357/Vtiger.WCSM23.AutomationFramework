package vTiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngTest02 {
	@Test(priority = 1)
	public void callTest() {
		Reporter.log("calls", true);
		
	}
	//enabled=false means skip the test case
@Test(enabled = false)
public void SettingTest() {
	Reporter.log("settings", true);
}
//invocation count means iteration or repeatation 
@Test(priority=1,invocationCount = 3)
public void chatTest() {
	Reporter.log("chats", true);
}
}
//priority of the test case means first negetive will be the first priority
//by default value is 0 and invocation default value is 1
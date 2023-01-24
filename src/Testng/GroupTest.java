package Testng;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GroupTest {
	public void login() {
		Reporter.log("login", true);
	}
	@AfterMethod()
	public void close() {
		Reporter.log("logout", false);
		
	}
	@Test(groups="customer")
	public void createProject() {
		Reporter.log("createProject", true);
	}
   @Test(groups="icon")
   public void addcustomer()
   {
	   Reporter.log("addcustomer", true);
   }
   @Test
   public void deleteCustomer() {
	   Reporter.log("deletecustomer", true);
   }
   @Test
   public void deleteProject() {
	   Reporter.log("deleProject", true);
   }
}



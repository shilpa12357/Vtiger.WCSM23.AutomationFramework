package vTiger.Contacts.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class DemoTest extends BaseClass {
	@Test
	public void DemoTest() throws InterruptedException {
		System.out.println("Demo");
		Thread.sleep(5000);
		
	}
	@Test
	public void sampleTest() throws InterruptedException {
		System.out.println("sample");
		Thread.sleep(5000);
		Assert.fail();
	}
	

}

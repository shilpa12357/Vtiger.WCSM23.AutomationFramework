package vTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RetryAnalyserTEst {
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void retryTest() {
		System.out.println("executed");
		Assert.fail();
	}

}

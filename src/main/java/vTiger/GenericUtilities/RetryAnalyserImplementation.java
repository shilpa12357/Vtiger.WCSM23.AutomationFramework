package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class will provide implementation to iretry analyzer interface of testng
 * @author maver
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count=0;
	int retrycount=3;
	/**
	 * retry until retry count is met
	 */
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}

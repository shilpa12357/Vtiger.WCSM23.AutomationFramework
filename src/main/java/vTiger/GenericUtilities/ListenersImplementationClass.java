package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("-------"+methodName+"-execution started--");
		 test=reports.createTest(methodName);
		 test.log(Status.INFO, "Test execution started"+methodName);
		
				
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
test.log(Status.PASS, "test execution started"+methodName);		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String methodName = result.getMethod().getMethodName();
test.log(Status.FAIL, "test execution fail"+methodName);
test.log(Status.FAIL, result.getThrowable());

		
String ScreenshotsName = methodName+"-"+jutil.getSystemDareFormat();
try {
	String path = wutil.takeScreenshot(BaseClass.sdriver, ScreenshotsName);
	test.addScreenCaptureFromPath(path);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "test execution skipped"+methodName);
test.log(Status.SKIP, result.getThrowable());		
		
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----------suit execution started");
		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDareFormat()+".html") ;
		htmlReport.config().setDocumentTitle("vtiger execution reports");
		htmlReport.config().setReportName("shilpa");
		htmlReport.config().setTheme(Theme.DARK);
		
		
		 reports=new ExtentReports() ;
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base url", "http://localhost:8888");
		reports.setSystemInfo("Base Browser", "chrome");
		reports.setSystemInfo("Base os", "windows");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----------suit execution finished");
  reports.flush();//execution is complete now u can generate the report
	}

}

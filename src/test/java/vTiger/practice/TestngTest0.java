package vTiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngTest0 {
	@Test
	public void demoTest0() {
		Reporter.log("hello java", true);
		Reporter.log("hello selenium", false);

	}

}

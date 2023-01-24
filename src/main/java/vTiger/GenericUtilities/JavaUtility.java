package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * this class consist of generic method related to java
 * @author maver
 *
 */

public class JavaUtility {
	/**
	 * this method will generate a random numbr for every run
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}
	/**
	 * this method will provide the systemdate
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		String value = d.toString();
		return value;
	}
	/**
	 * this method will return the date in specific format
	 * @return
	 */
	public String getSystemDareFormat() {
		Date d=new Date();
		String[] darr = d.toString().split(" ");
		String date=darr[2];
		String month=darr[1];
		String year=darr[5];
		String time=darr[3].replace(":", "_");
		String dateInFormat=date+"_"+month+"_"+year+"_"+time;
		return dateInFormat;
		
	}

}

package vTiger.practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		//to check getRandommethod 
  JavaUtility j=new JavaUtility();
  int ran = j.getRandomNumber();
  System.out.println(ran);
  
 String date = j.getSystemDate();
 System.out.println(date);
 
 String dateformat = j.getSystemDareFormat();
 System.out.println(dateformat);
 PropertyFileUtility putil=new PropertyFileUtility();
String BrowSer = putil.readDataFRromPropertyFile("browser");
System.out.println(BrowSer);
  

ExcelFileUtility ex=new ExcelFileUtility();
String v = ex.readDDataFromExcel("Contacts", 4, 3);
System.out.println(v);
ex.writeDataIntoExcel("Contacts", 4, 6, "batman");
System.out.println("data added");
	}

}

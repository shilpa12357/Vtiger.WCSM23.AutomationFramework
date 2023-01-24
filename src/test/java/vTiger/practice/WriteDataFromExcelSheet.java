package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		//step 2:create a workbook
		
		Workbook wb = WorkbookFactory.create(fis);
		//step 3:get hold of sheet
		
		Sheet sh = wb.getSheet("Organization");
		//step 4:navigate to the required row
		
		Row rr = sh.getRow(4);
		
		
		//step 5:navigate to the req cell
		Cell cc = rr.createCell(7);
	
		
		//step 6:capture the data present inside the cell
		cc.setCellValue("qspiders");
		
		//step 7:write into the file using file output stream
String filepath = ".\\src\\test\\resources\\TestData2.xlsx";
		FileOutputStream fos=new FileOutputStream(filepath);
       wb.write(fos);
       System.out.println("data is added");

	}
}






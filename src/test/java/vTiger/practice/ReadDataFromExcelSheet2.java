package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//step 1:load the file in fileInputStream in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		//step 2:create a workbook
		
		Workbook wb = WorkbookFactory.create(fis);
		//step 3:get hold of sheet
		
		Sheet sh = wb.getSheet("Organization");
		//step 4:navigate to the required row
		
		Row rr = sh.getRow(4);
		//another row
		
		Row rr1 = sh.getRow(1);
		
		//step 5:navigate to the req cell
		Cell cc = rr.getCell(3);
		//another col
		Cell cc2 = rr.getCell(2);
		
		//step 6:capture the data present inside the cell
		String value = cc.getStringCellValue();
		//another value
		String value1 = cc2.getStringCellValue();
		
		System.out.println(value);
		
		System.out.println(value1);
	}

}

package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author maver
 * this class consist of generic method related to excelsheet
 *
 */
public class ExcelFileUtility {
	public String readDDataFromExcel(String Sheet,int rowno, int cellno ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ss = wb.getSheet(Sheet);
		Row rr = ss.getRow(rowno);
		Cell cc = rr.getCell(cellno);
      String value = cc.getStringCellValue();
      return value;
		
		
	}
	/**
	 * this method will provide the row count when specific sheet is provided
	 * @param Sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRow(String Sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IconstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ss = wb.getSheet(Sheet);
		int rowcount = ss.getLastRowNum();
		return rowcount;
		
	}
	public void writeDataIntoExcel(String Sheet, int rowno, int cellno, String value ) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IconstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ss = wb.getSheet(Sheet);
		Row rr = ss.getRow(rowno);
		Cell cc = rr.createCell(cellno);
		cc.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IconstantsUtilities.excelFilePath);
				
		wb.write(fos);
		wb.close();
		
		
	}
	/**
	 * this data will read multiple data from excelsheet
	 * @param SheetNAME
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][]readMultipleData(String SheetNAME) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(IconstantsUtilities.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetNAME);
		int LastRow = sh.getLastRowNum();
		int LastCell = sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[LastRow][LastCell];
		for(int i=0;i<LastRow;i++)
		{
			for(int j=0;j<LastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}

}

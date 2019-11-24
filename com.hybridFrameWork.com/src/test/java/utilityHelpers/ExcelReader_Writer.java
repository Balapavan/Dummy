package utilityHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testData.Constants;

public class ExcelReader_Writer {

	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static HSSFRow row;
//	public static XSSFWorkbook workbook;
//	public static XSSFSheet sheet;
//	public static XSSFRow row;
	
	
	public static void openFile(String strFilepath) throws IOException{
		FileInputStream fis=new FileInputStream(strFilepath);
		workbook=new HSSFWorkbook(fis);
		System.out.println("Open file Done."); 
//		workbook=new XSSFWorkbook(fis);
	}
	
	public static String getCellData(String strSheetName,int rowNo,int colNum) {
		sheet=workbook.getSheet(strSheetName);
		String strCellValue =sheet.getRow(rowNo).getCell(colNum).getStringCellValue().trim(); 
		if(strCellValue.equals(null))
			return "Invalid input received  strCellValue NULL";
		return strCellValue;			
	}
	
	public static String getTestDataFromExcel(String strSheetname,int rowNo,int colNum) throws IOException {
		openFile(Constants.TESTDATSHEETPATH);
		String cellData=getCellData(strSheetname, rowNo, colNum);
		return cellData;
	}
	
	
	public static int lastRownNo() {
		return sheet.getLastRowNum();
	}
	
	
}

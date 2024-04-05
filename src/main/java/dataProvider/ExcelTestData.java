package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelTestData {


	@DataProvider(name = "pincodes_data")
	
	public String[][] pincodeDataForTest() throws IOException {

		String baseDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(baseDir +"/src/test/resources/pincodes.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("pincode1");
		String[][] pincodes = new String[sheet.getLastRowNum()][1];


		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(1);
			int getPincode = (int) cell.getNumericCellValue();
			pincodes[i-1][0] = getPincode +"";	
}

		return pincodes;
	}
}
// comment for test
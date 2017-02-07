package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		String[][] tabArray = null;

		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			if (SheetName.length() == 0) {
				SheetName = "Sheet1";
			}

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 0;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();

			// you can write a function as well to get Column count
			// ExcelWSheet.getRow(0).getPhysicalNumberOfCells(); // gets total number of cells with values
			// ExcelWSheet.getRow(0).getLastCellNum(); // get the number of the last cell - I think we want this one
			int totalCols = 1;

			tabArray = new String[totalRows + 1][totalCols + 1];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;

				for (int j = startCol; j <= totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		return (tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {
				return "";
			} else {
				String CellData = Cell.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}
}
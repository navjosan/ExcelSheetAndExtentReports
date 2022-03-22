package qaAcademy.Practice_Maven;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_Excel {

	public static void main(String[] args) throws IOException {

		int sum = 0;
		
		
		FileInputStream filename = new FileInputStream("C:\\Users\\kaurn\\Downloads\\navxlsx_file.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(filename);
		int sheet_count = workbook.getNumberOfSheets();

		for (int i = 0; i < sheet_count; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				
				Iterator<Row> rows = sheet.iterator();
				Row single_row = rows.next();

				int k = 0;
				int column = 0;
				Iterator<Cell> cell = single_row.cellIterator();

				while (cell.hasNext()) {
					Cell single_cell = cell.next();

					if (single_cell.getStringCellValue().equalsIgnoreCase("Products")) {
						column = k;
						
					}
					k++;
				}

				

				
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Oranges")) {
						Iterator<Cell> ce_value = r.cellIterator();
					
					
						while (ce_value.hasNext()) 
						{
							 Cell c_value = ce_value.next();
							 
						 if(c_value.getCellType()==CellType.STRING)
						 {
							 System.out.println("I'm a String");
						 }
						 else
						 {
							 String str = NumberToTextConverter.toText(c_value.getNumericCellValue());
							 int num = Integer.parseInt(str);
							 sum = sum + num;
						 }
													
						}
					}
				}

			}

		}
		
		System.out.println("Sum of oranges is"+sum);

	}
}
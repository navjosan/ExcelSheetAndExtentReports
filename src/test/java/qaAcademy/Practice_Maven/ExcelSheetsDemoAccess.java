package qaAcademy.Practice_Maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetsDemoAccess {

	
	
	public void getData(String testcase) throws IOException
	{
		// Code for getting the particular sheet
		
				FileInputStream filename = new FileInputStream("C:\\Users\\kaurn\\Downloads\\navfile.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(filename);
				
				int count = workbook.getNumberOfSheets();
				
				for(int i=0;i<count;i++)
				{
					if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Sheet1"))
					{
						XSSFSheet sheet = workbook.getSheetAt(i);
						
					// Iterating the rows
						
					Iterator<Row> rows = sheet.iterator(); // Sheet is a collection of rows 
					Row firstrow = rows.next();
					
					//Grabbing the particular column by iterating each cell
					
					Iterator<Cell> cell = firstrow.cellIterator();	//Row is a collection of cells
					int column=0;
					int k=0;
					while(cell.hasNext())
					{
						Cell value = cell.next();
						if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							column=k;
							System.out.println("Success");
						}
						
						k++;
					}
					
					System.out.println(column);
					
					
					while(rows.hasNext())
					{
						Row r = rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase))
						{
							Iterator<Cell> cell_particular_field = r.cellIterator();
							while(cell_particular_field.hasNext())
							{
								System.out.println(cell_particular_field.next().getStringCellValue());
							}
							
						}
					}
				
				}

				}
			}

	public static void main(String[] args) throws IOException {
		
		
}

}
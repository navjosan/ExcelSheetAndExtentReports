package qaAcademy.Practice_Maven;

import java.io.IOException;

public class Calling_ExcelSheetsDemoAccess {

	public static void main(String[] args) throws IOException {
		
		ExcelSheetsDemoAccess excel_sheet = new ExcelSheetsDemoAccess();
		excel_sheet.getData("Products");
		

	}

}

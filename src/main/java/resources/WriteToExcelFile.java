package resources;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcelFile {

	public String data;
	
	public WriteToExcelFile(String data) {
		this.data = data;
	}
	
	
	
	public void WriteDataToExcelFile() throws IOException {
		
		 XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("GMap Route");
			
			XSSFRow row = sheet.createRow(1);
			
			XSSFCell cell = row.createCell(1);
			
			
			if(data instanceof String) 
				cell.setCellValue((String)data);
				
			
			String filePath = ".\\datafiles\\GMapRoute.xlsx";
			FileOutputStream fos = new FileOutputStream(filePath);
			
			workbook.write(fos);
			
			fos.close();
			
			System.out.println("File operation Successful");
		
		
		
		
		
	}
}

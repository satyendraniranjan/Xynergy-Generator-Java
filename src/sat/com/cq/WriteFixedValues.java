package sat.com.cq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFixedValues {
	public void writeFixedValues(String antenna_Bandwidth)
	{
	try
	{
	FileInputStream file=new FileInputStream(new File("C:\\Users\\esatnir\\Videos\\Excel\\Write.xlsx"));
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet= workbook.getSheetAt(0);
	
	Row row=sheet.getRow(0);
	Cell cell1;
	String bandClass="2500";
	String str="Samsung LTE";
	String date="6/13/2018";
	String config="20";
	String channelType="1";
	int sectorId=1;
	 for(int i=1;i<4;i++)
	 {
		
	  row= sheet.createRow(i);
	
	 for(int k=0;k<17;k++) {
		 cell1 = row.createCell(k);
		 if(k==0)
			 cell1.setCellValue(date);
		 else if(k==1)
			 cell1.setCellValue(str);
		 else if(k==6)
		 {
			 String con=Integer.toString(sectorId);
			 cell1.setCellValue(con);
			 sectorId++;
		 }
		 else if(k==10)
		 {
			 ////go to antenna check
			 cell1.setCellValue(antenna_Bandwidth);
		 }
		 else if(k==14)
			 cell1.setCellValue(bandClass);
		 else if(k==15)
			 cell1.setCellValue(config);
		 else if(k==16)
			 cell1.setCellValue(channelType);
		 
		
	 }
	 }
	
	
	
	
	
	
	
	
	
	try {
        
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\esatnir\\Videos\\Excel\\Write.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Excel Fixed Values has written successfully on disk.");
        }
    catch (Exception e) 
	{
        e.printStackTrace();
    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

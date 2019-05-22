package sat.com.cq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import awt.gui.com.Frame1;

public class AntennaBandwidth {
	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	public String antennaBandwidth(String antenna_List) 
	{
		LOGGER.setLevel(Level.ALL);
		LOGGER.info("Inside/AntennaBandwidth");
		String antenna_name = null;
		int antenna_nameint;
		try {
			
		
		FileInputStream file = new FileInputStream(new File("C:\\CQ ADD\\Antenna_List.xlsx"));
		XSSFWorkbook wb = new  XSSFWorkbook(file);
		Sheet sheet = wb.getSheet("Approved Antennas Main List");
		DataFormatter df = new DataFormatter();
		System.out.println(antenna_List);
		
		
		if(antenna_List.equals("HPA33R-CS4AA-K") || antenna_List.equals("HPA33R-CS4AA-K1"))
			return antenna_name="33";
		else if(antenna_List.equals(null))
			return antenna_name="65";
		else 
         for (int j=1; j< sheet.getLastRowNum() + 1; j++) {
			 int flag=0;
		
			 Row row= sheet.getRow(j);
			 for(int k=1;k<=1;k++) {
				 
				 String str2=df.formatCellValue(row.getCell(k));
				 
				try
				{
				 if(antenna_List.length()>str2.length())
					 break;
				 else
				 {
					 String str=str2.substring(0,antenna_List.length());
				
			        if(!str.equals(antenna_List) && flag==0)
			        {
			        	break;
			        }
			        else
			        {
			        	flag=1;
			        	
			        	antenna_nameint= Integer.parseInt(df.formatCellValue(row.getCell(3)));
			        	antenna_name=Integer.toString(antenna_nameint);
			        	
			            return antenna_name;
			        	
			        }
				 }
				}catch(NumberFormatException ex)
				{
					LOGGER.log(Level.SEVERE, "Inside/NumberFormatExeption", ex);
					//System.out.println("Error");
					return antenna_name="65";	
				}
			 }
        
			 if(j==122 && flag==0)
				 return antenna_name="65";
         
         }
         
	


		}
		catch(Exception e)
        {
			LOGGER.log(Level.SEVERE, "Inside/Exeption/Error in Antenna Bandwidth", e);
			//System.out.println("Error in Antenna Bandwidth");
       	 e.printStackTrace();
        }
		return antenna_name;

}
}
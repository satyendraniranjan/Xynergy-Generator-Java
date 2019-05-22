package sat.com.cq;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import awt.gui.com.Frame1;

public class Read30 {

	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	XSSFWorkbook workbook1;
	XSSFSheet sheet1;

	public void read30(File list, String nameOfReadFile, Object cascade) {
		try {
			
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Inside/Read30");
			int rowHeader = 0;
          //System.out.println("No");
			
			XSSFWorkbook wb = new XSSFWorkbook(list);
			Sheet sheet = wb.getSheetAt(0);
            
			workbook1 = new XSSFWorkbook();
			sheet1 = workbook1.createSheet();
			
			
			
			DataFormatter df = new DataFormatter();

			int count = 0;
			int count1 = 0;

			int rownum = 1;
			

			String cell_Id = "";
		
			String antenna_List = "";
			String market_Name = "";
			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
				
				try
				{

				Row row = sheet.getRow(j);
				int flag = 0;

				int num = 0;
				for (int k = 1; k <= 1; k++) {

					
					String str = df.formatCellValue(row.getCell(k));

					String s = "";

					if (!str.equals(cascade) && flag == 0) {

					

						break;
					} else {
						
						flag = 1;
						
						cell_Id = df.formatCellValue(row.getCell(21));
						count = Integer.parseInt(cell_Id);
						
						
						
						
						if (count ==0) 
						{
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							new Write30().write30(s, market_Name, AntennaBandwidth, rownum, workbook1,sheet1,
									rowHeader, numvalue, nameOfReadFile);
                           // System.out.println("hi");
							count1++;
							rowHeader++;
						}
						
						if (count ==1) 
						{
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							new Write30().write30(s, market_Name, AntennaBandwidth, rownum, workbook1,sheet1,
									rowHeader, numvalue, nameOfReadFile);
                           // System.out.println("hi");
							count1++;
							rowHeader++;
						}
						
						if (count ==2) 
						{
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							new Write30().write30(s, market_Name, AntennaBandwidth, rownum, workbook1,sheet1,
									rowHeader, numvalue, nameOfReadFile);
                           // System.out.println("hi");
							count1++;
							rowHeader++;
						}
							// i++;
							//System.out.print(s);
						 else
							break;

					}

				}
				rownum++;
				
				}catch(java.lang.NumberFormatException ax)
				{
					LOGGER.log(Level.SEVERE, "Inside/NumberFormatException", ax);
					LOGGER.info("Inside/NumberFormatException");
					continue;
				}
				catch(java.lang.NullPointerException a)
				{
					LOGGER.log(Level.SEVERE, "Inside/NullPointerExeption", a);
					LOGGER.info("Inside/NullPointerExeption");
					continue;
				}
				
				
				
				
			}

		} catch (Exception e) {
			
			LOGGER.log(Level.SEVERE, "Inside/Exeption", e);
			LOGGER.info("Inside/Exeption");
			e.printStackTrace();
		}

	}

}

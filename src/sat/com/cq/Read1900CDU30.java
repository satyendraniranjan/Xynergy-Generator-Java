package sat.com.cq;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import awt.gui.com.Frame1;

public class Read1900CDU30 {
	
	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	
	XSSFWorkbook workbook1;
	XSSFSheet sheet1;
	XSSFWorkbook workbook2;
	XSSFSheet sheet2;
	public void read1900CDU30(File file, String nameOfReadFile, Object cascade)
	{
		try {
			
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Inside/Read1900CDU30");
			
			int rowHeader = 0;
			int rowHeader1=0;
			int rownum1=1;
			//FileInputStream file = new FileInputStream(new File(
			//"C:\\\\Users\\\\esatnir\\\\Videos\\\\FDD\\\\Complete SF72XC756 STA CDU30 800 FDD  for BBU No_ 1 2018_07_04_16_09_07.xlsx"));
			
			XSSFWorkbook wb = new XSSFWorkbook(file);
			Sheet sheet = wb.getSheetAt(0);
			//System.out.println("hi i am here");
			//System.out.println(wb.getSheetName(0).equals("1900"));
			String Band=null;
			DataFormatter df = new DataFormatter();
			
			workbook1 = new XSSFWorkbook();
			sheet1 = workbook1.createSheet();
			
			workbook2 = new XSSFWorkbook();
			sheet2 = workbook2.createSheet();
			int count = 0;
			int count1 = 0;

			int rownum = 1;
		
			
			String cell_Id = "";
			
			String antenna_List = "";
			String market_Name = "";
			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
				
				try {
					
				

				Row row = sheet.getRow(j);
				int flag = 0;

				int num = 0;
				for (int k = 1; k <= 1; k++) {

					try
					{
					String str = df.formatCellValue(row.getCell(k));
					
					String s = "";

					if (!str.equals(cascade) && flag == 0) {

						

						break;
					} else {
						
						flag = 1;
						Band=df.formatCellValue(row.getCell(20));
						if(Band.equals("1900"))
                        {
							//System.out.println(df.formatCellValue(row.getCell(28)));
							//System.out.println("yes");
						cell_Id = df.formatCellValue(row.getCell(21));
						count = Integer.parseInt(cell_Id);
						
						
						if (count == 0) {
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							int e= (int) row.getCell(26).getNumericCellValue();
							System.out.println(d);
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							//System.out.println(s+"\n"+numvalue);
							new Write1900().write1900(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
									numvalue, nameOfReadFile,count);

							count1++;
							rowHeader++;
							rownum++;
							// i++;
							
						} 
						
						
						if (count == 1) {
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							int e= (int) row.getCell(26).getNumericCellValue();
							System.out.println(d);
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							//System.out.println(s+"\n"+numvalue);
							new Write1900().write1900(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
									numvalue, nameOfReadFile,count);

							count1++;
							rowHeader++;
							rownum++;
							// i++;
							
						} 
						
						
						if (count == 2) {
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							int e= (int) row.getCell(26).getNumericCellValue();
							System.out.println(d);
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							//System.out.println(s+"\n"+numvalue);
							new Write1900().write1900(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
									numvalue, nameOfReadFile, count);

							count1++;
							rowHeader++;
							rownum++;
							// i++;
							
						} 
						
						
						
						
						
						
						/*else
							break;*/

					}
/* 800 Start............................................................................................*/
						
						else
					{
						try {
							
						
						LOGGER.info("Inside/1900CDU30/800");
						SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
						format.setTimeZone(TimeZone.getTimeZone("CST"));
						String newdate = format.format(new Date());
						newdate = newdate.replace("/", "");
						
						Band=df.formatCellValue(row.getCell(20));
						if(Band.equals("800"))
                        {
							String nameOfReadFile1=cascade+"_800_CQ_"+newdate;
							//System.out.println(nameOfReadFile1);
							
							s += s + row.getCell(1) + " " + row.getCell(11) + " " + row.getCell(13);
							market_Name = df.formatCellValue(row.getCell(2));
							int a = (int) row.getCell(8).getNumericCellValue();
							int b = (int) row.getCell(36).getNumericCellValue();
							int c = (int) row.getCell(24).getNumericCellValue();
							int d = (int) row.getCell(28).getNumericCellValue();
							int e= (int) row.getCell(26).getNumericCellValue();
							String numvalue = Integer.toString(a) + " " + Integer.toString(b) + " "
									+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
							

							antenna_List = df.formatCellValue(row.getCell(34));
							String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
							System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
							//System.out.println(s+"\n"+numvalue);
							new Write800().write800(s, market_Name, AntennaBandwidth, rownum1, workbook2, sheet2, rowHeader1,
									numvalue, nameOfReadFile1,count);

							//count1++;
							rowHeader1++;
						/*System.out.println(count1);
						//System.out.println(j);
						cell_Id = df.formatCellValue(row.getCell(21));
						System.out.println(cell_Id);
						if(count1==(j-1))
						{
							System.out.println("NO");
							count1++;
						}*/
							
						rownum1++;	
					}
						
						}catch(Exception e)
						{
							LOGGER.log(Level.SEVERE, "Inside/Exception", e);
						}
					}

/* 800 End Here ...............................................................................*/				
						
						
				
				/*if(j>3)
					rownum1++;*/
				
				
					}
					
			
			}
			catch(NullPointerException e)
			{
				break;
			}
			}
				
				
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
		}
		 catch (Exception e) {
			 
			 LOGGER.log(Level.SEVERE, "Inside/Exception", e);
				LOGGER.info("Inside/Exeption");
			e.printStackTrace();
		}

	}

}

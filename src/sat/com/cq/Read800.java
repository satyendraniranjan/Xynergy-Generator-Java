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

public class Read800 {
	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());

	XSSFWorkbook workbook1;
	XSSFSheet sheet1;
	public void read800(File list, String nameOfReadFile, Object cascade)
	{
		try
		{
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Inside/read800");
			
			workbook1 = new XSSFWorkbook();
			sheet1 = workbook1.createSheet();
			
			
			int rowHeader = 0;
			String AntennaName = null;
		
			HashMap<Integer,String>hm =new HashMap<>();
			DataFormatter df = new DataFormatter();
			String Cdmafilename= cascade+" STA"+" 800"+" CDMA";
			String Cdmafilename1=cascade+" STA"+" 1900"+" CDMA"+","+" 800"+" CDMA";
			System.out.println(Cdmafilename1);
			//SE52XC358 STA 1900 FDD, 800 FDD
			//SE52XC358 STA 1900 CDMA, 800 CDMA
			//System.out.println(Cdmafilename);
			String directory = "C:\\CQ ADD\\Read CIQ File\\";
			File folder = new File(directory);
			File[] Cdmalist = folder.listFiles();
			try {
				
			
			if(Cdmalist!=null)
			for(int i=0;i<Cdmalist.length;i++)
			{
				
				if(Cdmalist[i].getName().contains(Cdmafilename) || Cdmalist[i].getName().contains(Cdmafilename1))
				{
					LOGGER.info("Inside/read800/CDMA");
					System.out.println("Inside of 800 CDMA");
					XSSFWorkbook wb1= new XSSFWorkbook(Cdmalist[i]);
					Sheet sheet =wb1.getSheetAt(0);
					
					int count = 0;
					int count1 = 0;
					
					for(int j=1;j<sheet.getLastRowNum();j++)
					{
						try {
							
						
						Row row= sheet.getRow(j);
						
						count = Integer.parseInt(df.formatCellValue(row.getCell(19)));
						
						if(count==0)
						{
						 
							if(df.formatCellValue(row.getCell(26))!="Indoor Antenna" || df.formatCellValue(row.getCell(26))!=null || df.formatCellValue(row.getCell(26))!="0")
						AntennaName= df.formatCellValue(row.getCell(26));
							else
								AntennaName="SBCHH-1D65B-V1";
						
							
							
							if(df.formatCellValue(row.getCell(15))!=null)	
						hm.put(count, df.formatCellValue(row.getCell(25)));
							else
								hm.put(count, "0");
							
							
						count1++;
						}
						
						if(count==1)
						{
						 
							if(df.formatCellValue(row.getCell(26))!="Indoor Antenna" || df.formatCellValue(row.getCell(26))!=null || df.formatCellValue(row.getCell(26))!="0")
						AntennaName= df.formatCellValue(row.getCell(26));
							else
								AntennaName="SBCHH-1D65B-V1";
						
							
							
							if(df.formatCellValue(row.getCell(15))!=null)	
						hm.put(count, df.formatCellValue(row.getCell(25)));
							else
								hm.put(count, "0");
							
							
						count1++;
						}
						
						if(count==2)
						{
						 
							if(df.formatCellValue(row.getCell(26))!="Indoor Antenna" || df.formatCellValue(row.getCell(26))!=null || df.formatCellValue(row.getCell(26))!="0")
						AntennaName= df.formatCellValue(row.getCell(26));
							else
								AntennaName="SBCHH-1D65B-V1";
						
							
							
							if(df.formatCellValue(row.getCell(15))!=null)	
						hm.put(count, df.formatCellValue(row.getCell(25)));
							else
								hm.put(count, "0");
							
							
						count1++;
						}
						
						
						
						
						
						}catch(NumberFormatException ex)
						{ 
							LOGGER.log(Level.SEVERE, "Inside/NumberFormatException", ex);
							LOGGER.info("Inside/NumberFormatException");
							break;
						}
						
					catch(java.lang.NullPointerException a)
					{
						LOGGER.log(Level.SEVERE, "Inside/NullPointerExeption", a);
						LOGGER.info("Inside/NullPointerExeption");
						continue;
					}
						
					}
				
					
				}
			}
			}catch(NullPointerException e)
			{
				LOGGER.log(Level.SEVERE, "Inside/NullPointerExeption/CDMA does't exist", e);
				LOGGER.info("Inside/NullPointerExeption/CDMA does't exist");
				AntennaName="Default";
				
				
			}
			
			//System.out.println("Antenna Name="+AntennaName);
			
		//FileInputStream file = new FileInputStream(new File(
					//"C:\\Users\\esatnir\\Videos\\FDD\\Complete SF72XC756 STA 800 FDD  for BBU No_ 1 2018_07_04_16_11_28.xlsx"));
					XSSFWorkbook wb = new XSSFWorkbook(list);
					Sheet sheet = wb.getSheet("800");

					
					
					//System.out.println("Hi");
					//workbook1 = new XSSFWorkbook();
					//sheet1 = workbook1.createSheet();
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
						for (int k = 0; k <= 0; k++) {

							
							String str = df.formatCellValue(row.getCell(k));

							String s = "";

							if (!str.equals(cascade) && flag == 0) {

								

								break;
							} else {
								
								flag = 1;
								
								cell_Id = df.formatCellValue(row.getCell(10));
								count = Integer.parseInt(cell_Id);
								
								if (count == 0) 
								{
									s += s + row.getCell(0) + " " + row.getCell(12) + " " + row.getCell(14);
									market_Name = df.formatCellValue(row.getCell(1));
									int a = (int) row.getCell(6).getNumericCellValue();
									String b = hm.get(count);
									int c = (int) row.getCell(18).getNumericCellValue();
									int d = (int) row.getCell(25).getNumericCellValue();
									int e= (int)  row.getCell(24).getNumericCellValue();
									String numvalue = Integer.toString(a)  + " " +b+" "
											+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
									

									antenna_List = AntennaName;
									
								     String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
									
									System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
									new Write800().write800(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
											numvalue, nameOfReadFile,count);
									count1++;
									rowHeader++;
								} 
								
								
								if (count == 1) 
								{
									s += s + row.getCell(0) + " " + row.getCell(12) + " " + row.getCell(14);
									market_Name = df.formatCellValue(row.getCell(1));
									int a = (int) row.getCell(6).getNumericCellValue();
									String b = hm.get(count);
									int c = (int) row.getCell(18).getNumericCellValue();
									int d = (int) row.getCell(25).getNumericCellValue();
									int e= (int)  row.getCell(24).getNumericCellValue();
									String numvalue = Integer.toString(a)  + " " +b+" "
											+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
									

									antenna_List = AntennaName;
									
								     String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
									
									System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
									new Write800().write800(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
											numvalue, nameOfReadFile,count);
									count1++;
									rowHeader++;
								} 
								
								
								if (count == 2) 
								{
									s += s + row.getCell(0) + " " + row.getCell(12) + " " + row.getCell(14);
									market_Name = df.formatCellValue(row.getCell(1));
									int a = (int) row.getCell(6).getNumericCellValue();
									String b = hm.get(count);
									int c = (int) row.getCell(18).getNumericCellValue();
									int d = (int) row.getCell(25).getNumericCellValue();
									int e= (int)  row.getCell(24).getNumericCellValue();
									String numvalue = Integer.toString(a)  + " " +b+" "
											+ Integer.toString(c) + " " + Integer.toString(d)+ " " + Integer.toString(e);
									

									antenna_List = AntennaName;
									
								     String AntennaBandwidth = new AntennaBandwidth().antennaBandwidth(antenna_List);
									
									System.out.println("Antenna Bandwidth is=" + AntennaBandwidth);
									new Write800().write800(s, market_Name, AntennaBandwidth, rownum, workbook1, sheet1, rowHeader,
											numvalue, nameOfReadFile,count);
									count1++;
									rowHeader++;
								} 
								
								
								
								
								
								
								
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
					LOGGER.log(Level.SEVERE, "Inside/Exception", e);
					LOGGER.info("Inside/Exeption");
					e.printStackTrace();
					//System.out.println("Error in Reading");
				}

		
	}
}

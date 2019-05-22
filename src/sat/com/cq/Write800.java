package sat.com.cq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import awt.gui.com.Frame1;
import file.name.FileWrite;

public class Write800 {

	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	public void write800(String s, String market_Name, String antennaBandwidth, int rownum, XSSFWorkbook workbook1, XSSFSheet sheet1, int rowHeader, String numvalue, String nameOfReadFile, int count2)
	{
		try
		{
			
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Inside/write800");
			
			//System.out.println("hi in 800");
			String sb[] = s.split(" ");
			String sb1[] = numvalue.split(" ");
			//sheet1= workbook1.createSheet();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			format.setTimeZone(TimeZone.getTimeZone("CST"));
			
			String[] rowHeaderName = { "DATE", "VENDORNAME", "MARKET_NAME", "SWITCH_NAME", "CASCADE", "ENODEBID",
					"SECTORID", "LATITUDE", "LONGITUDE", "AZIMUTH", "BEAMWIDTH", "SECTOR_IDENTIFIER", "CLUSTER_NAME",
					"CHANNEL_NUMBER", "BAND_CLASS", "CONFIG", "CHANNEL_TYPE" };
			
			int count = 1;
			int count1 = 4;
			Row row;
			Cell cell1;
			String str = "";
			String bandClass = "800";
			String vendor_name = "Samsung LTE";
			String config = sb1[4];
			String channelType = "1";
			int sectorId = count2;
			//System.out.println("+"+sectorId);
			for (int i = 1; i < 2; i++) {
				
				try {
					
				
				
				if (rowHeader == 0 && rownum < 4) {
					
					
						
					
					
					row = sheet1.createRow(rowHeader);
					
					
					for (int j = 0; j < rowHeaderName.length; j++) 
					{
						cell1 = row.createCell(j);
					cell1.setCellValue(rowHeaderName[j]);
					}
					
					row = sheet1.createRow(rownum);
					count = 0;
					count1 = 2;

					for (int j = 0; j < 18; j++) {

						cell1 = row.createCell(j);
						if (j == 0)
							cell1.setCellValue(format.format(new Date()));
						else if (j == 1)
							cell1.setCellValue(vendor_name);

						else if (j == 2)
							cell1.setCellValue(market_Name);
						else if (j == 3) {
							str = "LTE_" + market_Name + "_SWITCH";
							cell1.setCellValue(str);

						}

						else if (j == 4) {

							cell1.setCellValue(sb[0]);

							count++;
						} 
						
						else if (j == 5)
							cell1.setCellValue(Integer.parseInt(sb1[0]));
						else if (j == 6) {
							//String con = Integer.toString(sectorId);
							//System.out.println("Hi="+sectorId);
							cell1.setCellValue(sectorId);
							//sectorId++;
						} else if (j == 7)
							cell1.setCellValue(Double.parseDouble(sb[1]));

						else if (j == 8)
							cell1.setCellValue(Double.parseDouble(sb[2]));
						else if (j == 9)
							cell1.setCellValue(Integer.parseInt(sb1[1]));

						else if (j == 10)
							cell1.setCellValue(Integer.parseInt(antennaBandwidth));
						if (j == 11)
							cell1.setCellValue(Integer.parseInt(sb1[2]));
						if (j == 13)
							cell1.setCellValue(Integer.parseInt(sb1[3]));

						else if (j == 14)
							cell1.setCellValue(Integer.parseInt(bandClass));
						else if (j == 15)
							cell1.setCellValue(Integer.parseInt(config));
						else if (j == 16)
							cell1.setCellValue(Integer.parseInt(channelType));
						/*else if (j == 5)
							cell1.setCellValue(sb1[0]);
						else if (j == 6) {
							String con = Integer.toString(sectorId);
							cell1.setCellValue(con);
							sectorId++;
						} else if (j == 7)
							cell1.setCellValue(sb[1]);

						else if (j == 8)
							cell1.setCellValue(sb[2]);
						else if (j == 9)
							cell1.setCellValue(sb1[1]);

						else if (j == 10)
							cell1.setCellValue(antennaBandwidth);
						if (j == 11)
							cell1.setCellValue(sb1[2]);
						if (j == 13)
							cell1.setCellValue(sb1[3]);

						else if (j == 14)
							cell1.setCellValue(bandClass);
						else if (j == 15)
							cell1.setCellValue(config);
						else if (j == 16)
							cell1.setCellValue(channelType);
*/
					}
					// rownum++;

				}

				// for row>1
				else {
					
					if (rownum < 4) {
						row = sheet1.createRow(rownum);
						count = 0;
						count1 = 2;

						for (int j = 0; j < 18; j++) {

							cell1 = row.createCell(j);
							if (j == 0)
								cell1.setCellValue(format.format(new Date()));
							else if (j == 1)
								cell1.setCellValue(vendor_name);

							else if (j == 2)
								cell1.setCellValue(market_Name);
							else if (j == 3) {
								str = "LTE_" + market_Name + "_SWITCH";
								cell1.setCellValue(str);

							}

							else if (j == 4) {

								cell1.setCellValue(sb[0]);

								count++;
							} 
							else if (j == 5)
								cell1.setCellValue(Integer.parseInt(sb1[0]));
							else if (j == 6) {
								String con = Integer.toString(sectorId);
								cell1.setCellValue(sectorId);
								sectorId++;
							} else if (j == 7)
								cell1.setCellValue(Double.parseDouble(sb[1]));

							else if (j == 8)
								cell1.setCellValue(Double.parseDouble(sb[2]));
							else if (j == 9)
								cell1.setCellValue(Integer.parseInt(sb1[1]));

							else if (j == 10)
								cell1.setCellValue(Integer.parseInt(antennaBandwidth));
							if (j == 11)
								cell1.setCellValue(Integer.parseInt(sb1[2]));
							if (j == 13)
								cell1.setCellValue(Integer.parseInt(sb1[3]));

							else if (j == 14)
								cell1.setCellValue(Integer.parseInt(bandClass));
							else if (j == 15)
								cell1.setCellValue(Integer.parseInt(config));
							else if (j == 16)
								cell1.setCellValue(Integer.parseInt(channelType));
							/*else if (j == 5)
								cell1.setCellValue(sb1[0]);
							else if (j == 6) {
								String con = Integer.toString(sectorId);
								cell1.setCellValue(con);
								sectorId++;
							} else if (j == 7)
								cell1.setCellValue(sb[1]);

							else if (j == 8)
								cell1.setCellValue(sb[2]);
							else if (j == 9)
								cell1.setCellValue(sb1[1]);

							else if (j == 10)
								cell1.setCellValue(antennaBandwidth);
							if (j == 11)
								cell1.setCellValue(sb1[2]);
							if (j == 13)
								cell1.setCellValue(sb1[3]);

							// cell1 = row.createCell(k);

							else if (j == 14)
								cell1.setCellValue(bandClass);
							else if (j == 15)
								cell1.setCellValue(config);
							else if (j == 16)
								cell1.setCellValue(channelType);*/

						}
						// rownum++;

					} else
						break;
				}

				
				
				}catch(java.lang.NumberFormatException ax)
				{
					LOGGER.log(Level.SEVERE, "\"Inside/Write/NullPointerExeption\"", ax);
					LOGGER.info("Inside/Write/NumberFormatException");
					continue;
				}
				catch(java.lang.NullPointerException a)
				{
					LOGGER.log(Level.SEVERE, "\"Inside/Write/NullPointerExeption\"", a);
					LOGGER.info("Inside/Write/NullPointerExeption");
					continue;
				}
				
			}

			new FileWrite().fileWrite(nameOfReadFile, workbook1);


		
			
			
			
		}catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "\"Inside/Write 2.5 Simple/NullPointerExeption\"", e);
			LOGGER.info("Inside/Write 2.5 Simple/Exeption");
			e.printStackTrace();
			//System.out.println("Error in Writing");
		}
	}
	
}

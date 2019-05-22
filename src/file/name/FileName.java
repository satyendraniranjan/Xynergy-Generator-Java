package file.name;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import awt.gui.com.Frame1;
import sat.com.cq.Read;
import sat.com.cq.Read1900;
import sat.com.cq.Read1900CDU30;
import sat.com.cq.Read30;
import sat.com.cq.Read800;
import sat.com.cq.Read800CDU30;

public class FileName {

	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	public void fileName() {
		try {
			FileName ff = new FileName();
			Scanner scan = new Scanner(System.in);
			System.out.println(" the file to be searched.. ");
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			format.setTimeZone(TimeZone.getTimeZone("CST"));
			String band = "_2500_CQ_";
			String band800 ="_800_CQ_";
			String band1900="_1900_CQ_";
			String directory = "C:\\CQ ADD\\Read CIQ File\\";
			HashMap<Integer, Map> hm1 = new HashMap<>();
			HashMap<Integer, String> hm = new HashMap<>();
			String newdate = format.format(new Date());
			newdate = newdate.replace("/", "");
			File folder = new File(directory);
			//LOGGER.info("Inside of FileName");
			String str = "";
			String[] str1 = null;
			File[] list = folder.listFiles();
			int j = 0;
			if (list != null)
				for (int i = 0; i < list.length; i++) {

					str = list[i].getName();

					str1 = str.split(" ", list[i].getName().length());
					j = 0;
					for (String str2 : str1) {
						hm.put(j, str2);
						j++;
					}
					hm1.put(i, hm);

					if (list[i].getName().contains("2.5 TDD") && !list[i].getName().contains("CDU30 2.5 TDD")) 
					{
						LOGGER.info("Inside of 2.5 TDD");

						String s = hm1.get(i).get(1) + band + newdate;
						
						new Read().read(list[i], s, hm1.get(i).get(1));
						
					}

					 if (list[i].getName().contains("CDU30 2.5 TDD")) 
					 {
						 LOGGER.info("Inside of CDU30 2.5 TDD ");
						String s = hm1.get(i).get(1) + band + newdate;
						
						new Read30().read30(list[i], s, hm1.get(i).get(1));
					 }
					 
				 if(list[i].getName().contains("800 FDD") && !list[i].getName().contains("STA CDU30 1900 FDD, 800 FDD") )
					 {
						 
						 
					 //System.out.println("Inside 800 CDU 30");
					 
					 if(list[i].getName().contains("CDU30"))
					 {
						 ///System.out.println("Inside 800 CDU 30");
						 LOGGER.info("Inside of 800 CDU 30");
						 String s8=hm1.get(i).get(1) + band800 + newdate;
						 new Read800CDU30().read800CDU30(list[i], s8, hm1.get(i).get(1));
					 }
					 else
					 {
						//System.out.println("Inside 800");
						 LOGGER.info("Inside of 800 FDD");
						 String s8=hm1.get(i).get(1) + band800 + newdate;
						 new Read800().read800(list[i], s8, hm1.get(i).get(1));
					 }
					 }
					 
					 
					 if(list[i].getName().contains("1900 FDD"))
					 {
						 
						 
					 
					 
					 if(list[i].getName().contains("CDU30"))
					 {
						 LOGGER.info("Inside of 1900 CDU 30");
						 System.out.println("Inside 1900 CDU 30");
						 String s8=hm1.get(i).get(1) + band1900 + newdate;
						 new Read1900CDU30().read1900CDU30(list[i], s8, hm1.get(i).get(1));
					 }
					 else
					 {
						 LOGGER.info("Inside of 1900 FDD");
						//System.out.println("Inside 1900");
						 String s8=hm1.get(i).get(1) + band1900 + newdate;
						 new Read1900().read1900(list[i], s8, hm1.get(i).get(1));
					 }
					 }
					 
					 
				}

			

		} catch (Exception e) {
LOGGER.info("FileName Exception");
			e.printStackTrace();
		}

	}

}

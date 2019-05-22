package file.name;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.TxtSaveOptions;

import awt.gui.com.Frame1;

public class FileWrite {
	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());
	public void fileWrite(String s, XSSFWorkbook workbook) {
		try {
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Inside/FileWrite");
		//TxtSaveOptions toptions = new TxtSaveOptions();
       // toptions.setSeparator(',');
		FileOutputStream out = new FileOutputStream(new File("C:\\CQ ADD\\Write CQ File\\"+s+".xlsx"));
        workbook.write(out);
        
        out.close();
        System.out.println("Excel  has been written successfully on disk.");
	}catch(Exception e)
		{
		LOGGER.log(Level.SEVERE, "\"Inside/Write 2.5 Simple/NullPointerExeption\"", e);
		e.printStackTrace();
		}
}
}
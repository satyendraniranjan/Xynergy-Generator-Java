package awt.gui.com;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileChooser {
	
	JFileChooser jfc= new JFileChooser();
	StringBuilder sb= new StringBuilder();	
	public void fileChooser() throws FileNotFoundException
	{
		if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			File file= jfc.getSelectedFile();
			Scanner input= new Scanner(file);
			System.out.println(file.getName());
			while(input.hasNext())
			{
				sb.append(input.nextLine());
				sb.append("\n");
				
			}
			input.close();
			
		}
		else
			sb.append("No File was selected");
	}

}

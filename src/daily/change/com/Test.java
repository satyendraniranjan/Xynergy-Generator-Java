package daily.change.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import awt.gui.com.Frame1;

public class Test {

	private static final Logger LOGGER = Logger.getLogger(Frame1.class.getName());

	public String test()
	{
		// TODO Auto-generated method stub
		
	      LOGGER.info("Inside of test");
		
		 String filename = "file.ser";
		 
         
	        // Serialization 
	        try
	        {    File temp =  new File("file.ser");
				if(temp.exists())
				{
					System.out.print(temp.exists());
					try{
					 
	            // Reading the object from a file
	            FileInputStream file = new FileInputStream(filename);
	            ObjectInputStream in = new ObjectInputStream(file);
	             
	            // Method for deserialization of object
	            Demo object1 = (Demo)in.readObject();
	             
	            in.close();
	            file.close();
	             
	            //System.out.println("Object has been deserialized ");
	            //System.out.println("a = " + object1.a);
	            //System.out.println("b = " + object1.b);
				if(object1.b.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date())))
				{
					//System.out.print("Enjoy access");
					return "Process Complete";
				}
				else{
					return "Expire";
					//System.out.print("Renew Licenses");
				}
				}
					 catch(IOException ex)
	        {   
						 LOGGER.info("Inside/Test/IOEXception");
	            System.out.println("IOException is caught1");
	        }
	         
	        catch(ClassNotFoundException ex)
	        {
	        	 LOGGER.info("Inside/Test/ClassNotFoundException");
	            System.out.println("ClassNotFoundException is caught");
	        }
			catch(Exception e)
			{}
				}
				
				else{
						
				Demo object = new Demo(1,new SimpleDateFormat("yyyy/MM/dd"));
	            //Saving of object in a file
	            FileOutputStream file = new FileOutputStream(filename);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	             
	            // Method for serialization of object
	            out.writeObject(object);
	             
	            out.close();
	            file.close();
	             
	            //System.out.println("Object has been serialized");
	            return "Click Again";
				//System.out.print("Excess");
				}
			
				
	 
	        }
	         
	        catch(Exception ex)
	        {
	        	 LOGGER.info("Inside/Test/Exception");
	            System.out.println("IOException is caught2");
	        }
			return null;
			

			
			

	}

}

class Demo implements java.io.Serializable

{
    public int a;
    public String b;
 
    // Default constructor
    public Demo(int a, DateFormat dateFormat)
    {
		Date date = new Date();
		
        this.a = a;
        this.b = dateFormat.format(date);
    }
 
}
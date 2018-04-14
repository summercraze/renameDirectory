package renameDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main 
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		File folder = new File("C:\\Users\\Rong\\Desktop\\example");
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++)
		 {
		  
		    String newName = renameFile(listOfFiles[i].getName());	      
		    File newFile = new File("C:\\Users\\Rong\\Desktop\\example\\" + newName);
		    listOfFiles[i].renameTo(newFile);
		  
		}
	    
	   
	}
	public static String renameFile(String actualName)
	{
		String actualNewName = "";
		String newName = actualName.replace("Exercise", "");
		String[] newNameArray = newName.split("_");
        for(int i = 0; i < newNameArray.length; i++)
        {
        	if(newNameArray[i].length()==1)
        	{
        		newNameArray[i] = "0" + newNameArray[i];
        	}
        	if(i == 0)
    		{
    			newNameArray[i] = newNameArray[i] + "_";
    		}
        	actualNewName = actualNewName + newNameArray[i];
        }
		return "excercise" + actualNewName;
	}
}

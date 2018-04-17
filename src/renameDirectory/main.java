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
		    File newFile = new File(listOfFiles[i].getParent() + "\\" + newName);
		    listOfFiles[i].renameTo(newFile);		  
		 }	    	   
	}
	public static String renameFile(String actualName )
	{
		String actualNewName = "";
		if(actualName.matches("Exercise[\\d]_[\\d].*") 
				|| actualName.matches("Exercise[\\d]{2}_[\\d].*") 
				|| actualName.matches("Exercise[\\d]_[\\d]{2}.*"))
		{
			int startIndex = actualName.lastIndexOf('e') + 1;
			int endIndex = actualName.lastIndexOf('_') + 1;
			actualNewName = actualName;
			if(actualName.charAt(startIndex) != '0' && actualName.charAt(startIndex + 1) == '_' )
			{
				StringBuilder sb = new StringBuilder(actualName);
				sb.insert(startIndex, '0');
				actualNewName = sb.toString();
			}
			if(actualName.charAt(endIndex) != '0' && actualName.charAt(endIndex - 1) == '_')
			{
				StringBuilder sb = new StringBuilder(actualNewName);
				int newNameEndIndex = actualNewName.lastIndexOf('_') + 1;
				sb.insert(newNameEndIndex, '0');
				actualNewName = sb.toString();

			}
			return actualNewName;
		}
		return actualNewName;
	}	
}

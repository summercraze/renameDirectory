/*
 * This is a code that help to rename files in a directory,
 * it would look at different file and if the file is name x_x
 * it would become 0x_0x
 */

package renameDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main 
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		//it look at the location and locate all the file
		File folder = new File("C:\\Users\\Rong\\Desktop\\example");
		File[] listOfFiles = folder.listFiles();

		//for every file, rename the file
	    for (int i = 0; i < listOfFiles.length; i++)
		{
	    	String newName = renameFile(listOfFiles[i].getName());
		    File newFile = new File(listOfFiles[i].getParent() + "\\" + newName);
		    listOfFiles[i].renameTo(newFile);		  
		}	    	   
	}
	
	//function to rename the file
	public static String renameFile(String actualName )
	{
		String actualNewName = "";
		//check the name is matched 
		if(actualName.matches("Exercise[\\d]_[\\d].*") 
				|| actualName.matches("Exercise[\\d]{2}_[\\d].*") 
				|| actualName.matches("Exercise[\\d]_[\\d]{2}.*"))
		{
			//the start index is number after the Exercise and the endIndex is after _
			int startIndex = actualName.lastIndexOf('e') + 1;
			int endIndex = actualName.lastIndexOf('_') + 1;
			actualNewName = actualName;
			
			//add 0 in front if the number is single digit
			if(actualName.charAt(startIndex) != '0' && actualName.charAt(startIndex + 1) == '_' )
			{
				StringBuilder sb = new StringBuilder(actualName);
				sb.insert(startIndex, '0');
				actualNewName = sb.toString();
			}
			
			//add 0 in fornt is the latter number is single digit
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

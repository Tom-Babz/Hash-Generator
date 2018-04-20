import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Controls what is added and removed from the hash text file.
 * @author Thomas
 *
 */
public class FileControl
{
	// To see if any data needs changing. 
	private boolean replaced = false;
	// Holds each line from the file plus one extra for null.
	String[] dataArray = new String[this.getSize()];
	
	/**
	 * Gets the number of lines used in a file.
	 * @return int size
	 */
	public int getSize()
	{
		// Set int to 0.
		int count = 0;
		try
		{
			// Make new scanner object.
			Scanner file = new Scanner(new File("Resources\\Hash.txt"));
			// Count the number of lines in the file specified above.
		    while (file.hasNextLine()) 
		    {
		    	  count++;
		    	  file.nextLine();
		    }
		}
		catch(Exception e)
		{
			System.err.println("Hash file size could not be determined.");
		}
		return count;
	}
	
	
	/**
	 * Method to load data from the hash data file.
	 * @return String[] fileContents
	 */
	public String[] loadDataFile() 
	{	
		// Open a new connection to the file
		File hashFile = new File("Resources\\Hash.txt");
		// Initialise int counter.
		int a = 0;
		try 
		{
			// FileReader reads character files
			// BufferedReader reads as many characters as possible
			BufferedReader getData = new BufferedReader(new FileReader(hashFile));
			// Reads a whole line from the file and saves it in a String
			// readLine returns null when the end of the file is reached
			String line = getData.readLine();
			while(line != null)
			{
				// Add line to array
				dataArray[a] = line;
				// Read next line.
				line = getData.readLine();
				//Increment A so that the string array doesn't overwrite.
			    a++;
			}
			// Close the BufferedReader.
			getData.close();
		} 
		// Can be thrown by FileReader
		catch (FileNotFoundException e) 
		{
			System.out.println("Hash data File not found.");
		}
		catch(IOException e)
		{
			System.out.println("An I/O Error Occurred");
		}
		// Return data.
		return dataArray;
	}
	
	
	/**
	 * Method to compare what the hash data file holds against the file the user just hashed.
	 * @param cli
	 * @param hashCtrl
	 */
	public String[] hashCheck(String[] dataArray)
	{
		// Initialise object.
		HashControl hashCtrl= new HashControl();
		CliReader cli = new CliReader();
		
		// Find how many lines were in the file.
		int b = dataArray.length;
		// Make a new String array triple the size of the first to hold each individual component.
		int c = (b * 3) + 3;
		// Declare new individual string array.
		String[] splitDataArray = new String[c];
		
		// If the hash file contains data, check it.
	    if(!(b == 0) )
		{
			// FOR the number of lines in the file.
			for(int a = 0; a < b; a++)
			{
				// Split the first String into its smaller components.
				String[] entryRecord = dataArray[a].split(" | ");
				// IF current file/directory name is equal to the file/directory name in file, 
				// AND IF current hash function is the same as the one the file,
				// AND IF the hashes don't match we can assume the data has changed.
				if( (cli.getFileName().equals(entryRecord[0])) && (cli.getHash().equals(entryRecord[2])) && (!(hashCtrl.getHasedData().equals(entryRecord[4]))) )
				{
					// Tell the user the file name and hash function match but the hash does not.
					System.err.println(
							  "WARNING: Data file contains an entry with the same name and hashing function used but different hash value.\n"
							+ "This file may have been altered!"); 
					//Replace the currently accessed line data with current held hash data.
					entryRecord[0] = cli.getFileName();
					entryRecord[2] = cli.getHash();
					entryRecord[4] = hashCtrl.getHasedData();
					this.SetReplaced(true);
				}
				// Add currently accessed line to the splitDataArray.
				splitDataArray[a * 3] = entryRecord[0];
				splitDataArray[a * 3 + 1] = entryRecord[2];
				splitDataArray[a * 3 + 2] = entryRecord[4];
			}
			if(this.getReplaced() == false)
			{
				// Else add new entry to ArrayList 'record'.
				splitDataArray[c - 3] = cli.getFileName();
				splitDataArray[c - 2] = cli.getHash();
				splitDataArray[c - 1] = hashCtrl.getHasedData();
			}
		}
		else
		{
			// Add a first entry to the hash file.
			splitDataArray[0] = cli.getFileName();
			splitDataArray[1] = cli.getHash();
			splitDataArray[2] = hashCtrl.getHasedData();
	    }
		return splitDataArray;
	}
	
	
	private static PrintWriter createFile(String fileName)
	{
		try
		{
			// Creates a File object that allows you to work with files on the hardrive
			File hashFile = new File(fileName);
			
			// FileWriter is used to write streams of characters to a file
			// BufferedWriter gathers a bunch of characters and then writes
			// them all at one time (Speeds up the Program)
			// PrintWriter is used to write characters to the console, file
			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(hashFile)));
			return infoToWrite;
		}
		// You have to catch this when you call FileWriter
		catch(IOException e)
		{
			System.out.println("An I/O Error Occurred");
		}
		return null;
	}


	/**
	 * Method to save the String passed as an argument.
	 * @param splitDataArray
	 */
	public void saveDataFile(String[] splitDataArray) 
	{
		try
		{
			PrintWriter printWriter = createFile("Resources\\Hash.txt");
			writeToFile(splitDataArray, printWriter);
			// Closes the connection to the PrintWriter
			printWriter.close();
			System.out.println("data was saved to file.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Data could not be saved to the file.");
		}
	}

	//Creates a string to write to file
	private void writeToFile(String[] splitDataArray, PrintWriter printWriter)
	{
		int a = 0;
		int b = splitDataArray.length;
		// Create the String that contains the customer info
		if(this.getReplaced() == true)
		{
			b = b - 1;
		}
		// WHILE splitDataArray is not null
		while( a < b)
		{
			String toFile = splitDataArray[a] + " | " + splitDataArray[a + 1] + " | " + splitDataArray[a + 2];
			// Writes the string to the file
			printWriter.println(toFile);
			a +=3;
		}
	}
	
	public void SetReplaced(boolean replaced)
	{
		this.replaced = replaced;
	}
	
	public boolean getReplaced()
	{
		return replaced;
	}
}

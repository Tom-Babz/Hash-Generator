import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Menu class, this is where all menu actions are called from.
 * @author Thomas
 *
 */
public class Menu
{
	// Scanner object to scan the console for user input.
	Scanner scan = new Scanner(System.in);
	// CommandLineReader object to use validate user input.
	CliReader cli = new CliReader();
	// FileReader object to read from files.
	FileByteReader fr = new FileByteReader();
	// DirReader object to read the contents of a directory.
	DirReader dr = new DirReader();
	// HashControl object, to streamline custom hashing functions and built in functions so that they take and give data in a standard format.
	HashControl hashCtrl = new HashControl();
	// String array to hold user input once its been split.
	String[] inputArray;
	
	/**
	 * Constructor prints initial welcome message.
	 */
	Menu()
	{
		System.out.println(
				  "Welcome to Hash Generator\n"
				+ "This Java based application is designed to provide support tools to identify tampering with file-system contents.\n\n"
				+ "Use '-man' to read the manual or '-help' for a quick tutorial if you get stuck in using the application.");
	}
	
	
	/**
	 * Takes user input and validates it.
	 */
	public void CommandLineInput()
	{
		// String that holds user input.
		String input = new String();
		
		// Show the user console is active.
		System.out.print("User: ");
		// User input is put into input string.
		input = scan.nextLine();
		// Single user input string is split by space characters into the inputArray.
		inputArray = input.split(" ");
		// Scanner is closed to prevent resource leak.
		// inputArray is passed to CLIReader to be validated.
		cli.validate(inputArray);
		
		// Check if the user requested help in their input.
		if(cli.getAssistanceHelp() == true)
		{
			try 
			{
				// File to search for.
				File next = new File("Resources\\Help.txt");
				// Get the file path as a string.
				String helpPath= next.getCanonicalPath();
				// Tell user you are reading the file.
				System.out.println("Retrieving help file.");
				// Get data from the help file and make it into a string.
				String text = new String(fr.ReadFileBytes(helpPath));
				// Print text to the screen.
				System.out.println(text);
			} 
			catch (IOException e) 
			{
				System.err.println("Help file could not be retreived.");
			}
		}
		// Check if the user requested help in their input.
		else if (cli.getAssistanceMan() == true)
		{
			try
			{
				// File to search for.
				File next = new File("Resources\\Man.txt");
				// Get the file path as a string.
				String manPath= next.getCanonicalPath();
				// Tell user you are reading the file.
				System.out.println("Retrieving man file.");
				// Get data from the man file and make it into a string.
				String text = new String(fr.ReadFileBytes(manPath));
				// Print text to the screen.
				System.out.println(text);
			}
			catch (IOException e) 
			{
				System.err.println("Man file could not be retreived.");
			}
		}
	}
	
	/**
	 * Method calls the HashControl class so that the hash the user wants can be found and used on the data the user wants.
	 * @return String hashedData
	 */
	public String hash()
	{
		// With all data gathered in the validate method we can now hash.
		return hashCtrl.whatToHash(cli, cli.getHash());
	}
	
	
	
	/**
	 * Method calls the FileControl class to read or write to hash text file.
	 * @param hashedData
	 */
	public void operateHashFile(String hashedData)
	{
		// Create a new instance of FileControl.
		FileControl fileCtrl = new FileControl();
		// Ask user if they would like to save the hash to the data file.
		System.out.print(
				  "Would you like to save the hash to the Hash file? [Y/N]\n"
				+ "User: ");
		// Scan user input.
		String input = scan.nextLine();
		// IF user input equals yes.
		if(input.equals("Y") || input.equals("Yes") || input.equals("y") || input.equals("yes") || input.equals("YES") )
		{
			//fileCtrl.loadDataFile() returns string[]
			fileCtrl.saveDataFile( fileCtrl.hashCheck( fileCtrl.loadDataFile() ) );
			
		}
		else
		{
			System.out.println("Data not saved.");
		}
	}
}

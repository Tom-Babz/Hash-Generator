/**
 * Main class where the program starts.
 * @author Thomas
 *
 */
public class Main 
{
	// TODO fill out help file
	// TODO fill out arguments -remove -replace
	// TODO generate HTML and a tester
	
	public static void main(String[] args) 
	{
		// Create new menu object.
		final Menu menu = new Menu();
		// Infinite loop that will only break when the user decides to quit the program.
		while(true)
		{
			// Call the CommandLineInput method to receive and process user input.
			menu.CommandLineInput();
			
			// Call the hash method to hash files/directories.
			// Ask user if they would like to save the hash to the hash text file, 
			// if so and if the hash and file name already exists then alert the user and ask for input(replace or remove).
			menu.operateHashFile(menu.hash());
		}
	}
}

import java.io.File;
import java.io.IOException;

/**
 * CLIReader class is responsible for reading user input and making sure it is valid.
 * @author Thomas
 *
 */
public class CliReader 
{
	// Holds the path to the file.
	private static String filePath = new String();
	// Holds the files name.
	private static String fileName = new String();
	// Holds the path to the directory.
	private static String dirPath = new String();
	// Holds the hash function the user chose.
	private static String hash = new String("md5");
	// Boolean to check if it is a file.
	private static boolean isFile = false;
	// Boolean to check if it is a directory.
	private static boolean isDir = false;
	// Boolean to check if the user chose the meta argument.
	private static boolean isMeta = false;
	// Boolean to check if the user chose the help argument.
	private static boolean assistanceHelp = false;
	// Boolean to check if the user chose the manual argument.
	private static boolean assistanceMan = false;

	
	/**
	 * Method takes the user input and processes it, checks what the user would like to hash and what hash function they would like to use.
	 * Also checks to see if the user requested help or the manual.
	 * @param args
	 */
	public void validate(String[] args)
	{	
		// If argument array is more than zero.
		if ( args.length > 0 ) 
		{
			// For each argument in the argument array.
			for (String arg : args)
			{	
				// If file starts with '-' it must be an argument.
				if (arg.startsWith("-")) 
				{
					// Compare user input to options available.
					if (arg.toLowerCase().equals("-help"))
					{
						// Help option specified.
						System.out.println("Help option detected");
						// Set assistanceHelp to true.
						assistanceHelp = true;
						// User requested help and so we can disregard any other arguments.
						break;
					}
					else if (arg.toLowerCase().equals("-man")) 
					{
						// Manual option specified.
						System.out.println("man option detected");
						// Set assistanceMan to true.
						assistanceMan = true;
						// User requested manual and so we can disregard any other arguments.
						break;
					}
					if (arg.toLowerCase().equals("-remove"))
					{
						//TODO add code here
						System.out.println("Oh no! This argument has not been implemented yet");
					}
					else if (arg.toLowerCase().equals("-replace"))
					{
						//TODO add code here
						System.out.println("Oh no! This argument has not been implemented yet");
					}
					else if (arg.toLowerCase().equals("-meta")) 
					{
						// Meta option specified.
						System.out.println("meta option detected");
						// User used meta option so set meta to true.
						setIsMeta(true);
					}
					else if (arg.toLowerCase().equals("-md2")) 
					{
						// MD2 option specified.
						System.out.println("MD2 hash option detected");
						// Set the hash to MD2.
						setHash("md2");
					}
					else if (arg.toLowerCase().equals("-md5")) 
					{
						// MD5 option specified.
						System.out.println("MD5 hash option detected");
						// Set the hash to MD5.
						setHash("md5");
					}
					else if (arg.toLowerCase().equals("-sha1")) 
					{
						// SHA-1 option specified.
						System.out.println("SHA1 hash option detected");
						// Set the hash to SHA-1.
						setHash("SHA-1");
					}
					else if (arg.toLowerCase().equals("-sha256")) 
					{
						// SHA-256 option specified.
						System.out.println("SHA256 hash option detected");
						// Set the hash to SHA-256.
						setHash("SHA-256");
					}
					else if (arg.toLowerCase().equals("-sha384")) 
					{
						// SHA-384 option specified.
						System.out.println("SHA384 hash option detected");
						// Set the hash to SHA-384.
						setHash("SHA-384");
					}
					else if (arg.toLowerCase().equals("-sha512")) 
					{
						// SHA-512 option specified.
						System.out.println("SHA512 hash option detected");
						// Set the hash to SHA-512.
						setHash("SHA-512");
					}
					else if (arg.toLowerCase().equals("-hash1")) 
					{
						// Hash1 option specified.
						System.out.println("hash1 option detected");
						// Set the hash to hash1.
						setHash("hash1");
					}
					else if (arg.toLowerCase().equals("-hash2")) 
					{
						// Hash2 option specified.
						System.out.println("hash2 option detected");
						// Set the hash to hash2.
						setHash("hash2");
					}
					else if (arg.toLowerCase().equals("-hash3")) 
					{
						// Hash3 option specified.
						System.out.println("hash3 option detected");
						// Set the hash to hash3.
						setHash("hash3");
					}
					else 
					{
						// Tell the user has entered an unreadable argument.
						System.err.println("Ignoring unknown option : " + arg);
					}
				}//END IF
				// Arguments have been evaluated, so we can assume the other argument left is a file/directory.
				else 
				{
					// Make the String the user entered, into a file so it can be operated on as one.
					File next = new File(arg);
					try 
					{
						// Set the file name.
						setFileName(arg);
						// Try to find the full path of the file.
						arg = next.getCanonicalPath();
					} 
					catch (IOException e1) 
					{
						System.err.println("File could not be read.");
					}
					// Check if the file/directory exists.
					if ( next.exists() )
					{
						// Check if it is a file.
						if ( next.isFile() ) 
						{
							// Found a file
							System.out.println("Valid file name detected : " + arg);
							// Set file to true.
							setIsFile(true);
							// Set file path.
							setFilePath(arg);
						}
						// Check if it is a directory.
						else if ( next.isDirectory() ) 
						{
							// Found a directory.
							System.out.println("Valid directory name detected : " + arg);
							// Set directory to true.
							setIsDir(true);
							// Set directory path.
							setDirPath(arg);
						}
					}
					// The argument was not understood as a file/directory or an argument.
					else
					{
						System.err.println("Specified file/directory name does not exist : " + arg);
					}
				}//END ELSE
			}//END FOR
		}//END (args.length > 0) 
		// Tell the user no argument was specified.
		else 
		{
			System.out.println("No Arguments specified");
		}
		
	}//END METHOD
	
	/**
	 * Getter for directory path.
	 * @return String directoryPath
	 */
	public String getDirPath()
	{
		return dirPath;
	}
	/**
	 * Setter for directory path.
	 * @param directoryPath
	 */
	public void setDirPath(String directoryPath)
	{
		dirPath = directoryPath;
	}
	
	
	/**
	 * Getter for file path.
	 * @return String filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}
	/**
	 * Setter for file path.
	 * @param filePath
	 */
	public void setFilePath(String filePath)
	{
		CliReader.filePath = filePath;
	}
	
	
	/**
	 * Getter for isFile.
	 * @return boolean isFile
	 */
	public boolean getIsFile()
	{
		return isFile;
	}
	/**
	 * Setter for isFile.
	 * @param isFile
	 */
	public void setIsFile(boolean isFile)
	{
		CliReader.isFile = isFile;
	}
	
	
	/**
	 * Getter for isDir.
	 * @return boolean isDir
	 */
	public boolean getIsDir()
	{
		return isDir;
	}
	/**
	 * Setter for isDir.
	 * @param isDir
	 */
	public void setIsDir(boolean isDir)
	{
		CliReader.isDir = isDir;
	}
	
	
	/**
	 * Getter for getHash.
	 * @return String hash
	 */
	public String getHash()
	{
		return hash;
	}
	/**
	 * Setter for setHash.
	 * @param hash
	 */
	public void setHash(String hash)
	{
		CliReader.hash = hash;
	}
	
	
	/**
	 * Getter for isMeta.
	 * @return boolean isMeta
	 */
	public boolean getIsMeta()
	{
		return isMeta;
	}
	/**
	 * Setter for isMeta.
	 * @param isMeta
	 */
	public void setIsMeta(boolean isMeta)
	{
		CliReader.isMeta = isMeta;
	}
	
	
	/**
	 * Getter for assistanceHelp.
	 * @return boolean assistanceHelp
	 */
	public boolean getAssistanceHelp()
	{
		return assistanceHelp;
	}
	/**
	 * Setter for assistanceHelp.
	 * @param assistanceHelp
	 */
	public void setAssistanceHelp(boolean assistanceHelp)
	{
		CliReader.assistanceHelp = assistanceHelp;
	}
	
	
	/**
	 * Getter for assistanceMan.
	 * @return boolean assistanceMan
	 */
	public boolean getAssistanceMan()
	{
		return assistanceMan;
	}
	/**
	 * Setter for assistanceMan.
	 * @paramn assistanceMan
	 */
	public void setAssistanceMan(boolean assistanceMan)
	{
		CliReader.assistanceMan = assistanceMan;
	}
	
	
	/**
	 * Getter for fileName.
	 * @return String fileName
	 */
	public String getFileName()
	{
		return fileName;
	}
	/**
	 * Setter for fileName.
	 * @param fileName
	 */
	public void setFileName(String fileName)
	{
		CliReader.fileName = fileName;
	}
	
	/**
	 * Method to check if a value is even or not.
	 * @param num
	 * @return boolean
	 */
	public boolean isEven (int num) 
	{
		//this is even
	    return (num & 1) == 0;
	}
}
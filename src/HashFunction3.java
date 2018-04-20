/**
 * HashFunction3 implements HashChecker as a basis to build the hash function.
 * @author Thomas
 */
public class HashFunction3 implements HashChecker 
{
	// Create instance of the CliReader.
	CliReader cli = new CliReader();
	
	/**
	 * Method to produce a hash on file data.
	 * @param bytes
	 * @return String
	 */
	@Override
	public String produceFileHash(byte[] bytes) 
	{
		// Get the length of the file in bytes.
		int length = bytes.length;
		long total = 0;
		
		// Multiply each byte by a prime number.
		for (byte b : bytes) 
		{
			total += b * 9929 * 9931 * 9941;
		}
		
		// create a very simple hash (total of byte values, each multiplied by a prime number, multiplied by another prime number, multiplied by another prime number, all of which is multiplied by file size).
		total *= length * 9949 * 9967 * 9973;
		
		// Format the output to use 16 chars (since this is the max size of a long).
		System.out.println(String.format(
				  "Hash successful\n"
				+ "File : " + cli.getFileName() + "\nHash value is : %016X", total));
		// Make hash into a String.
		String string = String.valueOf(total);
		// Return hash.
		return string;
	}

	/**
	 * Method to produce hash on file meta data.
	 * @param bytes
	 * @return String
	 */
	public String produceFileMetaHash(byte[] bytes) 
	{
		// Get the length of the file in bytes.
		int length = bytes.length;
		long total = 0;
		
		// Multiply each byte by a prime number.
		for (byte b : bytes) 
		{
			total += b * 9929 * 9931 * 9941;
		}
		
		// create a very simple hash (total of byte values, each multiplied by a prime number, multiplied by another prime number, multiplied by another prime number, all of which is multiplied by file size).
		total *= length * 9949 * 9967 * 9973;
		
		// Format the output to use 16 chars (since this is the max size of a long).
		System.out.println(String.format(
				  "Hash successful\n"
				+ "File : " + cli.getFileName() + "\nHash value is : %016X", total));
		// Make hash into a String.
		String string = String.valueOf(total);
		// Return hash.
		return string;
	}
	
	/**
	 * Method to produce hash on directory data.
	 * @param bytes
	 * @return String
	 */
	@Override
	public String produceDirHash(byte[] bytes) 
	{
		// Get the length of the file in bytes.
		int length = bytes.length;
		long total = 0;
		
		// Multiply each byte by a prime number.
		for (byte b : bytes) 
		{
			total += b * 9929 * 9931 * 9941;
		}
		
		// create a very simple hash (total of byte values, each multiplied by a prime number, multiplied by another prime number, multiplied by another prime number, all of which is multiplied by file size).
		total *= length * 9949 * 9967 * 9973;
		
		// Format the output to use 16 chars (since this is the max size of a long).
		System.out.println(String.format(
				  "Hash successful\n"
				+ "Directory : " + cli.getFileName() + "\nHash value is : %016X", total));
		// Make hash into a String.
		String string = String.valueOf(total);
		// Return hash.
		return string;
	}

	/**
	 * Method to produce hash on directory meta data.
	 * @param bytes
	 * @return String
	 */
	@Override
	public String produceDirMetaHash(byte[] bytes) 
	{
		// Get the length of the file in bytes.
		int length = bytes.length;
		long total = 0;
		
		// Multiply each byte by a prime number.
		for (byte b : bytes) 
		{
			total += b * 9929 * 9931 * 9941;
		}
		
		// create a very simple hash (total of byte values, each multiplied by a prime number, multiplied by another prime number, multiplied by another prime number, all of which is multiplied by file size).
		total *= length * 9949 * 9967 * 9973;
		
		// Format the output to use 16 chars (since this is the max size of a long).
		System.out.println(String.format(
				  "Hash successful\n"
				+ "Directory : " + cli.getFileName() + "\nHash value is : %016X", total));
		// Make hash into a String.
		String string = String.valueOf(total);
		// Return hash.
		return string;
	}
}

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 * HashFunction4 uses java.security.MessageDigest to use effective real world hashes such as MD5 or SHA-512.
 * @author Thomas
 *
 */
public class HashFunction4 
{	
	/**
	 * Method makeHash will hash data with the function you use as an argument.
	 * @param plainText
	 * @param 
	 * @param fileDirectory
	 * @return String hashValue
	 */
	public String makeHash(byte[] plainText, String algorthim, String fileDirectory) 
	{
		// Create new instance of CliReader.
		CliReader cli = new CliReader();
		// Create string to store hashValue.
		String hashValue = new String("");
		try
		{
			// Create instance of MessageDigest using the users chosen algorithm.
			MessageDigest messageDigest = MessageDigest.getInstance(algorthim);
			// Give the unhashed data to the object.
			messageDigest.update(plainText);
			// Put the hashed data into a byte array.
			byte[] digestedBytes = messageDigest.digest();
			// Convert it from a byte array to a String.
			hashValue = DatatypeConverter.printHexBinary(digestedBytes);
			// Tell user the hash was successful.
			System.out.println(String.format(
					  "Hash successful\n"
					+ "Directory : " + cli.getFileName() + "\nHash value is : " + hashValue.substring(0, 16)));
		}
		catch(Exception e)
		{
			System.err.println("Data could not be hashed.");
		}
		// Return hashed data.
		return hashValue;	
	}
}

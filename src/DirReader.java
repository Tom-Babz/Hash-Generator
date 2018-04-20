import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * DirReader reads all files in a directory and converts them to a byte array.
 * @author Thomas
 *
 */
public class DirReader 
{
	// Stores all bytes from read files.
	private static ByteArrayOutputStream superByteArray = new ByteArrayOutputStream();
	
	/**
	 * Method to read all files in a directory.
	 * @param pathName
	 * @return byte[] dirBytes
	 * @throws IOException
	 */
	public byte[] ReadDirBytes(String pathName) throws IOException
	{
		// Set the pathName in a File instance so we can use the .list() method.
		File dir = new File(pathName);
		// List all files in the directory.
		String[] filesInDir = dir.list();
		// FOR each file in the directory.
		for(String file : filesInDir)
		{
			// Set the pathname to a file
			String pathName1 = pathName + "\\" + file;
			// Make it into a Path instance.
			Path path = Paths.get(pathName1);
			// Read the file into a byte array.
			byte[] bytes = Files.readAllBytes(path);
			// Write the byte array into a ByteArrayOutputStream.
			superByteArray.write(bytes);
		}
		// Write the ByteArrayOutputStream into a byte array.
		byte[] dirBytes = superByteArray.toByteArray();
		// Return the Byte array.
		return dirBytes;
	}
	
	/**
	 * Method to read all files meta date in a directory.
	 * @param pathName
	 * @return byte[] dirMetaBytes
	 * @throws IOException
	 */
	public byte[] ReadDirMetaBytes(String pathName) throws IOException
	{
		// Set the pathName in a File instance so we can use the .list() method.
		File dir = new File(pathName);
		// List all files in the directory.
		String[] filesInDir = dir.list();
		// FOR each file in the directory.
		for(String file : filesInDir)
		{
			// Set the pathname to a file
			String pathName1 = pathName + "\\" + file;
			// Make it into a Path instance.
			Path path = Paths.get(pathName1);
			// Create BasicFileAttributes instance to gather file meta data.
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
			// Put all meta data into a string.
			String a = attr.creationTime().toString()
	        		+ attr.lastAccessTime().toString()
	        		+ attr.lastModifiedTime().toString()
	        		+ attr.isDirectory()
	        		+ attr.isRegularFile()
	        		+ attr.isOther()
	        		+ attr.size();
			// Make a byte array from the string.
			byte[] fileMetaBytes = a.getBytes();
			// Put byte array into ByteArrayOutputStream.
			superByteArray.write(fileMetaBytes);
		}
		// Write the ByteArrayOutputStream into a byte array.
		byte[] dirMetaBytes = superByteArray.toByteArray();
		// Return the Byte array.
		return dirMetaBytes;
	}
}
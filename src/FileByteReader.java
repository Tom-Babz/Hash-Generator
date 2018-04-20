import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * FileByteReader class is used to read files and file meta data into a byte array.
 * @author Thomas
 *
 */
public class FileByteReader 
{
	/**
	 * Method to read the data from a file.
	 * @param pathName
	 * @return byte[] array
	 * @throws IOException
	 */
	public byte[] ReadFileBytes(String pathName) throws IOException
	{
		// Read bytes of the file and put them into a byte array.
		byte[] fileBytes = Files.readAllBytes(Paths.get(pathName));
		// Return the array.
		return fileBytes;
	}
	
	/**
	 * Method to read the meta data of a file.
	 * @param pathName
	 * @return byte[] array
	 * @throws IOException
	 */
	public byte[] ReadFileMetaBytes(String pathName) throws IOException
	{
		// Make the pathName String into an instance of a Path.
		Path path = Paths.get(pathName);
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
        byte[] fileBytes = a.getBytes();
        // Return the Byte array.
		return fileBytes;
	}
}
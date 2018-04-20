/**
 * Interface for any Classes that perform any hash functions.
 * @author Thomas
 */
public interface HashChecker
{ 
	/**
	 * Method to produce a hash on a file.
	 * @param bytes
	 * @return
	 */
	String produceFileHash(byte[] bytes);

	/**
	 * Method to produce a hash on a directory.
	 * @param bytes
	 * @return
	 */
	String produceDirHash(byte[] bytes);

	/**
	 * Method to produce a hash on a directories meta data.
	 * @param bytes
	 * @return
	 */
	String produceDirMetaHash(byte[] bytes);
}

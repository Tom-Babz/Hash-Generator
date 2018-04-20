
/**
 * This class is where data gets turned into a hash.
 * @author Thomas
 *
 */
public class HashControl 
{
	//String to hold the hashed data.
	private static String hashedData = new String();
	
	/**
	 * Method to find out which hash function the user wanted to use and wheather the user wanted to hash a file or directory.
	 * @param cli
	 * @param hash
	 * @return hashedData
	 */
	public String whatToHash(CliReader cli, String hash)
	{
		// Create new instance of a FileReader.
		FileByteReader fr = new FileByteReader();
		// Create new instance of a DirReader.
		DirReader dr = new DirReader();
		// Create new instance of HashFunction4.
		HashFunction4 hash4 = new HashFunction4();
		try
		{
			// IF the user wanted to use hash1.
			if(hash.equals("hash1"))
			{
				// Create new instance of HashFunction1.
				HashFunction1 hash1 = new HashFunction1();
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash1.produceDirMetaHash(dr.ReadDirMetaBytes(cli.getDirPath()));
					}
					else
					{
						//Read directory data and hash it
						hashedData = hash1.produceDirHash(dr.ReadDirBytes(cli.getDirPath()));
					}
				}
				// IF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash1.produceFileMetaHash(fr.ReadFileMetaBytes(cli.getFilePath()));
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash1.produceFileHash(fr.ReadFileBytes(cli.getFilePath()));
					}
				}	
			}
			// ELIF the user wanted to use hash2.
			else if (hash.equals("hash2"))
			{
				// Create new instance of HashFunction2.
				HashFunction2 hash2 = new HashFunction2();
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it
						hashedData = hash2.produceDirMetaHash(dr.ReadDirMetaBytes(cli.getDirPath()));
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash2.produceDirHash(dr.ReadDirBytes(cli.getDirPath()));
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash2.produceFileMetaHash(fr.ReadFileMetaBytes(cli.getFilePath()));
					}
					else
					{
						//Read file data and hash it.
						hashedData = hash2.produceFileHash(fr.ReadFileBytes(cli.getFilePath()));
					}
				}	
			}
			// ELIF the user wanted to use hash3.
			else if (hash.equals("hash3"))
			{
				// Create new instance of HashFunction3.
				HashFunction3 hash3 = new HashFunction3();
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash3.produceDirMetaHash(dr.ReadDirMetaBytes(cli.getDirPath()));
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash3.produceDirHash(dr.ReadDirBytes(cli.getDirPath()));
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash3.produceFileMetaHash(fr.ReadFileMetaBytes(cli.getFilePath()));
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash3.produceFileHash(fr.ReadFileBytes(cli.getFilePath()));
					}
				}	
			}
			// ELIF the user wanted to use MD2.
			else if (hash.equals("md2"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
			// ELIF the user wanted to use MD5.
			else if (hash.equals("md5"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
			// ELIF the user wanted to use SHA-1.
			else if (hash.equals("SHA-1"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
			// ELIF the user wanted to use SHA-256.
			else if (hash.equals("SHA-256"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
			// ELIF the user wanted to use SHA-384.
			else if (hash.equals("SHA-384"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
			// ELIF the user wanted to use SHA-512.
			else if (hash.equals("SHA-512"))
			{
				// IF the user wanted to hash a directory.
				if(cli.getIsDir() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read directory meta data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirMetaBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
					else
					{
						// Read directory data and hash it.
						hashedData = hash4.makeHash(dr.ReadDirBytes(cli.getDirPath()), cli.getHash(), "Directory");
					}
				}
				// ELIF the user wanted to hash a file.
				else if(cli.getIsFile() == true)
				{
					// IF the user wanted to hash meta data.
					if(cli.getIsMeta() == true)
					{
						// Read file meta data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileMetaBytes(cli.getFilePath()), cli.getHash(), "File");
					}
					else
					{
						// Read file data and hash it.
						hashedData = hash4.makeHash(fr.ReadFileBytes(cli.getFilePath()),cli.getHash(), "File");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Data could not be hashed.");
		}
		// Return the hashedData
		return hashedData;
	}
	
	/**
	 * Getter for the hashedData.
	 * @return String hashedData
	 */
	public String getHasedData()
	{
		return hashedData;
	}
}

package files;

/**
 * @author Jonathan Guthrie
 * jono@guthrie.net.nz
 * Test file for FileOps wrapper
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import files.FileOps;

public class FileOpsTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Set up file to read
		 */
		FileOps file 		= new FileOps("testfiles/test.txt");
		
		/*
		 * out is a List object, each line of the file being read is
		 * being fed into this list, in order.
		 */
		List<String> out = null;
		
		/*
		 * File read command
		 * Populates the List with the file contents
		 */
		out = file.read();
		
		/*
		 * Output to console
		 */
		System.out.println(String.join(", ", out));
		
		
		/*
		 * Write test
		 */
		
		/*
		 * Construct a new date to timestamp the written file with
		 */
		Date d = new Date();
		out.add("");
		out.add("Saved: "+d.toString());
		
		/*
		 * Set the file to write to
		 */
		FileOps fileout 		= new FileOps("testfiles/testout.txt");
		
		/*
		 * Save the file with new content.
		 */
		fileout.save(out);
	}

}

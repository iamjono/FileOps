/**
 * 
 */
package files;

/**
 * @author jono
 *
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
		FileOps file 		= new FileOps("test.txt");
		List<String> out = null;
		try {
			out = file.read();
			System.out.println(String.join(", ", out));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date d = new Date();
		out.add("");
		out.add("Saved: "+d.toString());
		FileOps fileout 		= new FileOps("testout.txt");
		try {
			fileout.save(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

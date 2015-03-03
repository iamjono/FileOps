package files;

/**
 * @author Jonathan Guthrie
 * jono@guthrie.net.nz
 * 
 * FileOps is a simple wrapper for file operations
 * 
 * READ:
 * 		FileOps file 		= new FileOps("testfiles/test.txt");
 *		List<String> out = null;
 *		try {
 *			out = file.read();
 *		} catch (Exception e) {
 *			e.printStackTrace();
 *		}
 *
 * WRITE:
 * 		FileOps fileout 		= new FileOps("testfiles/testout.txt");
 *		try {
 *			fileout.save(out);
 *		} catch (Exception e) {
 *			e.printStackTrace();
 *		}
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileOps {
	/*
	 * inputStream and outputStream fields are initialized as null 
	 * so query can be made to close if they have been populated
	 */
	private static BufferedReader inputStream = null;
	private static PrintWriter outputStream = null;
	/*
	 * Field "file" is persistent to the object
	 */
	private static String file = null;
	
	/*
	 * Constructor
	 */
    public FileOps(String inputStream) throws FileNotFoundException, IOException {
    	file = inputStream;
		setInputStream(new BufferedReader(new FileReader(inputStream)));
	}

    /*
     * Read method
     * Takes no params, returns List of type String
     */
	public static List<String> read() throws IOException {
		List<String> list = new ArrayList<String>();

        try {
            String l;
            while ((l = getInputStream().readLine()) != null) {
            	list.add(l);
            }
        } finally {
        	close();
        }
        return list;
    }
	
    /*
     * Save method
     * Takes no params, returns List of type String
     */
	public static void save(String f) {

        try {
            setOutputStream(new PrintWriter(new FileWriter(f)));
            getOutputStream().println(f);
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
        	close();
        }
    }
    /*
     * Save method
     * Takes no params, returns List of type String
     */
	public static void save(List<String> lines) {
        try {
            setOutputStream(new PrintWriter(new FileWriter(file)));
            for(int i = 0; i < lines.size(); i++){
                getOutputStream().println(lines.get(i));
            }
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
        	close();
        }
    }

	
	/**
	 * @return the inputStream
	 */
	public static BufferedReader getInputStream() {
		return inputStream;
	}
	
	
	
	/**
	 * @param inputStream the inputStream to set
	 */
	public static void setInputStream(BufferedReader inputStream) {
		FileOps.inputStream = inputStream;
	}
	
	
	
	/**
	 * @return the outputStream
	 */
	public static PrintWriter getOutputStream() {
		return outputStream;
	}
	
	
	
	/**
	 * @param outputStream the outputStream to set
	 */
	public static void setOutputStream(PrintWriter outputStream) {
		FileOps.outputStream = outputStream;
	}
	
	/*
	 * Close the files - if set
	 */
	private static void close() {
		if (getInputStream() != null) {
			try {
				getInputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (getOutputStream() != null) {
			getOutputStream().close();
		}
	}
}

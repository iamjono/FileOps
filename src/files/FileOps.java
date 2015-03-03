/**
 * 
 */
package files;

/**
 * @author jono
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class FileOps {
	private static BufferedReader inputStream = null;
	private static PrintWriter outputStream = null;
	private static String file = null;
	

    public FileOps(String inputStream) throws FileNotFoundException, IOException {
    	file = inputStream;
		setInputStream(new BufferedReader(new FileReader(inputStream)));
	}



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
	
	public static void save(String f) throws IOException {

        try {
            setOutputStream(new PrintWriter(new FileWriter(f)));

            String l;
            while ((l = getInputStream().readLine()) != null) {
                getOutputStream().println(l);
            }
        } finally {
        	close();
        }
    }
	public static void save(List<String> lines) throws IOException {
        try {
            setOutputStream(new PrintWriter(new FileWriter(file)));
            for(int i = 0; i < lines.size(); i++){
                getOutputStream().println(lines.get(i));
            }
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
	
	private static void close() throws IOException {
		if (getInputStream() != null) {
			getInputStream().close();
		}
		if (getOutputStream() != null) {
			getOutputStream().close();
		}
	}
}

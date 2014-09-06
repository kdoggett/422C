/*Your Header comment block goes here */

package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class A1Driver 
{
	
	public static void main (String args[]) 
	{ 
		//System.out.println("test");
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile (args[0]);
		
	}

	/**
	 * Opens the file specified in String filename, reads each line in it
	 * Invokes parse () on each line in the file, and prints out the  
	 * string with all discovered palindromes in it.
	 * @param filename - the name of the file that needs to be read
	 */
	public static void processLinesInFile (String filename) 
	{ 

		A1Driver myPalFinder = new A1Driver(); 
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				System.out.println("The input string is: " + s);
				String palindromes = myPalFinder.parse(s);
				System.out.println("The Palindromes found: " + palindromes);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} 
                catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Parses the inputString to find all palindromes based on rules specified 
	 * in your assignment write-up. 
	 * 
	 * @param inputString - the String that needs to be parsed to discover palindromes 
	 * 		
	 * @return the String object containing the Palindromes found in the
	 *         inputString    
	 */
	public String parse (String inputString) 
	{ 
		// modify the following code. Add/delete anything you want after this point.
		String outputString = new String(inputString); // makes a copy of inputString.
		outputString = outputString.toUpperCase();
		System.out.println(outputString);
		return outputString;
	}
	
}
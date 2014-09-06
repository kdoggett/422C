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
		String outputString = new String(inputString); // makes a copy of inputString.
		
		outputString = outputString.toUpperCase();
		outputString = outputString.replaceAll("[^A-Za-z0-9]", "");
		
		int length = outputString.length();
		int i = 1;
		int j = 1;
		char[] pals;
		pals = new char[40];
		
		while(i != length){
			
			char temp1 = outputString.charAt(i);
			char temp2 = outputString.charAt(i - j);
//			char temp3 = outputString.charAt(i + j);
		
			while(i + j != length && outputString.charAt(i - j) == outputString.charAt(i + j))
			{
				pals[i - 1] = outputString.charAt(i - j);
				pals[i] = outputString.charAt(i);
				pals[i + 1] = outputString.charAt(i + j);
				j++;
			}
			j = 1;
			i++;
			
		}
		
		return outputString;
		
	}
	
}
		
/*		//locals
		boolean inPal = false;
		boolean center = true;
		char[] pals;
		pals = new char[20];
		int stringSize;
		int count = 1;
		int storePtr = 0;
		int stringPtr = 1;
		int offset = 1;
		StringBuilder store = new StringBuilder();
		
		//clean string
		outputString = outputString.toUpperCase();
		outputString = outputString.replaceAll("[^A-Za-z0-9]", "");
		
		//store size
		stringSize = outputString.length();
		
		while(stringPtr != stringSize - 1)
		{
			char temp1 = outputString.charAt(stringPtr);
			char temp2 = outputString.charAt(stringPtr - offset);
			char temp3 = outputString.charAt(stringPtr + offset);
			while((stringPtr + offset != stringSize) && 
					(outputString.charAt(stringPtr - offset) == outputString.charAt(stringPtr + offset)))
			{
				
				pals[storePtr] = outputString.charAt(stringPtr - offset);
				offset++;
				inPal = true;
			}
			if(inPal)
			{
				inPal = false;
				offset = 1;
				//store.append(" ");
				//storePosition = count + 2;
				//center = true;
			}
			stringPtr++;			
		}
		//outputString = store.toString();
*/	

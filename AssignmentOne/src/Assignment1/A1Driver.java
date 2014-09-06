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
		int length;
		boolean inPal = false;
		int i = 1;
		int j = 1;
		int k = 0;
		char[][] pals = new char[10][100];
		String outputString = new String(inputString);
		
		//clean string
		outputString = outputString.toUpperCase();
		outputString = outputString.replaceAll("[^A-Za-z0-9]", "");
		
		length = outputString.length();
		
		while(i + j != length)
		{
			//debug
			char temp3 = outputString.charAt(i - 1);
			char temp1 = outputString.charAt(i);
			char temp2 = outputString.charAt(i + 1);
			
			//fill 2d array, don't when i+j hits end of string or i-j goes negative
			while((i + j != length && i - j > -1) && (outputString.charAt(i - j) == outputString.charAt(i + j)))
			{
				inPal = true;  //set flag so we can do stuff when we leave
				pals[k][i] = outputString.charAt(i);
				pals[k][i - j] = outputString.charAt(i - j);
				pals[k][i + j] = outputString.charAt(i + j);	
				j++;
			}
			if(inPal)
			{
				inPal = false;
				j = 1;  //reset offset
				k++;  //increment array for new pal occurence
			}
			i++;
		}
		
		//todo: check for pals in middle of longer pals
		

		outputString = ""; //clear the output string so we can fill it with all palindromes
		int col;
		int row;		
		
		//combine all paliondromes in 2d array into one string
		for(row = 0; row < pals.length; row++)
		{
			for(col = 0; col < pals[0].length; col++)
			{
				if(pals[row][col] != 0)
				{
					outputString = outputString + pals[row][col];
				}
			}
			outputString = outputString + " ";
		}
		
		//remove trailing spaces
		outputString = outputString.replaceFirst("\\s+$","");
		
		return outputString;
	}
	
}
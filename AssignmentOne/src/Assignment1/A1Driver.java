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
	 *         
	 *         works for: 	palindrome 
							racecar
							Evil olive
							A  Toyota
	 */
	public String parse (String inputString) 
	{ 
		String outputString = new String(inputString);
		
		int length;
		boolean inPal = false;
		boolean dup = false;
		int i = 1;
		int j = 1;
		int k = 0;
		
		String tempString = new String();
		String[] pals = new String[10];  //stores all the pals
		String[] palsUnique = new String[10]; //pals without duplicates
		
		//make new stringbuilder, must be better way to declare and fill
		StringBuilder tempStringBuild = new StringBuilder(30);
		for(int l = 0;l < tempStringBuild.capacity();l++)
		{
			tempStringBuild.insert(0,' ');
		}
		
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
			int length2 = length/2;
			
			//create pal string, starts in the middle of stringbuilder and works outward
			while((i + j != length && i - j > -1) && (outputString.charAt(i - j) == outputString.charAt(i + j)))
			{
				inPal = true;  //set flag so we can do stuff when we leave
				tempStringBuild.setCharAt(length/2, outputString.charAt(i));
				tempStringBuild.setCharAt(length/2 + j, outputString.charAt(i + j));
				tempStringBuild.setCharAt(length/2 - j, outputString.charAt(i - j));
				j++;
			}
			if(inPal)
			{
				tempString = tempStringBuild.toString();
				tempString = tempString.replaceAll("\\s+","");  //remove all whitespace
				for (int p = 0;p < k;p++)
				{
					if (tempString.equals(pals[p]))
					{
						dup = true;
					}
				}
				if(!dup)
				{
					pals[k] = tempString; //store the pal
					k++;  //increment array for new pal occurence

				}
				//must be better way to declare and fill
				tempStringBuild = new StringBuilder(30);
				for(int l = 0;l < tempStringBuild.capacity();l++)
				{
					tempStringBuild.insert(0,' ');
				}
				inPal = false;
				j = 1;  //reset offset
				dup = false;
			}
			i++;
		}
		
		
		
		//clear output string
		outputString = "";
/*		int m = 1;
		palsUnique[0] = pals[0];
		
		for(int l = 1;l < k;l++)
		{
			while(palsUnique[m] != null)
			{
				if(pals[l] != palsUnique[m])
				{
					palsUnique[m] = pals[l];
					m++;
				}
			}
			m = 0;
		}*/
		
		//no pals
		if(k == 0)
		{
			outputString = "";
		}
		
		//one pal
		if(k == 1)
		{
			outputString = pals[0];
		}
		
		//multiple pals
		if(k > 1)
		{
			while(k > 0)
			{
			outputString = pals[k - 1] + " " + outputString;
			k--;
			}
		}
		
		return outputString;
	}
	
}
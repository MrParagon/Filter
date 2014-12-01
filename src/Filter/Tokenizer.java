//*******************************
// COMP 472 Project Deliverable 1
// Author: Daniel Miller (6602002)
// Author: Yash Lalwani (6531857)
// 27th October 2014
//*******************************

package Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tokenizer 
{

	public static boolean isWord(String word)
	{
		if (word.length() < 4)
			return false;
		
		for (int i = 0; i < word.length(); ++i)
		{
			if (Character.isLetter(word.charAt(i)) == false)
			{
				return false;
			}	
		}
		
		switch(word) 
		{
			case "mon":
				return false;
			case "tue":
				return false;
			case "wed":
				return false;
			case "thu":
				return false;
			case "fri":
				return false;
			case "sat":
				return false;
			case "sun":
				return false;
			case "jan":
				return false;
			case "feb":
				return false;
			case "mar":
				return false;
			case "apr":
				return false;
			case "may":
				return false;
			case "jun":
				return false;
			case "jul":
				return false;
			case "aug":
				return false;
			case "sep":
				return false;
			case "oct":
				return false;
			case "nov":
				return false;
			case "dec":
				return false;
			case "org":
				return false;
			case "from":
				return false;
			case "delivered":
				return false;
			case "received":
				return false;
			case "localhost":
				return false;
			case "fetchmail":
				return false;
			case "com":
				return false;
			case "net":
				return false;
			case "eval":
				return false;
			case "mime":
				return false;
			case "ascii":
				return false;
			case "utf":
				return false;
			case "mailman":
				return false;
			case "delivery":
				return false;
			case "dogma":
				return false;
			case "esmtp":
				return false;
			case "smtp":
				return false;
			case "text":
				return false;
			case "html":
				return false;
			case "addr":
				return false;
			case "emwac":
				return false;
			case "arpa":
				return false;
			case "bcc":
				return false;
			case "list":
				return false;
			case "post":
				return false;
			case "exmh":
				return false;
			case "localdomain":
				return false;
			case "msgseen":
				return false;
		}
		
		return true;
	}
	
	public static ArrayList<String> tokenizeEmail(File tempFile)
	{
		ArrayList<String> allWords = new ArrayList<String>();
		
		try
		{
			Scanner ab = new Scanner(tempFile);
			
			while (ab.hasNext())
			{
				String tempLine = ab.nextLine();
				String[] tempWords = tempLine.split("\\[|\\]|\\(|\\)|!|'|,| |-|\\.|;|\"|\\?|\\{|\\}");
					
				for (int j = 0; j < tempWords.length; ++j)
				{
					tempWords[j] = tempWords[j].toLowerCase();
						
					if (isWord(tempWords[j]))
					{
						// System.out.print(tempWords[j] + " ");
						allWords.add(tempWords[j]);
					}
				}	
				
			}
			
			ab.close();
			
		}
		catch (FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		
		return allWords;
		
	}
	
	/*
	public static void main(String[] args) 
	{
		
		ArrayList<String> hamWords = new ArrayList<String>();
		ArrayList<String> spamWords = new ArrayList<String>();
		
		
		// Create the list of all spam words (non unique)
		File spamFolder = new File("20030228_spam_2.tar\\spam_2");
		File[] listOfSpamFiles = spamFolder.listFiles();
			
		for (int i = 0; i < 1000; ++i)
		{
			if (listOfSpamFiles[i].isFile())
			{
				File tempFile = new File(listOfSpamFiles[i].getPath());
				// System.out.println(tempFile.getName());
				try 
				{
					Scanner sc = new Scanner(tempFile);
					
					while (sc.hasNext())
					{
						String tempLine = sc.nextLine();
						String[] tempWords = tempLine.split("\\[|\\]|\\(|\\)|!|'|,| |-|\\.|;|\"|\\?|\\{|\\}");
							
						for (int j = 0; j < tempWords.length; ++j)
						{
							tempWords[j] = tempWords[j].toLowerCase();
								
							if (isWord(tempWords[j]))
							{
								// System.out.print(tempWords[j] + " ");
								spamWords.add(tempWords[j]);
							}
						}	
						
					}
					
					
				}
				catch (FileNotFoundException f)
				{
					System.out.println(f.getMessage());
				}
				
			}
			
		}
					
		// Create the list of all ham words (non unique)
		File hamFolder = new File("20030228_easy_ham_2.tar\\easy_ham_2");
		File[] listOfHamFiles = hamFolder.listFiles();
		
		for (int i = 0; i < 1000; ++i)
		{
			if (listOfHamFiles[i].isFile())
			{
				File tempFile = new File(listOfHamFiles[i].getPath());
				// System.out.println(tempFile.getName());
				try 
				{
					Scanner sc = new Scanner(tempFile);
					
					while (sc.hasNext())
					{
						String tempLine = sc.nextLine();
						String[] tempWords = tempLine.split("\\[|\\]|\\(|\\)|!|'|,| |-|\\.|;|\"|\\?|\\{|\\}");
							
						for (int j = 0; j < tempWords.length; ++j)
						{
							tempWords[j] = tempWords[j].toLowerCase();
								
							if (isWord(tempWords[j]))
							{
								// System.out.print(tempWords[j] + " ");
								hamWords.add(tempWords[j]);
							}
						}
							
					}
					
					
				}
				catch (FileNotFoundException f)
				{
					System.out.println(f.getMessage());
				}
				
			}
			
		}
		
		System.out.println("Total spam words: " + spamWords.size());
		System.out.println("Total ham words: " + hamWords.size());
		
		// Create model.txt
		System.out.println("Running smoothed probability function and writing to file...");
		ProbabilityCalculator.calcSmoothedProbability(hamWords, spamWords);
		System.out.println("Done!\nYou can't have egg bacon spam and sausage without the spam.");
		
		
	}
	*/
}

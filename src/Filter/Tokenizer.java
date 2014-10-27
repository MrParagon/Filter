package Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Tokenizer 
{
	public static boolean isWord(String word)
	{
		
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
		
		if (word.length() < 3)
			return false;
		else if (word.matches(".*\\d.*"))
			return false;
		
		for (int i = 0; i < word.length(); ++i)
		{
			if (Character.isLetter(word.charAt(i)) == false)
			{
				return false;
			}	
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		File spamFolder = new File("C:\\Users\\Yash\\Desktop\\20030228_spam_2.tar\\spam_2");
		File[] listOfSpamFiles = spamFolder.listFiles();
		
		ArrayList<String> hamWords = new ArrayList<String>();
		ArrayList<String> spamWords = new ArrayList<String>();
		
		for (int i = 0; i < 1000; ++i)
		{
			if (listOfSpamFiles[i].isFile())
			{
				File tempFile = new File(listOfSpamFiles[i].getPath());
				System.out.println(tempFile.getName());
				try 
				{
					Scanner sc = new Scanner(tempFile);
					
					while (sc.hasNext())
					{
						//if (sc.next().compareTo("Subject:") == 0)
						//{
							
							String tempLine = sc.nextLine();
							String[] tempWords = tempLine.split("\\[|\\]|\\(|\\)|!|'|,| |-|\\.|;|\"|\\?|\\{|\\}");
							
							for (int j = 0; j < tempWords.length; ++j)
							{
								tempWords[j] = tempWords[j].toLowerCase();
								
								//if (Character.isLetter(tempWords[j].charAt(0)) == false)
								//{
									
								//}
								
								if (isWord(tempWords[j]))
								{
									// System.out.print(tempWords[j] + " ");
									spamWords.add(tempWords[j]);
								}
							}
							
							//System.out.println();
							//break;
						//}
						
					}
					
					
				}
				catch (FileNotFoundException f)
				{
					System.out.println("FAIL");
				}
				
				
				// System.out.println("File " + listOfFiles[i].getPath());
			}
			
		}
		/*
		for (int i = 0; i < spamWords.size(); ++i)
		{
			System.out.println(spamWords.get(i));
		}
		*/
			
		File hamFolder = new File("C:\\Users\\Yash\\Desktop\\20030228_easy_ham_2.tar\\easy_ham_2");
		File[] listOfHamFiles = hamFolder.listFiles();
		
		for (int i = 0; i < 1000; ++i)
		{
			if (listOfHamFiles[i].isFile())
			{
				File tempFile = new File(listOfHamFiles[i].getPath());
				System.out.println(tempFile.getName());
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
							
								//if (Character.isLetter(tempWords[j].charAt(0)) == false)
								//{
									
								//}
								
							if (isWord(tempWords[j]))
							{
								// System.out.print(tempWords[j] + " ");
								hamWords.add(tempWords[j]);
							}
						}
							
							//System.out.println();
							//break;
						//}
						
					}
					
					
				}
				catch (FileNotFoundException f)
				{
					System.out.println("FAIL");
				}
				
				
				// System.out.println("File " + listOfFiles[i].getPath());
			}
			
		}
		/*
		for (int i = 0; i < hamWords.size(); ++i)
		{
			System.out.println(hamWords.get(i));
		}
		*/
		System.out.println(spamWords.size());
		System.out.println(hamWords.size());
		
		
	}
}

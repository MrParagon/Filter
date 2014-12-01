
package Filter;
import java.util.*;
import java.io.*;

public class Classifier {

	public Classifier() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
	{
		Model.load();
		System.out.println("Model Load Done");
		
		File resultFile = new File("results3.txt");
		try
		{	
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));
			
			File spamFolder = new File("20030228_spam_2.tar\\spam_2");
			File[] listOfSpamFiles = spamFolder.listFiles();
			
			for (int i = 997; i <= 1396; i++) // i <= 1396
			{
				String tempFileName = listOfSpamFiles[i].getPath().substring(listOfSpamFiles[i].getPath().lastIndexOf("\\") + 1);
				ArrayList<String> email = Tokenizer.tokenizeEmail(listOfSpamFiles[i]);
				
				String result = classifyFromModel(Model.model, email);
				
				bw.write((i - 996) + "   " + tempFileName + "   " + result);
				bw.newLine();
				
			}
			
			File hamFolder = new File("20030228_easy_ham_2.tar\\easy_ham_2");
			File[] listOfHamFiles = hamFolder.listFiles();
			
			for (int i = 999; i <= 1399; i++) // i = 1399
			{
				String tempFileName = listOfHamFiles[i].getPath().substring(listOfHamFiles[i].getPath().lastIndexOf("\\") + 1);
				ArrayList<String> email = Tokenizer.tokenizeEmail(listOfHamFiles[i]);
				
				String result = classifyFromModel(Model.model, email);
				
				bw.write((i-598) + "   " + tempFileName + "   " + result);
				bw.newLine();
				
			}
			
			bw.close();
			
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Classification done");
		
		analyseResults(resultFile);
		
		System.out.println("Analysis done");
		
	}
	
	public static String classifyFromModel(ArrayList<Word> model, ArrayList<String> email)
	{
		boolean ham;
		//ham is hypothesis, p = 0.5 since training sets of equal size were used
		double probHam = Math.log10(0.5);
		double probSpam = Math.log10(0.5);
		for (String word : email)
		{
			for (Word check : model)
			{
				if (word.equals(check.getName()))
				{
					probHam += Math.log10(check.getHamProb());
					probSpam += Math.log10(check.getSpamProb());
				}
			}
		}
		
		ham = (probHam > probSpam);
		
		if (ham)
		{
			return ("ham   " + probHam + "   " + probSpam);
		}
		else
		{
			return ("spam   " + probHam + "   " + probSpam);
		}
		
	}
	
	public static void analyseResults(File resultFile)
	{
		try
		{
			int correctHams = 0;
			int correctSpams = 0;
			int incorrectHams = 0;
			int incorrectSpams = 0;
			int lineCounter = 0;
			
			Scanner sc = new Scanner(resultFile);
			
			File analysisFile = new File("analysis3.txt");
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(analysisFile));
			
			while (sc.hasNextLine())
			{
				String tempLine = sc.nextLine();
				String[] splitLine = tempLine.split("   ");
				
				lineCounter = Integer.parseInt(splitLine[0]);
				
				if (lineCounter < 401)
				{
					bw.write(lineCounter + "   " + splitLine[1] + "   " + splitLine[2] + "   spam   ");	
					
					if (splitLine[2].compareTo("spam") == 0)
					{
						bw.write("correct");
						correctSpams++;
					}
					else
					{
						bw.write("incorrect");
						incorrectSpams++;
					}
				}
				else
				{
					bw.write(lineCounter + "   " + splitLine[1] + "   " + splitLine[2] + "   ham   ");	
					
					if (splitLine[2].compareTo("ham") == 0)
					{
						bw.write("correct");
						correctHams++;
					}
					else
					{
						bw.write("incorrect");
						incorrectHams++;
					}
				}
				
				bw.newLine();
				
			}
			
			bw.write("Correct Hams = " + correctHams + " IncorrectHams = " + incorrectHams + " Correct Spams =  " + correctSpams + " IncorrectSpams = " + incorrectSpams);
			bw.newLine();
			
			int totalCorrect = correctHams + correctSpams;
			
			bw.write(String.valueOf(totalCorrect));
			
			bw.close();
			
		}
		catch (FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
}

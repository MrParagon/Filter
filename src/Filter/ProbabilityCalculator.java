//*******************************
// COMP 472 Project Deliverable 1
// Author: Daniel Miller (6602002)
// Author: Yash Lalwani (6531857)
// 27th October 2014
//*******************************

package Filter;

import java.util.*;
import java.io.*;

public class ProbabilityCalculator 
{
	public static void calcSmoothedProbability(ArrayList<String> hamDict, ArrayList<String> spamDict)
	{
		try
		{
			
			File file = new File("model3.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));

			ArrayList<String> uniqueWords = new ArrayList<String>();
			int wordNumber = 1;
			int totalHamCount = hamDict.size();
			int totalSpamCount = spamDict.size();
			int hamCount = 0;
			int spamCount = 0;
			float hamProb = 0;
			float spamProb = 0;

			for (String str : hamDict)
			{
				if (!uniqueWords.contains(str))
				{
					uniqueWords.add(str);
				}
			}

			for (String str : spamDict)
			{
				if (!uniqueWords.contains(str))
				{
					uniqueWords.add(str);
				}
			}

			Collections.sort(uniqueWords);
			
			int vocabSize = uniqueWords.size();

			for (String word : uniqueWords)
			{
				for (String str : hamDict)
				{
					if (word.equals(str))
					{
						hamCount++;
					}
				}

				for (String str : spamDict)
				{
					if (word.equals(str))
					{
						spamCount++;
					}
				}

				hamProb = probability(hamCount, totalHamCount, vocabSize);
				spamProb = probability(spamCount, totalSpamCount, vocabSize);
				
				String out = wordNumber++ + "   " + word + "   " + hamCount + "   " + hamProb + "   " + spamCount + "   " + spamProb;
				// System.out.println(out);
				output.write(out);
				output.newLine();
				hamCount = 0;
				spamCount = 0;
			}
			
			output.close();

		}
		catch (Exception e)
		{

		}
	}
	
	public static float probability(int count, int totalCount, int vocabSize)
	{
		float result = 0;
		result = (float) (((float)count+1)/(totalCount+(float)vocabSize/2));
		return result;
	}
}

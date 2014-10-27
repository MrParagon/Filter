package Filter;
import java.util.*;

public class ProbabilityCalculator {

	public static void calcSmoothedProbability(ArrayList<String> hamDict, ArrayList<String> spamDict)
	{
		ArrayList<String> uniqueWords = new ArrayList<String>();
		int totalCount = hamDict.size();
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
			
			hamProb = probability(hamCount, totalCount, vocabSize);
			spamProb = probability(spamCount, hamCount, vocabSize);
			System.out.println(word + "   " + hamCount + "   " + hamProb + "   " + spamCount + "   " + spamProb);
		
			hamCount = 0;
			spamCount = 0;
		}
	}
	
	public static float probability(int count, int totalCount, int vocabSize)
	{
		float result = 0;
		result = (float) (((float)count+0.5)/(totalCount+(float)vocabSize/2));
		return result;
	}
}

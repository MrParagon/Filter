package Filter;
import java.util.ArrayList;

public class Classifier {

	public Classifier() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean classifyFromModel(Word[] model, ArrayList<String> email)
	{
		boolean ham;
		//ham is hypothesis, p = 0.5 since training sets of equal size were used
		double probHam = 0.5;
		double probSpam = 0.5;
		for (String word : email)
		{
			for (Word check : model)
			{
				if (word.equals(check.getName()))
				{
					probHam *= check.getHamProb();
					probSpam *= check.getSpamProb();
				}
			}
		}
		
		ham = (probHam > probSpam);
		return ham;
	}

}

package Filter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

	public static ArrayList<Word> model;
	
	public static void load()
	{
		model = new ArrayList<Word>();
		File modelFile = new File("Model.txt");
		try
		{
			Scanner sc = new Scanner(modelFile);
			while (sc.hasNext())
			{
				String tempLine = sc.nextLine();
				String[] tempAttributes = tempLine.split("   ");
				Word tempWord = new Word();
				tempWord.setName(tempAttributes[1]);
				tempWord.setHamFreq(Double.parseDouble(tempAttributes[2]));
				tempWord.setHamProb(Double.parseDouble(tempAttributes[3]));
				tempWord.setSpamFreq(Double.parseDouble(tempAttributes[4]));
				tempWord.setSpamProb(Double.parseDouble(tempAttributes[5]));
				model.add(tempWord);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

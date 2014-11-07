package Filter;

public class Word 
{
	private String name = "";
	private double hamFreq = 0;
	private double hamProb = 0;
	private double spamFreq = 0;
	private double spamProb = 0;
	
	public String getName()
	{
		return name;
	}
	
	public double getHamFreq()
	{
		return hamFreq;
	}
	
	public double getHamProb()
	{
		return hamProb;
	}
	
	public double getSpamFreq()
	{
		return spamFreq;
	}
	
	public double getSpamProb()
	{
		return spamProb;
	}
	
	public void setHamFreq(double hF)
	{
		hamFreq = hF;
	}
	
	public void setHamProb(double hP)
	{
		hamProb = hP;
	}
	
	public void setSpamFreq(double sF)
	{	
		spamFreq = sF;
	}	
	
	public void setSpamProb(double sP)
	{
		spamProb = sP;
	}

	public String toString()
	{
		return (name + "   " + hamFreq + "   " + hamProb + "   " + spamFreq + "   " + spamProb);
	}
	
}

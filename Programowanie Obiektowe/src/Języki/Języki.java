package J�zyki;

public enum J�zyki 
{
	POLSKI(0),
	ENGLISH(1);

	private int numer;
	
	public int getNumer() 
	{
		return this.numer;
	}
	
	private J�zyki(int numer) 
	{
		this.numer = numer;
	}
}

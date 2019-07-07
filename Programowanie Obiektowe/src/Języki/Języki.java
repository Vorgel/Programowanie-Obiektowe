package Jêzyki;

public enum Jêzyki 
{
	POLSKI(0),
	ENGLISH(1);

	private int numer;
	
	public int getNumer() 
	{
		return this.numer;
	}
	
	private Jêzyki(int numer) 
	{
		this.numer = numer;
	}
}

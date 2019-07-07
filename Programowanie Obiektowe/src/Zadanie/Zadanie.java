package Zadanie;
import Resource.Resource;

public class Zadanie implements Comparable<Zadanie>, Resource
{
	// Argumenty: Dlugosc zadania, start zadania, deadline
	private int dlugosc=0;
	private int start=0;
	private int deadline=0;
	private String imie="";
	
	public String getImie()
	{
		return this.imie;
	}
	
	public int getDlugosc()
	{
		return this.dlugosc;
	}
	
	public int getStart()
	{
		return this.start;
	}
	
	public int getDeadline()
	{
		return deadline;
	}
	
	public String toString()
	{
		return "Dlugosc: " + this.getDlugosc() + ", Start: " + this.getStart() + ", Deadline: " + this.getDeadline();
	}
	
	public int compareTo(Zadanie z1)
	{		
		if (((Integer)this.start).compareTo( z1.getStart()) == 0)  // Kiedy ten sam start maja dwa zadania
		{
			return ((Integer)this.getDlugosc()).compareTo(z1.getDlugosc()); // Daje mniejsze zadanie

		}
		else
			return ((Integer)this.start).compareTo(z1.getStart());	// jak sa rozne starty zwraca wczesniejszy
	}
    
	public Zadanie(int dlugosc, int start, int deadline, String imie)
	{
		this.imie = imie;
		this.dlugosc = dlugosc;
		this.start = start;
		this.deadline = deadline;
		
		//System.out.println("Dodano zadanie " + this.getImie());
	}
}
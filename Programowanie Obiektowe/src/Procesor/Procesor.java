package Procesor;

import Zadanie.Zadanie;
import Wyjatki.BladDeadline;
import java.util.PriorityQueue;
import Resource.Resource;

public class Procesor implements Resource
{
	private String imie;
	private int moc;
	private boolean dostepnosc = true;
	private PriorityQueue<Zadanie> Procesor_historia;
	private int ZajetyDo;
	
	public int getMoc()
	{
		return this.moc;
	}
	
	public String getImie()
	{
		return this.imie;
	}
	
	public boolean getDostepnosc()
	{
		return this.dostepnosc;
	}
	
	public int getZajetyDo()
	{
		return this.ZajetyDo;
	}
	
	public String toString()
	{
		return "Procesor " + this.getImie() + ", moc: " + this.getMoc() + " stan: " + this.getDostepnosc();
	}
	
	public PriorityQueue<Zadanie> getHistoria()
	{
		return this.Procesor_historia;
	}
	
	public void PokazHistorie()
	{
		String historia="";
		for(int i=0; i<getHistoria().size(); i++)
		{
			historia+= getHistoria().poll().getImie();
		}
		System.out.println(historia);
	}
	
	public int ObliczCzasZadania(Zadanie z1) 
	{
		return z1.getDlugosc()/this.getMoc();
	}
	
	public boolean CzyMozliwe(Zadanie z1, int czas) 
	{
		if((czas+ObliczCzasZadania(z1)) < z1.getDeadline())
			return true;
		else
			return false;
	}
	
	public void ZakonczZadanie()
	{
		this.dostepnosc = true;
	}
	
	public void WykonajZadanie(Zadanie z1, int czas) throws BladDeadline
	{
		if(CzyMozliwe(z1,czas))
		{
			this.dostepnosc = false;
			
			this.ZajetyDo = czas+ObliczCzasZadania(z1);
			
			this.getHistoria().add(z1);
		}
		else
		{
			throw new BladDeadline("Deadline error");
		}
		
	}
	
	public void zresetuj()
	{
		this.dostepnosc=true;
		this.Procesor_historia.clear();
		this.ZajetyDo=0;		
	}
	
	public Procesor(int moc, String imie)
	{
		this.moc = moc;
		this.Procesor_historia = new PriorityQueue<Zadanie>();
		this.imie = imie;
		//System.out.println("Dodano procesor " + this.getImie());
	}
}
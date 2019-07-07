package Main;

import Zadanie.Zadanie;
import Procesor.Procesor;
import Wyjatki.BladDeadline;
import Jêzyki.*;

import java.util.Random;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<Zadanie> zadania = new ArrayList<Zadanie>();
		ArrayList<Procesor> procesory = new ArrayList<Procesor>();
		
        Wiadomosci wiadomosc = new Wiadomosci(Jêzyki.POLSKI);

		Random generator = new Random();
		
		// -------------- Generowanie losowej ilosci losowych zadan i losowa ilosc procesorow o losowej mocy ---------------------
		
		final int LiczbaZadan = generator.nextInt(20)+1; // Generowanie liczby zadan
		final int LiczbaProcesorow = generator.nextInt(2)+1; // Generowanie liczby procesorow
		
		System.out.print(wiadomosc.getWiadomosc(TypyWiadomosci.Generator_Zadania) + LiczbaZadan + ", ");
		System.out.println(wiadomosc.getWiadomosc(TypyWiadomosci.Generator_Procesory) + LiczbaProcesorow);
		
		for(int i=0; i<LiczbaZadan; i++) // Generowanie zadan
		{
			String imie = "z"+i; 
			int Rozmiar = generator.nextInt(10)+1; //Zeby nie wypadl rozmiar 0
			int Start = generator.nextInt(10);
			int Deadline = generator.nextInt(10) + Start + Rozmiar;
			Zadanie nowe = new Zadanie(Rozmiar,Start,Deadline, imie);
			zadania.add(nowe);
		}
		
		for(int i=0; i<LiczbaProcesorow; i++)
		{
			int moc = generator.nextInt(3)+1; // Nie moze wypasc 0
			String imie = "p"+i;
			
			Procesor nowy = new Procesor(moc,imie);
			procesory.add(nowy);
		}
		
		PriorityQueue<Zadanie> ZadaniaDoWykonania = new PriorityQueue<Zadanie>();  //wrzucenie tablicy zadan do kolejki
				
		// Dodawanie zadan do kolejki priorytetowej
		for(int i=0; i<zadania.size(); i++)
		{
			ZadaniaDoWykonania.add(zadania.get(i));
		}
		
		//System.out.println("Rozmiar kolejki priorytetowej: " + ZadaniaDoWykonania.size());
		
		
		// -----------------------------
		// Wlaczanie Timera ktory jest podstawa zadania, metoda run wykonuje sie co sekunde udajac taktowanie
		Timer globalTimer = new Timer();
		
		globalTimer.scheduleAtFixedRate(new TimerTask()
		{
			private int czas=0;
			private int AktywneProcesory = 1;
			String zadanie_blad="";
			public int getCzas()
			{
				return czas;
			}
			 
			public void run()
			{	
				System.out.println(" -- " + getCzas() + wiadomosc.getWiadomosc(TypyWiadomosci.Zegar));
				
				if(!ZadaniaDoWykonania.isEmpty()) // W przypadku gdy s¹ jeszcze jakieœ zadania do przydzielenia
				{
					for(int p=0; p< AktywneProcesory; p++) //pêtla po procesorach 
					{
						if(procesory.get(p).getDostepnosc() == false && procesory.get(p).getZajetyDo() <= getCzas()) //czy jakies procesory wlasnie skonczyly dzialanie?	
						{
							procesory.get(p).ZakonczZadanie();
							
							System.out.println(procesory.get(p).getImie() + wiadomosc.getWiadomosc(TypyWiadomosci.Procesy_Zakonczenie));
						}
						
						if(procesory.get(p).getDostepnosc() == true && !ZadaniaDoWykonania.isEmpty()) // Jezeli procesor jest wolny i ma mozliwosc wykonania zadania z gory
						{
							try
							{
								//System.out.println("Mozliwe do zrobienia zadanie: " + ZadaniaDoWykonania.peek().getImie());
								zadanie_blad = ZadaniaDoWykonania.peek().getImie();
								procesory.get(p).WykonajZadanie(ZadaniaDoWykonania.poll(), getCzas());
								System.out.println("Procesor " + procesory.get(p).getImie() + wiadomosc.getWiadomosc(TypyWiadomosci.Procesy_Rozpoczecie) + procesory.get(p).getZajetyDo() );
							}
							catch(BladDeadline error)
							{
								System.out.println( zadanie_blad + wiadomosc.getWiadomosc(TypyWiadomosci.Wyj¹tek));
								
								if(AktywneProcesory < procesory.size())
								{
									for(int errorp=0; errorp< AktywneProcesory; errorp++)
									{
										procesory.get(errorp).zresetuj();
									}
									p=AktywneProcesory;

									AktywneProcesory++; // Dodanie kolejnego procesora
									
									czas=-1; // Czas doda jedna sekunde pod koniec tej petli i wyjdzie 0
									
									ZadaniaDoWykonania.clear();
									
									for(int i=0; i<zadania.size(); i++)
									{
										ZadaniaDoWykonania.add(zadania.get(i));
									}
									
									System.out.println(wiadomosc.getWiadomosc(TypyWiadomosci.Nowy_Poczatek));
								}
								else
								{
									globalTimer.cancel();
									System.out.println(wiadomosc.getWiadomosc(TypyWiadomosci.Koniec_Niewykonane));
								}
								
							}
						}						
					}
				}
				else // Gdy nie ma zadnych zadan do przydzielenia
				{
					boolean wszystkienieaktywne = true; //Sprawdzanie czy s¹ jeszcze jakies aktywne procesory
					
					for(int testp=0; testp<AktywneProcesory;testp++)
					{
						if(procesory.get(testp).getDostepnosc() == false)
						{
							wszystkienieaktywne = false;
						}
					}
					
					if(wszystkienieaktywne==false) //Jeœli s¹ jeszcze jakies aktywne, zobacz, czy zadanie sie zakonczylo
					{
						System.out.println(wiadomosc.getWiadomosc(TypyWiadomosci.Procesy_Aktywne));

						for(int p=0; p< AktywneProcesory; p++) //pêtla po procesorach 
						{
							if(procesory.get(p).getDostepnosc() == false && procesory.get(p).getZajetyDo() <= getCzas()) //czy jakies procesory wlasnie skonczyly dzialanie?	
							{
								procesory.get(p).ZakonczZadanie();
								System.out.println(procesory.get(p).getImie() + wiadomosc.getWiadomosc(TypyWiadomosci.Procesy_Zakonczenie));
							}
						}
					}
					else // Jezeli juz nie ma zadnych aktywnych procesorów
					{
						System.out.println(wiadomosc.getWiadomosc(TypyWiadomosci.Koniec_Wykonane));
						
						  /** for(int i=0; i<AktywneProcesory; i++) 
						   {
	                           System.out.println("Procesor " + procesory.get(i).getImie());
	                           procesory.get(i).PokazHistorie();
	                       }
	                       */
						   globalTimer.cancel();
					}
				}
				czas++;
			}
		}, 0, 1000);
	}
}
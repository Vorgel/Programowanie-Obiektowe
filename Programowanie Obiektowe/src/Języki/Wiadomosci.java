package J�zyki;

import java.util.HashMap;
import java.util.ArrayList;

public class Wiadomosci 
{
	private J�zyki j�zyk;
    private HashMap<TypyWiadomosci, ArrayList<String>> t�umaczenia;
    
    public Wiadomosci(J�zyki j�zyk)
    {
    	this.j�zyk = j�zyk;
    	this.t�umaczenia = new HashMap<TypyWiadomosci, ArrayList<String>>();
    	
        ArrayList<String> Generator_Procesory = new ArrayList<String>();
        Generator_Procesory.add("Liczba wygenerowanych procesor�w: ");
        Generator_Procesory.add("Number of generated CPU: ");
        t�umaczenia.put(TypyWiadomosci.Generator_Procesory, Generator_Procesory);
        
        ArrayList<String> Generator_Zadania = new ArrayList<String>();
        Generator_Zadania.add("Liczba wygenerowanych zadan: ");
        Generator_Zadania.add("Number of generated tasks: ");
        t�umaczenia.put(TypyWiadomosci.Generator_Zadania, Generator_Zadania);
        
        ArrayList<String> Zegar = new ArrayList<String>();
        Zegar.add(" sekunda dzialania systemu --");
        Zegar.add(" second --");
        t�umaczenia.put(TypyWiadomosci.Zegar, Zegar);
        
        ArrayList<String> Procesy_Aktywne = new ArrayList<String>();
        Procesy_Aktywne.add("Niektore procesy sa nadal aktywne.");
        Procesy_Aktywne.add("Some processors are still busy.");
        t�umaczenia.put(TypyWiadomosci.Procesy_Aktywne, Procesy_Aktywne);
        
        ArrayList<String> Procesy_Zakonczenie = new ArrayList<String>();
        Procesy_Zakonczenie.add(" zakonczyl prace nad zadaniem.");
        Procesy_Zakonczenie.add(" ended processing the task.");
        t�umaczenia.put(TypyWiadomosci.Procesy_Zakonczenie, Procesy_Zakonczenie);
    
        ArrayList<String> Procesy_Rozpoczecie = new ArrayList<String>();
        Procesy_Rozpoczecie.add(" zaczal wykonywac zadanie. Bedzie je robil az do ");
        Procesy_Rozpoczecie.add(" started processing the task. It will do it untill ");
        t�umaczenia.put(TypyWiadomosci.Procesy_Rozpoczecie, Procesy_Rozpoczecie);
        
        ArrayList<String> Wyj�tek = new ArrayList<String>();
        Wyj�tek.add(" spowodowa�o wyrzucenie wyj�tku.");
        Wyj�tek.add(" threw an exception.");
        t�umaczenia.put(TypyWiadomosci.Wyj�tek, Wyj�tek);
        
        ArrayList<String> Nowy_Poczatek = new ArrayList<String>();
        Nowy_Poczatek.add(" \n###### Dodanie Kolejnego procesora, rozpoczecie dzialania programu od poczatku. ######\n");
        Nowy_Poczatek.add(" \n###### New processor added, program will now restart ######\n");
        t�umaczenia.put(TypyWiadomosci.Nowy_Poczatek, Nowy_Poczatek);
        
        ArrayList<String> Koniec_Wykonane = new ArrayList<String>();
        Koniec_Wykonane.add("Wszystkie zadania zosta�y wykonane.");
        Koniec_Wykonane.add("All tasks completed.");
        t�umaczenia.put(TypyWiadomosci.Koniec_Wykonane, Koniec_Wykonane);
        
        ArrayList<String> Koniec_Niewykonane = new ArrayList<String>();
        Koniec_Niewykonane.add("Zadania niemo�liwe do wykonania.");
        Koniec_Niewykonane.add("Tasks are impossible to complete.");
        t�umaczenia.put(TypyWiadomosci.Koniec_Niewykonane, Koniec_Niewykonane);
     }
    
	    public String getWiadomosc(TypyWiadomosci typ) 
	    {
	        return this.t�umaczenia.get(typ).get(this.j�zyk.getNumer());
	    }

}

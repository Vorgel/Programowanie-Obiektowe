package Jêzyki;

import java.util.HashMap;
import java.util.ArrayList;

public class Wiadomosci 
{
	private Jêzyki jêzyk;
    private HashMap<TypyWiadomosci, ArrayList<String>> t³umaczenia;
    
    public Wiadomosci(Jêzyki jêzyk)
    {
    	this.jêzyk = jêzyk;
    	this.t³umaczenia = new HashMap<TypyWiadomosci, ArrayList<String>>();
    	
        ArrayList<String> Generator_Procesory = new ArrayList<String>();
        Generator_Procesory.add("Liczba wygenerowanych procesorów: ");
        Generator_Procesory.add("Number of generated CPU: ");
        t³umaczenia.put(TypyWiadomosci.Generator_Procesory, Generator_Procesory);
        
        ArrayList<String> Generator_Zadania = new ArrayList<String>();
        Generator_Zadania.add("Liczba wygenerowanych zadan: ");
        Generator_Zadania.add("Number of generated tasks: ");
        t³umaczenia.put(TypyWiadomosci.Generator_Zadania, Generator_Zadania);
        
        ArrayList<String> Zegar = new ArrayList<String>();
        Zegar.add(" sekunda dzialania systemu --");
        Zegar.add(" second --");
        t³umaczenia.put(TypyWiadomosci.Zegar, Zegar);
        
        ArrayList<String> Procesy_Aktywne = new ArrayList<String>();
        Procesy_Aktywne.add("Niektore procesy sa nadal aktywne.");
        Procesy_Aktywne.add("Some processors are still busy.");
        t³umaczenia.put(TypyWiadomosci.Procesy_Aktywne, Procesy_Aktywne);
        
        ArrayList<String> Procesy_Zakonczenie = new ArrayList<String>();
        Procesy_Zakonczenie.add(" zakonczyl prace nad zadaniem.");
        Procesy_Zakonczenie.add(" ended processing the task.");
        t³umaczenia.put(TypyWiadomosci.Procesy_Zakonczenie, Procesy_Zakonczenie);
    
        ArrayList<String> Procesy_Rozpoczecie = new ArrayList<String>();
        Procesy_Rozpoczecie.add(" zaczal wykonywac zadanie. Bedzie je robil az do ");
        Procesy_Rozpoczecie.add(" started processing the task. It will do it untill ");
        t³umaczenia.put(TypyWiadomosci.Procesy_Rozpoczecie, Procesy_Rozpoczecie);
        
        ArrayList<String> Wyj¹tek = new ArrayList<String>();
        Wyj¹tek.add(" spowodowa³o wyrzucenie wyj¹tku.");
        Wyj¹tek.add(" threw an exception.");
        t³umaczenia.put(TypyWiadomosci.Wyj¹tek, Wyj¹tek);
        
        ArrayList<String> Nowy_Poczatek = new ArrayList<String>();
        Nowy_Poczatek.add(" \n###### Dodanie Kolejnego procesora, rozpoczecie dzialania programu od poczatku. ######\n");
        Nowy_Poczatek.add(" \n###### New processor added, program will now restart ######\n");
        t³umaczenia.put(TypyWiadomosci.Nowy_Poczatek, Nowy_Poczatek);
        
        ArrayList<String> Koniec_Wykonane = new ArrayList<String>();
        Koniec_Wykonane.add("Wszystkie zadania zosta³y wykonane.");
        Koniec_Wykonane.add("All tasks completed.");
        t³umaczenia.put(TypyWiadomosci.Koniec_Wykonane, Koniec_Wykonane);
        
        ArrayList<String> Koniec_Niewykonane = new ArrayList<String>();
        Koniec_Niewykonane.add("Zadania niemo¿liwe do wykonania.");
        Koniec_Niewykonane.add("Tasks are impossible to complete.");
        t³umaczenia.put(TypyWiadomosci.Koniec_Niewykonane, Koniec_Niewykonane);
     }
    
	    public String getWiadomosc(TypyWiadomosci typ) 
	    {
	        return this.t³umaczenia.get(typ).get(this.jêzyk.getNumer());
	    }

}

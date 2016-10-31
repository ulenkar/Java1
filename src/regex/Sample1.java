package regex;

import java.util.Scanner;

public class Sample1 {

  public static void main(String[] args) {
    
	  // Pobranie tekstu wejœciowego
	  Scanner s = new Scanner(System.in);
	  System.out.println("Podaj tekst: ");
	  String txt = s.nextLine();
	
	  // Sprawdzanie
	  Rege r1 = new Rege(txt);
	  
	  System.out.println();
	  System.out.println(r1.checkNumbers());
	  System.out.println(r1.findNumbers());
	  
	  System.out.println();
	  System.out.println("Liczba wyró¿nionych s³ów: " + r1.findWords().length);
	    for (String w : r1.findWords()) {
	      System.out.println(w);
	    }
	  
	  // Zamkniêcie skanera
	  s.close();
	  ;
	  

  }

}
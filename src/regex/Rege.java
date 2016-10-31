package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rege {

	String txt; 
	
	public Rege(String s) {
	txt = s;	
	}
	
	public String checkNumbers(){
	// Wzorzec: jedno lub wi�cej wyst�pie� dowolnej cyfry
    String regex = "[0-9]+";

    // Kompilacja wzorca
    Pattern pattern = Pattern.compile(regex);
    
    // Uzyskanie matchera
    Matcher matcher = pattern.matcher(txt);

    // Czy tekst pasuje do wzorca?
    return "Tekst: " + txt + (matcher.matches() ? " " : " NIE ") + "sk�ada si� tylko z cyfr";
}
	
	
	public String findNumbers(){
	// Wzorzec: jedno lub wi�cej wyst�pie� dowolnej cyfry
    String regex = "[0-9]+";

    // Kompilacja wzorca
    Pattern pattern = Pattern.compile(regex);
    
    // Uzyskanie matchera
    Matcher matcher = pattern.matcher(txt);

    //Szukanie pod�a�cuch�w
    String result = "";
    
    while (matcher.find()) {
        result += "\nZnaleziono cyfry: '" + 
          matcher.group() + "'" +                // group() zwraca ostatni dopasowany tekst 
          "\nod pozycji " + matcher.start() +    // start() zwraca jego poczatkow� pozycj�
          "\ndo pozycji " + matcher.end();       // end() zwraca pozycj� po ostatnim dopasowanym znaku
      }
      
      if (result.equals("")) result = "Nie znaleziono �adnego podnapisu " +
                                      "sk�adaj�cego si� z ci�gu cyfr";
    
    // Czy tekst pasuje do wzorca?
    return result;
	}
	
	public String[] findWords(){
		// Wzorzec: jedno lub wi�cej wyst�pie� dowolnej cyfry
	    //String regex = "[\\s\\p{Punct}]+";
	    String regex = "[\\s]+";
		//String regex = "[\\w]+";
		
	    // Kompilacja wzorca
	    Pattern pattern = Pattern.compile(regex);
	    
	    // Uzyskanie matchera
	    Matcher matcher = pattern.matcher(txt);

	    //Wynikowa tablica ze s�owami
	    String[] words = pattern.split(txt);     // inaczej wo�ane ni�  split() z klasy String
	    
	    // Czy tekst pasuje do wzorca?
	    return words;
		}
	
	
}

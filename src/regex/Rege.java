package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rege {

	String txt; 
	
	public Rege(String s) {
	txt = s;	
	}
	
	public String checkNumbers(){
	// Wzorzec: jedno lub wiêcej wyst¹pieñ dowolnej cyfry
    String regex = "[0-9]+";

    // Kompilacja wzorca
    Pattern pattern = Pattern.compile(regex);
    
    // Uzyskanie matchera
    Matcher matcher = pattern.matcher(txt);

    // Czy tekst pasuje do wzorca?
    return "Tekst: " + txt + (matcher.matches() ? " " : " NIE ") + "sk³ada siê tylko z cyfr";
}
	
	
	public String findNumbers(){
	// Wzorzec: jedno lub wiêcej wyst¹pieñ dowolnej cyfry
    String regex = "[0-9]+";

    // Kompilacja wzorca
    Pattern pattern = Pattern.compile(regex);
    
    // Uzyskanie matchera
    Matcher matcher = pattern.matcher(txt);

    //Szukanie pod³añcuchów
    String result = "";
    
    while (matcher.find()) {
        result += "\nZnaleziono cyfry: '" + 
          matcher.group() + "'" +                // group() zwraca ostatni dopasowany tekst 
          "\nod pozycji " + matcher.start() +    // start() zwraca jego poczatkow¹ pozycjê
          "\ndo pozycji " + matcher.end();       // end() zwraca pozycjê po ostatnim dopasowanym znaku
      }
      
      if (result.equals("")) result = "Nie znaleziono ¿adnego podnapisu " +
                                      "sk³adaj¹cego siê z ci¹gu cyfr";
    
    // Czy tekst pasuje do wzorca?
    return result;
	}
	
	public String[] findWords(){
		// Wzorzec: jedno lub wiêcej wyst¹pieñ dowolnej cyfry
	    //String regex = "[\\s\\p{Punct}]+";
	    String regex = "[\\s]+";
		//String regex = "[\\w]+";
		
	    // Kompilacja wzorca
	    Pattern pattern = Pattern.compile(regex);
	    
	    // Uzyskanie matchera
	    Matcher matcher = pattern.matcher(txt);

	    //Wynikowa tablica ze s³owami
	    String[] words = pattern.split(txt);     // inaczej wo³ane ni¿  split() z klasy String
	    
	    // Czy tekst pasuje do wzorca?
	    return words;
		}
	
	
}

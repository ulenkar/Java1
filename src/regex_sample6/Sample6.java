package regex_sample6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample6 {

	  public static void main(String[] args) throws Exception {
		    
		    // Zast�pimy w tek�cie wszystkie napisy:
		    // (liczbaCa�kowita1:liczbaCa�kowita2)
		    // na napisy:
		    // [liczbaCa�kowita2:liczbaCa�kowita1]
		    // czyli zmienimy nawiasy na kwadratowe i przestawimy miejscami liczby
		   
		    // Wzorzec:
		    // nawias,liczba,dwukropek,liczba, nawias - uwaga nawias jest znakiem specjalnym - uzyjemy uko�nika
		    // zastosujemy dwie grupy: dla liczby1 i liczby2 
		    String regex = "\\((\\d):(\\d)\\)";
		    Pattern pattern = Pattern.compile(regex);
		    
		    String txt = "tekst 1 (ale) (2) (1:2) wo�anie f() (3:4) (8:9)(10:11)";  
		    Matcher matcher = pattern.matcher(txt);
		    
		    // W wywo�aniu metody replaceAll (i replaceFirst) podaj�c tekst zast�puj�cy
		    // mo�emy  odwo�ywa� si� do zawarto�ci grup wzorca.
		    // Wtedy tekst zast�puj�cy b�dzie zawiera� zawarto�� grupy z dopasowania wyra�enia.
		    // W tek�cie zast�puj�cyn stosujemy znak $ z nast�puj�cym po nim numerem grupy 
		    // (a wi�c znak $ jest w tym kontek�cie zarezerwowany!)
		    // W naszym przyk�adzie mamy dwie grupy: pierwsz� liczb� i drug� liczb�
		    // oznaczamy je $1 i $2
		    
		    // zamiana nawias�w i przestawienie liczb
		    String newTxt = matcher.replaceAll("[$2:$1]");
		    
		    System.out.println("Tekst przed zamian�:");
		    System.out.println(txt);
		    System.out.println("Tekst po zamianie:");
		    System.out.println(newTxt);
		  }
}

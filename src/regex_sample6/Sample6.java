package regex_sample6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample6 {

	  public static void main(String[] args) throws Exception {
		    
		    // Zast¹pimy w tekœcie wszystkie napisy:
		    // (liczbaCa³kowita1:liczbaCa³kowita2)
		    // na napisy:
		    // [liczbaCa³kowita2:liczbaCa³kowita1]
		    // czyli zmienimy nawiasy na kwadratowe i przestawimy miejscami liczby
		   
		    // Wzorzec:
		    // nawias,liczba,dwukropek,liczba, nawias - uwaga nawias jest znakiem specjalnym - uzyjemy ukoœnika
		    // zastosujemy dwie grupy: dla liczby1 i liczby2 
		    String regex = "\\((\\d):(\\d)\\)";
		    Pattern pattern = Pattern.compile(regex);
		    
		    String txt = "tekst 1 (ale) (2) (1:2) wo³anie f() (3:4) (8:9)(10:11)";  
		    Matcher matcher = pattern.matcher(txt);
		    
		    // W wywo³aniu metody replaceAll (i replaceFirst) podaj¹c tekst zastêpuj¹cy
		    // mo¿emy  odwo³ywaæ siê do zawartoœci grup wzorca.
		    // Wtedy tekst zastêpuj¹cy bêdzie zawiera³ zawartoœæ grupy z dopasowania wyra¿enia.
		    // W tekœcie zastêpuj¹cyn stosujemy znak $ z nastêpuj¹cym po nim numerem grupy 
		    // (a wiêc znak $ jest w tym kontekœcie zarezerwowany!)
		    // W naszym przyk³adzie mamy dwie grupy: pierwsz¹ liczbê i drug¹ liczbê
		    // oznaczamy je $1 i $2
		    
		    // zamiana nawiasów i przestawienie liczb
		    String newTxt = matcher.replaceAll("[$2:$1]");
		    
		    System.out.println("Tekst przed zamian¹:");
		    System.out.println(txt);
		    System.out.println("Tekst po zamianie:");
		    System.out.println(newTxt);
		  }
}

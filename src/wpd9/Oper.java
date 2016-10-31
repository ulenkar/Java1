package wpd9;

import java.util.*;
import static javax.swing.JOptionPane.*;

public class Oper {

  public static void main(String[] args) {

    String normalQuest = "Liczba1 op Liczba2",     // normalny komunikat
           errorQuest = "Wadliwe dane. Popraw.\n", // komunikat w przypadku b³êdu
           quest = normalQuest;

    String expr = "";                              // wyra¿enie do obliczenia 

    while ((expr = showInputDialog(quest, expr)) != null) {

        int res;
        try {
          StringTokenizer st = new StringTokenizer(expr);
          int num1 = Integer.parseInt(st.nextToken());
          String sop = st.nextToken();
          int num2 = Integer.parseInt(st.nextToken());
          
          if (sop.length() != 1 || st.hasMoreTokens()) 
            throw new IllegalArgumentException();

      switch (sop.charAt(0)) {
        case '+' : res = num1 + num2; break;
        case '-' : res = num1 - num2; break;
        case '*' : res = num1 * num2; break;
        case '/' : res = num1 / num2; break;
        default: throw new IllegalArgumentException();
      }
      } catch (Exception exc) {
          quest = errorQuest;
          continue; 
      }
      showMessageDialog(null, "Wynik = " + res);
      quest = normalQuest;
      expr = "";            // w kolejnym dialogu inicjalny tekst ma byæ pusty
    }

  }
    

}

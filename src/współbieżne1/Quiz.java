package wsp�bie�ne1;

import javax.swing.*;

public class Quiz {

  // Stolice do odgadni�cia
  private final String[] CAP = {"Praga", "Bratys�awa", "Moskwa",
                                "Berlin", "Kij�w", "Wilno", "Mi�sk" };

  // Czy stolica by�a ju� podana ?
  private boolean[] entered = new boolean[CAP.length];

  public Quiz() {

    int n = CAP.length;

    JOptionPane.showMessageDialog(null, "Podaj stolice l�dowych s�siad�w Polski");
    String askMsg = "Wpisz kolejn� stolic�:" ;

    int count = 0;  // ile podano prawid�owych odpowiedzi

    // Uruchomienie w�tku zliczaj�cego i pokazuj�cego up�ywaj�cy czas
    Timer tm = new Timer();
    tm.start();
    Minutnik min = new Minutnik();
    min.start();

    while (count < CAP.length) { // dop�ki nie podano wszystkich stolic
      String input = JOptionPane.showInputDialog("Odpowiedzi: " + count + '/' + n +
                                                  '\n' + askMsg);
      if (input == null) break;
      if (isOk(input)) count++;  // je�eli ta odpowied� prawid�owa
    }
    System.exit(0);
  }

  // Czy odpowied� jest prawid�owa i czy jej wcze�niej nie podano?

  private boolean isOk(String s) {
    for (int i=0; i < CAP.length; i++) {
      if (s.equalsIgnoreCase(CAP[i]) && !entered[i])
         return (entered[i] = true);
    }
    return false;
  }
}
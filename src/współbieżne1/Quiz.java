package wspó³bie¿ne1;

import javax.swing.*;

public class Quiz {

  // Stolice do odgadniêcia
  private final String[] CAP = {"Praga", "Bratys³awa", "Moskwa",
                                "Berlin", "Kijów", "Wilno", "Miñsk" };

  // Czy stolica by³a ju¿ podana ?
  private boolean[] entered = new boolean[CAP.length];

  public Quiz() {

    int n = CAP.length;

    JOptionPane.showMessageDialog(null, "Podaj stolice l¹dowych s¹siadów Polski");
    String askMsg = "Wpisz kolejn¹ stolicê:" ;

    int count = 0;  // ile podano prawid³owych odpowiedzi

    // Uruchomienie w¹tku zliczaj¹cego i pokazuj¹cego up³ywaj¹cy czas
    Timer tm = new Timer();
    tm.start();
    Minutnik min = new Minutnik();
    min.start();

    while (count < CAP.length) { // dopóki nie podano wszystkich stolic
      String input = JOptionPane.showInputDialog("Odpowiedzi: " + count + '/' + n +
                                                  '\n' + askMsg);
      if (input == null) break;
      if (isOk(input)) count++;  // je¿eli ta odpowiedŸ prawid³owa
    }
    System.exit(0);
  }

  // Czy odpowiedŸ jest prawid³owa i czy jej wczeœniej nie podano?

  private boolean isOk(String s) {
    for (int i=0; i < CAP.length; i++) {
      if (s.equalsIgnoreCase(CAP[i]) && !entered[i])
         return (entered[i] = true);
    }
    return false;
  }
}
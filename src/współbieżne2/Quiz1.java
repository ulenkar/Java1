package wspó³bie¿ne2;

import javax.swing.*;

public class Quiz1 extends Thread {

  private final String[] CAP = {"Praga", "Bratys³awa", "Moskwa",
                                "Berlin", "Kijów", "Wilno", "Miñsk" };

  private boolean[] entered = new boolean[CAP.length];

  private int time = 0; // licznik czasu

  public Quiz1() {
    int n = CAP.length;

    JOptionPane.showMessageDialog(null, "Podaj stolice s¹siaduj¹cych krajów");
    String askMsg = "Wpisz kolejn¹ stolicê:" ;
    int count = 0;

    // Uruchomienie w¹tku zliczania czasu
    start();

    while (count < CAP.length) {
      String input = JOptionPane.showInputDialog("Odpowiedzi: " + count + '/' + n +
                                                 ".   Czas: " + getTime() + '\n' +
                                                 askMsg);
      if (input == null) break;
      if (isOk(input)) count++;
    }
    JOptionPane.showMessageDialog(null, "Czas wpisywania: " + getTime());
    System.exit(0);
  }

  // Kod który wykonuje siê w odrêbnym w¹tku
  public void run() {
    while (true) {
      try {
        this.sleep(1000);
      } catch(InterruptedException exc) {
          System.out.println("W¹tek zliczania czasu zosta³ przerwany.");
          return;
      }
      time++;
      System.out.println(getTime());
    }
  }

  // Metoda zwracaj¹ca bie¿¹cy czas w formie min : sek
  private String getTime() {
    int minutes = time/60;
    int sec = time%60;
    return minutes + ":" + sec;
  }

  private boolean isOk(String s) {
    for (int i=0; i < CAP.length; i++) {
      if (s.equalsIgnoreCase(CAP[i]) && !entered[i])
         return (entered[i] = true);
    }
    return false;
  }


  public static void main(String args[]) {
    new Quiz1();
  }
}

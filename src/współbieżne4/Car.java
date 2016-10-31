package wsp�bie�ne4;

import javax.swing.*;
import java.awt.event.*;

public class Car extends Vehicle  {

  private String nrRej;
  private int tankCapacity;
  private int fuel;

  // Klasa wewn�trzna. Prywatna - nie mo�emy jej u�y� poza klas� Car
  // Dostarcza definicji metody actionPerformed(...), wywo�ywanej przez Timer

  
  
   private class FuelConsume implements ActionListener {

     public void actionPerformed(ActionEvent e)  {
       if (getState() != "MOVING") fuelTimer.stop();  // nie zu�ywaj paliwa, gdy nie jedziesz 
       else  {                                      
         fuel -= 1;               // odwolanie do pryw. sk�adowej klasy otaczaj�cej
         if (fuel == 0) stop();
       }
     }
   }

  // Timer b�dzie co sekund� wywo�ywa� metod� actionPerformed(...)
  // z klasy obiektu podanego jako drugi argument konstruktora
  // ( obiekt klasy FuelConsume)
  // w rezultacie co sekunde czasu komputerowego bedzie zuzywany 1 l paliwa

    private Timer fuelTimer = new Timer(1000, new FuelConsume());

    public Car(String nr, Person owner, int w, int h, int l,
               int weight, int tankCap)  {
        super(owner, w, h, l, weight);
        nrRej = nr;
        tankCapacity = tankCap;
    }

    public void fill(int amount)  {
      if (getState() == "MOVING")
          System.out.println("Nie moge tankowac w ruchu");
      else  {
        fuel += amount;
        if (fuel > tankCapacity) fuel = tankCapacity;
      }
    }

    public void start()  {
      if (fuel > 0)   {
          super.start();
          fuelTimer.start();     // start Timera
      }
      else System.out.println("Brak benzyny");
    }

    public void stop()  {
      super.stop();
      fuelTimer.stop();          // zatrzymanie Timera
    }

    public String toString()  {
       return "Samoch�d nr rej " + nrRej + " - " + getState();
    }
}

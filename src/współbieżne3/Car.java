package wspó³bie¿ne3;

public class Car extends Vehicle implements Runnable {

    private String nrRej;
    private int tankCapacity;   // pojemnoœæ baku
    private int fuel;           // ile jest paliwa?

    public Car(String nr, Person owner, int w, int h, int l,
               int weight, int tankCap)  {
        super(owner, w, h, l, weight);
        nrRej = nr;
        tankCapacity = tankCap;
    }

    // Nape³nianie baku
    public void fill(int amount)  {
      fuel += amount;
      if (fuel > tankCapacity) fuel = tankCapacity;
    }
    

    // Start samochodu
    public void start()  {
      if (fuel > 0)   {
          super.start();
          new Thread(this).start();  // uruchamiamy w¹tek zu¿ycia paliwa
      }
      else System.out.println("Brak paliwa");
    }

    // Zatrzymanie samochodu
    public void stop()  {
        super.stop();
    }

    // Kod, który wykonuje siê w odrêbnym w¹tku
    // co 1 sek. czasu programu zu¿ywany jest 1 litr paliwa
    public void run()  {
      while(true) {
        try {
          Thread.sleep(1000);
        } catch(InterruptedException exc) { return; }
        fuel--;
        System.out.println("Paliwo: " + fuel);  // œledzimy ile jest paliwa
        if (fuel <= 0) break;    // je¿eli brak paliwa...
      }
     System.out.println("Zatrzymanie samochodu z powodu braku paliwa");
     stop();                     // zatrzymanie samochodu, bo brak paliwa
    }

    public String toString()  {
       return "Samochód nr rej " + nrRej + " - " + super.getState();
    }
    

}

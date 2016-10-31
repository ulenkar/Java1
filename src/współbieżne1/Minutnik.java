package wspó³bie¿ne1;

public class Minutnik extends Thread {

	   public void run() {
	     int time = 0;
	     while (true) {
	       try {
	         this.sleep(10000);
	       } catch(InterruptedException exc) {
	           System.out.println("W¹tek zliczania czasu zoosta³ przerwany.");
	           return;
	       }
	       time++;
	       //int minutes = time/60;
	       //int sec = time%60;
	       System.out.println("Mine³o: " + time*10 + " sekund");
	     }
	   }
	}

package wsp�bie�ne1;

public class Minutnik extends Thread {

	   public void run() {
	     int time = 0;
	     while (true) {
	       try {
	         this.sleep(10000);
	       } catch(InterruptedException exc) {
	           System.out.println("W�tek zliczania czasu zoosta� przerwany.");
	           return;
	       }
	       time++;
	       //int minutes = time/60;
	       //int sec = time%60;
	       System.out.println("Mine�o: " + time*10 + " sekund");
	     }
	   }
	}

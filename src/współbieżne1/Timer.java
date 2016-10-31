package wspó³bie¿ne1;

public class Timer extends Thread {

	   public void run() {
	     int time = 0;
	     while (time <20) {
	       try {
	         this.sleep(1000);
	       } catch(InterruptedException exc) {
	           System.out.println("W¹tek zliczania czasu zoosta³ przerwany.");
	           return;
	       }
	       time++;
	       int minutes = time/60;
	       int sec = time%60;
	       System.out.println(minutes + ":" + sec);
	     }
	   }
	}

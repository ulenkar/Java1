package rekurencja;

public class QTimer {

	   private final long start;

	   public QTimer() {
	     start = System.currentTimeMillis();
	   }

	   public long getElapsed() {
	      return System.currentTimeMillis() - start;
	   }
	   
	}

package rekurencja;

public class Recurs {

	 //sumowanie rekurencyjne  
//	public static int sum(int n) {
//	    if (n == 1) return 1;
//	    else return n + sum(n-1);
//	  }

	
	static int fib(int n) {
		    if (n < 2) return n;
		    else return fib(n-1) + fib(n-2);
		  }
	
	static void fibIter(int n) {
		int[] ciag = new int[n];
		ciag[0] = 0;
		ciag[1] = 1;
		System.out.print(ciag[0] + " " + ciag[1] + " ");
		for (int i=2; i<n; i++) {
			ciag[i]= ciag[i-1] + ciag[i-2];
			System.out.print(ciag[i] + " ");
		}
	}
	  
	  public static void main(String[] args) {
	    
		  int ile = 30;
		  //Obliczenie rekurencyjnie
		  QTimer qt = new QTimer();
		  for (int i=0; i<ile; i++) {
		  System.out.print(fib(i) + " ");
		  }
		  System.out.println();
		  System.out.println("Czas rekurencyjnie: " + qt.getElapsed());
		  
		  //Obliczenie iteracyjnie
		  qt = new QTimer();
		  fibIter(ile);
		  System.out.println();
		  System.out.println("Czas iteracyjnie: " + qt.getElapsed());
		  
		  //jak dzia³a QTimer
		  qt = new QTimer();
		  try {
			  for (int i=0; i<2 ; i++){
			Thread.sleep(1000);
			System.out.println(i + " up³ynê³o: " + qt.getElapsed());
			  }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	}

package rekurencja3;

import java.util.ArrayList;

public class RekuTools {
	
	private static ArrayList<Long> wynikFactorial = new ArrayList<Long>();
	private static ArrayList<Double> wynikCiagGeo = new ArrayList<Double>();
	private static ArrayList<Integer> wynikCiagAry = new ArrayList<Integer>();
	
	private RekuTools() {
	}
	
	public static long factorial(int n) { 
	    if (n == 1) return 1;
	    Long wynik = n * factorial(n-1);
	    //System.out.println(wynik);
	    wynikFactorial.add(wynik);
	    return wynik; 
	} 
	
	public static double ciagGeo(double pierwszy, double iloraz, int ile) { 
	    if (ile == 1) {
	    	wynikCiagGeo.add(pierwszy);
	    	return pierwszy;
	    }
	    double wynik = ciagGeo(pierwszy, iloraz, ile-1)*iloraz;
	    wynikCiagGeo.add(wynik);
	    return wynik; 
	}
	    
	public static int ciagAry(int pierwszy, int roznica, int ile) { 
	    if (ile == 1) {
	    	wynikCiagAry.add(pierwszy);
	    	return pierwszy;
	    }
	    int wynik = ciagAry(pierwszy, roznica, ile-1) + roznica;
	    wynikCiagAry.add(wynik);
	    return wynik; 
	}
	
	public static <T> void printWynik(ArrayList<T> array) {
		for (int i=0; i<array.size(); i++) {
			System.out.print(array.get(i)+" ");
		}
		System.out.println();
	}

	public static ArrayList<Long> getWynikFactorial() {
		return wynikFactorial;
	}

	public static ArrayList<Double> getWynikCiagGeo() {
		return wynikCiagGeo;
	}

	public static ArrayList<Integer> getWynikCiagAry() {
		return wynikCiagAry;
	}
	
	
}

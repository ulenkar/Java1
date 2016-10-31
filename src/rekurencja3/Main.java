package rekurencja3;

public class Main {

	public static void main(String[] args) {
		
		RekuTools.factorial(5);
		RekuTools.ciagGeo(-2,-4,5);
		RekuTools.ciagAry(2,3,5);

		System.out.println("Wyliczenie silni: ");
		RekuTools.printWynik(RekuTools.getWynikFactorial());
		System.out.println("Wyliczenie ciagu geometrycznego: ");
		RekuTools.printWynik(RekuTools.getWynikCiagGeo());
		System.out.println("Wyliczenie ciagu arytmetycznego: ");
		RekuTools.printWynik(RekuTools.getWynikCiagAry());
		
	}

}

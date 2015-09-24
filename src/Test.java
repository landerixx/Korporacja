import java.io.IOException;


public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		
		Firma firma =new Firma();
		
		
		Robotnik dyzio = new Robotnik("Kowal", 0.9, 12);
		Urzednik dyzio2 = new Urzednik("Nowak", 1.5, 3000, 10);
		System.out.println(dyzio);
		System.out.println(dyzio2);
	
		
		System.out.println();
		firma.dopisz(dyzio);
		firma.dopisz(dyzio2);
		
		firma.listaPracownikow();
		
	}

}


public class Robotnik extends Pracownik {

	
	static int limit=200; //na 1.0 etatu
	int stawkaGodzinowa;
	int godziny;
	
	public Robotnik(String nazwisko, double etat, int stawkaGodzinowa) {
		super(nazwisko, etat);
		this.stawkaGodzinowa=stawkaGodzinowa;
		godziny=0;
		
	}

	@Override
	double wyplata() {
		double wynagrodzenie;
		wynagrodzenie=stawkaGodzinowa*(godziny+ godziny>etat*limit?
				0.5*(godziny-etat*limit):0);
		return wynagrodzenie;
				
	}
	
	public String toString(){
		return String.format("%s%12d",super.toString(),  stawkaGodzinowa);
		 
	}
	
	

}

import java.io.Serializable;


abstract public class Pracownik implements Comparable <Pracownik>, Serializable {
	


	String nazwisko;
	double etat;
	
	public Pracownik(String nazwisko, double etat) {
		this.nazwisko = nazwisko;
		this.etat = etat;
	}
	
	abstract double wyplata();
	
	
	
	
	public 	boolean equals(Object o){
		return nazwisko.equals(((Pracownik)o).nazwisko);
	}
	
	public int hashcode(){
		return nazwisko.hashCode();
	}

	@Override
	public int compareTo(Pracownik p) {
		return nazwisko.compareTo(p.nazwisko);

	}
	
	public String toString(){
		return String.format("%-30s%#4.2f%10s", nazwisko,etat,getClass().getSimpleName());
	}
	

}

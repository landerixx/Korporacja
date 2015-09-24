
public class Urzednik extends Pracownik {

	int podstawa; //za caly etat
	int premia;   // w %
	
	
	
	

	
	public Urzednik(String nazwisko, double etat, int podstawa, int premia) {
		super(nazwisko, etat);
		this.podstawa=podstawa;
		this.premia=premia;
		// TODO Auto-generated constructor stub
	}




	@Override
	double wyplata() {
		double wynagrodzenie;
		wynagrodzenie=etat*podstawa*(1+premia*0.01);
		
	return wynagrodzenie;
	}
	
	
	public String toString(){
		
		return super.toString()+ String.format("%7d%5d%%", podstawa,premia);
		
	}
	

}

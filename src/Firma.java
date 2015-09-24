import java.io.*;
import java.util.*;


public class Firma {

	SortedSet <Pracownik> pracownicy;
	
	PrintWriter wyjscie;
	Scanner wejscie;
	
	Firma(){
		pracownicy= new TreeSet<Pracownik>();
		wyjscie= new PrintWriter(System.out,true);
		wejscie= new Scanner(System.in);    //.useLocale(Locale.ENGLISH);
		
	}
	
	double doWyplaty1(){   //for each
		double pieniadze=0;
		for(Pracownik p: pracownicy)
			pieniadze+=p.wyplata();
	return pieniadze;
	}
	
	double doWyplaty2(){  //iteratorem
		
		Iterator<Pracownik> it= pracownicy.iterator();
		double suma = 0;
		while(it.hasNext())
			suma+=it.next().wyplata();
	return suma;	
	}
	
	
	void dopisz(Pracownik p){
		pracownicy.add(p);
	}
	
	void usun(Pracownik p){
		pracownicy.remove(p);	
	}
	
	
	void zwolnij(){ // etat ponizej 1.0
		Iterator<Pracownik> it=pracownicy.iterator();
		while(it.hasNext()){
			if(it.next().etat<1.0)
				it.remove();	
		}
	}
	
	void podwyzka(int s){ // do stawki godzinowej
		for(Pracownik p: pracownicy)
			if (p instanceof Robotnik)
				((Robotnik)p).stawkaGodzinowa+=s;		//polimorfizm nie dziala na polach
	}
	
	boolean jestPracownik(String nazw){
		boolean jest=false;
		
		Iterator<Pracownik> it=pracownicy.iterator();
		while(it.hasNext() &&!jest){
			if(it.next().nazwisko.equals(nazw))
				jest=true;
		}
		return jest;
	}
	
	Pracownik dajPracownika(String nazw){
		Pracownik pracus=null;
		Pracownik p;
		Iterator<Pracownik> it=pracownicy.iterator();
		while(it.hasNext() && pracus==null){
			p=it.next();
			if(nazw.equals(p.nazwisko))
				pracus=p;
		}
		return pracus;
	}
	
	void listaPracownikow(){
		int nrPracownika=1;
		for(Pracownik p: pracownicy)
			wyjscie.printf("%5d.  %s%n", nrPracownika++,p);
		
	}
	
	
	void nowyPracownik(){
		wyjscie.printf("Podaj nazwisko, etat i stanowisko");
		
		String nazw= wejscie.next();
		double etat=wejscie.nextDouble();
		
		if(wejscie.next().equals("u")){
			wyjscie.printf("Podaj podstawe oraz premie w %");
			int pod= wejscie.nextInt();
			
		pracownicy.add(new Urzednik(nazw, etat, pod, wejscie.nextInt()));		
		}
		else {
			wyjscie.printf("Podaj stawke godzinowa");
				pracownicy.add(new Robotnik(nazw, etat, wejscie.nextInt()));
		}
		
	}
	
	void save(String nazwaPliku) throws IOException{
		
		ObjectOutputStream wyj= new ObjectOutputStream(new FileOutputStream(nazwaPliku));
		wyj.writeObject(pracownicy);
		wyj.close();
		
	}
	
	
	
	void restore(String nazwaPliku) throws IOException, ClassNotFoundException{
		
		ObjectInputStream wej= new ObjectInputStream(new FileInputStream(nazwaPliku));
		
		pracownicy= (SortedSet<Pracownik>)wej.readObject();
		wej.close();
		
	}
	
	
	
	
	
	void wpiszGodzinyRobotnikom() throws IOException{
		
		
		Scanner scan= null;
		int proba=3;
		String nazwa;
		
		wyjscie.printf("Podaj nazwe pliku");
		
		try{
			
			
		while(scan==null && proba>0){
			nazwa=wejscie.next();
			
			try{
				scan=new Scanner(new File(nazwa));
			}
			catch(FileNotFoundException e){
				if(--proba>0)
					wyjscie.printf("Popraw");
				else
					throw new  FileNotFoundException(nazwa);
			}
			
		} //while
		
		wyjscie.printf("Podaj nazwisko");
		String nazw=scan.next();
		Pracownik p= dajPracownika(nazw);
		
		if(p==null)
			throw new RuntimeException(nazw + " nie pracuje w firmie");
		
		if(!(p instanceof Robotnik))
			throw new RuntimeException(nazw + " nie jest robotnikiem");
		
		wyjscie.printf("Podaj ilosc godzin");
		int godz=scan.nextInt();
		
		if(godz<0)
			throw new RuntimeException(nazw + " ujemna ilosc godzin");
		
		((Robotnik)p).godziny=godz;
		
		
		
		} //try
	
		finally{
			
			if(scan!=null)
				scan.close();
			
			
		}
			
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

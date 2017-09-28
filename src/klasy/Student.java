package klasy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Osoba implements Comparable<Student> {

	private String kierunek;
	private int rok;
	private List<Integer> oceny = new ArrayList<>() ;
	
	public List<Integer> getOceny() {
		return oceny;
	}

	public void setOceny(List<Integer> oceny) {
		this.oceny = oceny;
	}
	
	public double obliczSrednia() {
		double suma = 0;
		for (Integer ocena : oceny) {
			suma += ocena;
		}
		
		return suma / oceny.size();
	}

	public Student(String imie, String nazwisko, LocalDate dataUrodzenia, double waga, double wzrost, String kierunek,
			int rok) {
		super(imie, nazwisko, dataUrodzenia, waga, wzrost);
		this.kierunek = kierunek;
		this.rok = rok;
	}

	public Student(String imie, String nazwisko, String dataUrodzenia, double waga, double wzrost, String kierunek,
			int rok) {
		super(imie, nazwisko, dataUrodzenia, waga, wzrost);
		this.kierunek = kierunek;
		this.rok = rok;
	}

	public String getKierunek() {
		return kierunek;
	}

	public void setKierunek(String kierunek) {
		this.kierunek = kierunek;
	}

	public int getRok() {
		return rok;
	}

	public void setRok(int rok) {
		this.rok = rok;
	}
	public String kimJestes() {
		return "jestem studentem";
	}
	
	@Override
	public String toString() {
		return "Student " + super.toString() +" rok studiow - " + rok +" kierunek: " + kierunek;
	}
	
	public void dodajOcene(int ocena) {
		oceny.add(ocena);
	}

	@Override
	public int compareTo(Student inny) {
		//zakladamy ze imie i nazwisko nie sa nullami
		
		int wynik = this.getNazwisko().compareTo(inny.getNazwisko());
		if(wynik == 0) {
			wynik = this.getImie().compareTo(inny.getImie());	
		}
		return wynik;
	}

}

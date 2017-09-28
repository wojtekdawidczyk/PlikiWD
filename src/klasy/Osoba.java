package klasy;

import java.time.LocalDate;
import java.time.Period;

public class Osoba {

	private String imie, nazwisko;
	private LocalDate dataUrodzenia;
	private double waga, wzrost;
	
	public Osoba(String im, String naz) {
		imie = im;
		nazwisko = naz;
	}
	
	public Osoba() {
		
	}
	
	public Osoba(String imie, String nazwisko, double waga, double wzrost) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.waga = waga;
		this.wzrost = wzrost;
	}

	public Osoba(String imie, String nazwisko, String dataUrodzenia, double waga, double wzrost) {
		this(imie, nazwisko, LocalDate.parse(dataUrodzenia), wzrost, waga);
	}
	public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia, double waga, double wzrost) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.setDataUrodzenia(dataUrodzenia);
		this.waga = waga;
		this.wzrost = wzrost;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public double getWaga() {
		return waga;
	}

	public double getWzrost() {
		return wzrost;
	}

	void przedstawSie() {
		System.out.println("nazywam się "+imie+" "+nazwisko);
	}
	
	public double getBmi() {
	return waga/(wzrost*wzrost);
		
	}
	
	public void przytyj(double zmiana) {
		waga += zmiana;
	}
	
	public String toString() {
		return imie + " " + nazwisko + " " + "ur. " + dataUrodzenia + " " + wzrost + "m "+ waga + "kg";
	}
	public String kimJestes() {
		return "jestem osobą";
	}
	
	public LocalDate getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public int getWiek() {
		Period okres = Period.between(dataUrodzenia, LocalDate.now());
		return okres.getYears();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUrodzenia == null) ? 0 : dataUrodzenia.hashCode());
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		long temp;
		temp = Double.doubleToLongBits(waga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wzrost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Osoba other = (Osoba) obj;
		if (dataUrodzenia == null) {
			if (other.dataUrodzenia != null)
				return false;
		} else if (!dataUrodzenia.equals(other.dataUrodzenia))
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (Double.doubleToLongBits(waga) != Double.doubleToLongBits(other.waga))
			return false;
		if (Double.doubleToLongBits(wzrost) != Double.doubleToLongBits(other.wzrost))
			return false;
		return true;
	}
	
	
	}


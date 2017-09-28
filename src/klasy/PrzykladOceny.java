package klasy;

public class PrzykladOceny {
public static void main(String[] args) {
	
	Student s1 = new Student("jan", "kowalski", "1999-02-02", 70, 70, "biologia", 3);
	s1.dodajOcene(5);
	s1.dodajOcene(5);
	s1.dodajOcene(3);
	s1.dodajOcene(2);
	s1.dodajOcene(3);
	s1.dodajOcene(5);
	s1.dodajOcene(4);
	s1.dodajOcene(2);
	
	System.out.println("oceny studenta " + s1.getImie() + " " + s1.getNazwisko() + " : " + s1.getOceny());
	System.out.printf("średnia : " + s1.obliczSrednia() + "\n");
	System.out.printf("średnia : %.2f",s1.obliczSrednia());
}
}

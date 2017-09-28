package klasy;

public class Porywnywanie {
public static void main(String[] args) {
	
	Osoba a = new Osoba("ala", "kowalska", "1991-09-09", 70, 70);
	Osoba r = a;
	Osoba c = new Osoba("ala", "kowalska", "1991-09-09", 70, 70);
	Osoba b = new Osoba("jan", "kowalski", "1991-09-09", 70, 70);
	
	
	System.out.println("porownuje za pomoca ==");
	System.out.println(a == r);
	System.out.println(a == b);
	System.out.println(a == c);
	System.out.println();
	
	System.out.println("porownuje za pomoca .equals");
	System.out.println(a.equals(r));
	System.out.println(a.equals(b));
	System.out.println(a.equals(c));
	System.out.println();
	
	
}
}

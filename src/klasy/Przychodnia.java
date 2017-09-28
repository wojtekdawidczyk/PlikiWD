package klasy;

public class Przychodnia {

	void zbadaj(Osoba pacjent) {
		
		double bmi = pacjent.getBmi();
		
		System.out.println("pacjent "+pacjent.getImie()+" "+pacjent.getNazwisko()+" raport - ");
		
		if(bmi < 20) {
			System.out.println("niedowaga");
		} else if(bmi < 30) {
			System.out.println("waga w normie");
		} else {
			System.out.println("otyłość");
		}
	}	
}

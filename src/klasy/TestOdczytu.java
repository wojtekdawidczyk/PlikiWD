package klasy;

import java.io.File;
import java.util.List;

public class TestOdczytu {
public static void main(String[] args) {
	
	System.out.println("otwieram plik...");
	
	File plik = new File("studenci.csv");
	List<Student> studenci = ObslugaCSV.wczytajStudentow(plik);
	System.out.println("wczytałem " + studenci.size() + " rekordow");
	for (Student student : studenci) {
		System.out.println(student);
	}
}
	
}

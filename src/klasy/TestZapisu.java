package klasy;

import java.util.LinkedList;
import java.util.List;

public class TestZapisu {

	public static void main(String[] args) {
		
		List<Student> studenci = new LinkedList<>();
		studenci.add(new Student("ala", "kowalska", "1999-02-02", 10, 10, "biologia", 3));
		studenci.add(new Student("ola", "nowak", "1999-02-02", 10, 10, "informatyka", 3));
		studenci.add(new Student("ala", "sssss", "1999-02-02", 10, 10, "informatyka", 3));
		studenci.add(new Student("janek", "nowaczyk", "1999-02-02", 10, 10, "chemia", 3));
		
		ObslugaCSV.zapiszStudentow(studenci, "studenci.csv");
	}
}

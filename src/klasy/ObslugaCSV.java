package klasy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

// To jest przykład "klasy narzędziowej", która posiada metody statyczne - tak jakby "procedury"

public class ObslugaCSV {
    // uproszczony CSV - nie obsługujemy "escape'owania" znaków
    
    public static final String SEPARATOR = ";" ;
    
    public static void zapiszStudentow(Collection<Student> studenci, String plik) {
   	 zapiszStudentow(studenci, new File(plik));
    }
    
    public static void zapiszStudentow(Collection<Student> studenci, File plik) {   	 
   	 try(PrintWriter out = new PrintWriter(plik)) {
   		 for(Student student : studenci) {
   			 out.print(student.getImie());
   			 out.print(SEPARATOR);
   			 out.print(student.getNazwisko());
   			 out.print(SEPARATOR);
   			 out.print(student.getDataUrodzenia());
   			 out.print(SEPARATOR);
   			 out.printf("%f", student.getWzrost());
   			 out.print(SEPARATOR);
   			 out.printf("%f",student.getWaga());
   			 out.print(SEPARATOR);
   			 out.print(student.getKierunek());
   			 out.print(SEPARATOR);
   			 out.print(student.getRok());
   			 out.println();
   		 }
   		 
   	 } catch (FileNotFoundException e) {
   		 e.printStackTrace();
   	 }
    }
    
    public static List<Student> wczytajStudentow(File plik) {
   	 List<Student> studenci = new ArrayList<>();
   	 
   	 try(Scanner skanerPliku = new Scanner(plik)) {
   		 while(skanerPliku.hasNextLine()) {
   			 String linia = skanerPliku.nextLine();
   			 
   			 Scanner skanerLinii = new Scanner(linia);
   			 skanerLinii.useDelimiter(SEPARATOR);
   			 
   			 String imie = skanerLinii.next();  // skaner się "przesuwa"
   			 String nazwisko = skanerLinii.next();
   			 String data = skanerLinii.next();
   			 double wzrost = skanerLinii.nextDouble();
   			 double waga = skanerLinii.nextDouble();
   			 String kierunek = skanerLinii.next();
   			 int rok = skanerLinii.nextInt();
   			 
   			 Student student = new Student(imie, nazwisko, data, wzrost, waga, kierunek, rok);
   			 studenci.add(student);
   		 }
   	 } catch (FileNotFoundException e) {
   		 e.printStackTrace();
   	 }
   	 
   	 return studenci;
    }
    
}




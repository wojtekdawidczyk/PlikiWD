package pliki;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Zapisz3 {
public static void main(String[] args) {
	
	try {
		PrintWriter out = new PrintWriter("ala.txt");
		
		out.println("ala ma kotecka");
		out.println("napisano o godzinie: " + LocalTime.now());
		
		out.close();
		
		System.out.println("gotowe");
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

package pan_tadeusz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WypiszSlowa1 {
	public static void main(String[] args) {
		
		File plik = new File("pan-tadeusz.txt");
		
		try(Scanner sc = new Scanner(plik)) {
			int licznik = 0;
			while (sc.hasNext()) {
				String slowo = sc.next();
				System.out.println(slowo);
				licznik ++;
			}
			System.out.println("liczba wszystkich slow: " + licznik);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package pan_tadeusz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WypiszSlowa2 {
	public static void main(String[] args) {
		
		File plik = new File("pan-tadeusz.txt");
		
		try(Scanner sc = new Scanner(plik)) {
			//sc.useDelimiter(" "); 
			//sc.useDelimiter("\\s+"); separator domyslny
			//sc.useDelimiter("[ \n\r,.!?:;...()<<>>—]+");
			//sc.useDelimiter("[^\\p{L}]+"); bez cyfr
			sc.useDelimiter("[^\\p{L}]+"); //separatorem jest ciag znakow ktore nie sa literami
			
			int licznik = 0;
			
			while (sc.hasNext()) {
				String slowo = sc.next();
				System.out.println("[" + slowo + "]");
				licznik ++;
			}
			System.out.println("liczba wszystkich slow: " + licznik);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package pan_tadeusz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.StandardOpenOption;

public class PosortujPanaTadeusza {
	public static void main(String[] args) {
	
		try {
			List<String> linie = Files.readAllLines(Paths.get("pan-tadeusz.txt"));
			
			linie.sort(null);
			
			Files.write(Paths.get("posortowany2.txt"), linie, StandardOpenOption.CREATE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	


}

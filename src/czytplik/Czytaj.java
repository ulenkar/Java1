package czytplik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Czytaj {

	private int slow, linii, liter;

	Czytaj(File f) throws IOException {
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		slow = 0; 
		linii = 0;
		liter = 0;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			slow += st.countTokens();
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				liter += s.length();
			}
			linii++;
		}
	}
	
	int ileSlow() {
		return slow;
	}
	
	int ileLinii() {
		return linii;
	}
	
	int ileLiter() {
		return liter;
	}
}

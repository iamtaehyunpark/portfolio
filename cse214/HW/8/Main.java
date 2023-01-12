
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		File file = new File("/Users/a/Documents/cse214/HW/8/dictionarys.txt");


		try {
			br = new BufferedReader(new FileReader("/Users/a/Documents/cse214/HW/8/dictionaryss.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				writer.write(line + ' ');
				//writer.close();
			}
			br.close();
		} catch (Exception e) {
			System.err.println("File error: " + e.getMessage());
			System.exit(-1);
		}
	}
}

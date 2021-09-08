import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LinkFileWritter {

	public String[] fileWriting(String arg[], String path) throws IOException {
		String listUrl[] = new String[arg.length];
		FileWriter w;
		w = new FileWriter(path, true);
		BufferedWriter bufferWr = new BufferedWriter(w);
		boolean doubleCheck;
		for (int i = 0; i < arg.length; i++) // per ogni arg che inseriamo
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			doubleCheck = false;// riporto la variabile di controllo al suo valore originale
			while (line != null)// finchè non siamo a fine file
			{

				if (arg[i].equals(line))// se l'arg in questione è uguale alla linea letta, la condizione è vera,
										// altrimenti legge la successiva
				{
					doubleCheck = true;
					line = reader.readLine();
				} else
					line = reader.readLine();
			}
			if (doubleCheck == false) { // se l'arg non è un doppione, viene scritto in fondo al file
				listUrl[i] = line;
				bufferWr.write(arg[i] + "\n");
				bufferWr.flush();
			}
			reader.close();
		}
		return listUrl;
	}
}

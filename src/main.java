import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.net.URL;
import java.util.Random;

public class main {
	public static void main(String[] args) throws IOException {
		FileWriter w;
		w = new FileWriter("my_res.txt", true);
		BufferedWriter b = new BufferedWriter(w);
		boolean controllo;// variabile di controllo sui doppioni

		if (args.length == 0)
			System.out.println("Errore");
		else {
			for (int i = 0; i < args.length; i++) // per ogni arg che inseriamo
			{
				BufferedReader reader = new BufferedReader(new FileReader("my_res.txt"));
				String line = reader.readLine();
				controllo = false;// riporto la variabile di controllo al suo valore originale
				while (line != null)// finch� non siamo a fine file
				{

					if (args[i].equals(line))// se l'arg in questione � uguale alla linea letta, la condizione � vera,
												// altrimenti legge la successiva
					{
						controllo = true;
						line = reader.readLine();
					} else
						line = reader.readLine();
				}
				if (controllo == false) { // se l'arg non � un doppione, viene scritto in fondo al file
					b.write(args[i] + "\n");
					b.flush();
				}
				reader.close();
			}
		}

		BufferedReader lettore = new BufferedReader(new FileReader("my_res.txt"));
		String linea = lettore.readLine();
		while (linea != null)// finch� non siamo a fine file
		{
			System.out.println(linea);
			linea = lettore.readLine();
		}
	}
	/*
	 * public static void saveImage(String imageUrl, String destinationFile) throws
	 * IOException { URL url = new URL(imageUrl); InputStream is = url.openStream();
	 * OutputStream os = new FileOutputStream(destinationFile);
	 * 
	 * byte[] b = new byte[2048]; int length;
	 * 
	 * while ((length = is.read(b)) != -1) { os.write(b, 0, length); }
	 * 
	 * is.close(); os.close(); }
	 */

	/*
	 * public static void estraiNomeFiledaURL( String url) { String [] divisione =
	 * url.split("/"); Pattern regex=null; String exp = "/.{1}j{1}p{1}g$/"; String
	 * exp1 = "/.{1}p{1}n{1}g$/"; for(int i =0; i<divisione.length;i++) {
	 * if(regex.matches(exp, divisione[i])==true) System.out.println(divisione[i]);
	 * else if(regex.matches(exp1, divisione[i])==true)
	 * System.out.println(divisione[i]); } }
	 */
	public static String creaFileName(String este) {
		String nome = "";
		Random car = new Random();
		int carint;
		char chara;
		for (int i = 0; i < 10; i++) {
			carint = car.nextInt(26) + 'a';
			if (carint % 2 == 0)
				chara = Character.toUpperCase((char) carint);
			else
				chara = (char) carint;
			nome = nome + chara;
		}
		nome = nome + este;
		return nome;
	}

	public static String extractExtensionFromUrl(String url) {
		if(url.contains(".png"))
			return ".png";
		else
			if(url.contains(".jpg"))
				return ".jpg";
			else
				if(url.contains(".jpeg"))
			return ".jpeg";
				else
					if(url.contains(".ico"))
						return ".ico";
			
			
			
			
			
			
			
			
			
			
			
			

}

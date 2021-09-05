import java.io.*;
import java.net.URL;
import java.util.Random;
import java.io.File;

public class mainclass {
	private static char fs= File.separatorChar;
	private static String Root="C:";
	public static void main(String[] args) throws IOException {
		String folder = "media";
		String filenome= "my_res.txt";
		File filestampa= new File(Root+fs+folder+fs+filenome);
		FileWriter w;
		w = new FileWriter(filenome, true);
		BufferedWriter b = new BufferedWriter(w);
		boolean controllo;// variabile di controllo sui doppioni

		if (args.length == 0)
			System.out.println("Errore");
		else {
			for (int i = 0; i < args.length; i++) // per ogni arg che inseriamo
			{
				BufferedReader reader = new BufferedReader(new FileReader(filenome));
				String line = reader.readLine();
				controllo = false;// riporto la variabile di controllo al suo valore originale
				while (line != null)// finchè non siamo a fine file
				{

					if (args[i].equals(line))// se l'arg in questione è uguale alla linea letta, la condizione è vera,
												// altrimenti legge la successiva
					{
						controllo = true;
						line = reader.readLine();
					} else
						line = reader.readLine();
				}
				if (controllo == false) { // se l'arg non è un doppione, viene scritto in fondo al file
					b.write(args[i] + "\n");
					b.flush();
				}
				reader.close();
			}
		}

		BufferedReader lettore = new BufferedReader(new FileReader(filenome));
		String linea = lettore.readLine();
		String est="";
		String nomefile="";
		while (linea != null)// finchè non siamo a fine file
		{
			est=extractExtensionFromUrl(linea);
			nomefile=creaFileName(est);
			System.out.println(nomefile);
			saveImage(linea, nomefile);
			linea = lettore.readLine();
		}
	}
	
	  public static void saveImage(String imageUrl, String destinationFile) throws
	  IOException { URL url = new URL(imageUrl); InputStream is = url.openStream();
	  OutputStream os = new FileOutputStream(destinationFile);
	  
	 byte[] b = new byte[2048]; int length;
	  
	 while ((length = is.read(b)) != -1) { os.write(b, 0, length); }
	  
	  is.close(); os.close(); }
	 

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
		String este=null;;
		if(url.contains(".png"))
			este= ".png";
		else
			if(url.contains(".jpg"))
				este= ".jpg";
			else
				if(url.contains(".jpeg"))
					este=".jpeg";
				else
					if(url.contains(".ico"))
						este= ".ico";
		return este;
		}

}

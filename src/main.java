import java.io.*;
import java.net.URL;

public class main {
	public static void main(String[] args) throws IOException {
		FileWriter w;
		w = new FileWriter("my_res.txt", true);
		BufferedWriter b = new BufferedWriter(w);
		boolean controllo;// variabile di controllo sui doppioni

		if (args.length == 0)
			System.out.println("Errore");
		else {
			for (int i=0; i<args.length; i++) // per ogni arg che inseriamo
			{
				BufferedReader reader = new BufferedReader(new FileReader("my_res.txt"));
				String line=reader.readLine();
				controllo=false;// riporto la variabile di controllo al suo valore originale
				while(line!=null)//finchè non siamo a fine file
				{
					
					if(args[i].equals(line))//se l'arg in questione è uguale alla linea letta, la condizione è vera, altrimenti legge la successiva
					{
						controllo=true;
						line=reader.readLine();
					}
					else
						line=reader.readLine();
				}
				if(controllo==false) {   //se l'arg non è un doppione, viene scritto in fondo al file
					b.write(args[i]+"\n");
					b.flush();
				}
				reader.close();
			}
		}

		BufferedReader lettore = new BufferedReader(new FileReader("my_res.txt")); 
		String linea=lettore.readLine();
		while (linea != null)// finchè non siamo a fine file
		{
			System.out.println(linea);
			linea=lettore.readLine();
		}
	}
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
}



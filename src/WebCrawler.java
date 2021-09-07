import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
	final char fs= File.separatorChar;
	private static String creaFileName(String este) {	
		final int FILE_NAME_MAX_LENGTH = 10;
		String nome = "";
		Random car = new Random();
		int valore_int_carattere;
		char chara;
		for (int i = 0; i < FILE_NAME_MAX_LENGTH; i++) {
			valore_int_carattere = car.nextInt(26) + 'a';
			final boolean doUppercase = valore_int_carattere % 2==0;
			if (doUppercase)
				chara = Character.toUpperCase((char) valore_int_carattere);
			else
				chara = (char) valore_int_carattere;
			nome = nome + chara;
		}
		nome = nome + este;
		return nome;
	}
	
	private String extractExtensionFromUrl(String url) {
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
	
	private void saveImage(String imageUrl, String destinationFile) throws IOException{
		URL url = new URL(imageUrl); InputStream is = url.openStream();
	  OutputStream os = new FileOutputStream(destinationFile);
	  
	 byte[] b = new byte[2048]; int length;
	  
	 while ((length = is.read(b)) != -1) { os.write(b, 0, length); }
	  
	  is.close(); os.close(); 
	  }
	
	public void downloadimages (String url, String path) throws IOException{
		String est;
		String nomefile;
		est=extractExtensionFromUrl(String.valueOf(url));
		nomefile=creaFileName(est);
		System.out.println(nomefile);
		saveImage(url,path+fs+nomefile);
	}
	public void downloadimages (String[] listaurl, String path) throws IOException{
		String est;
		String nomefile;
		for (int i=0; i< listaurl.length; i++)// finchè non siamo a fine file
		{
			Document doc= Jsoup.connect(listaurl[i]).get();
			Elements links = doc.select("img[src]");
			for(Element url: links) {
			est=extractExtensionFromUrl(String.valueOf(url));
			nomefile=creaFileName(est);
			System.out.println(nomefile);
			saveImage(String.valueOf(url),path+fs+nomefile);
			}
		}
	}
}


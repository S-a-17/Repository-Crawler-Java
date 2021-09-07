import java.io.*;
import java.net.URL;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class mainclass {
	private static char fs= File.separatorChar;
	public static void main(String[] args) throws IOException {
		String listaurl[]= new String [args.length];
		String folder = "Media";
		String filenome= "my_res.txt";
		File filestampa= new File(folder);
		filestampa.mkdirs();
		
		// variabile di controllo sui doppioni

		if (args.length == 0)
			System.out.println("Errore");
		else {
			LinkFileWritter d = new LinkFileWritter();
			listaurl = d.Scritturafile(args, folder+fs+filenome);
		}

		//----------------------------------------//parte jsoup
		WebCrawler c = new WebCrawler();
		c.downloadimages(listaurl, folder);
	}
	
	  
	 

	/*
	 * public static void estraiNomeFiledaURL( String url) { String [] divisione =
	 * url.split("/"); Pattern regex=null; String exp = "/.{1}j{1}p{1}g$/"; String
	 * exp1 = "/.{1}p{1}n{1}g$/"; for(int i =0; i<divisione.length;i++) {
	 * if(regex.matches(exp, divisione[i])==true) System.out.println(divisione[i]);
	 * else if(regex.matches(exp1, divisione[i])==true)
	 * System.out.println(divisione[i]); } }
	 */

}

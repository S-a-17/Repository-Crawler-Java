import java.io.*;
import java.net.URL;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyMainClass {
	private static char fs = File.separatorChar;

	public static void main(String[] args) throws IOException {
		String listUrl[] = new String[args.length];
		String folder = "Media";
		String fileName = "my_res.txt";
		File fileStamp = new File(folder);
		fileStamp.mkdirs();

		// variabile di controllo sui doppioni

		if (args.length == 0)
			System.out.println("Errore");
		else {
			LinkFileWritter d = new LinkFileWritter();
			listUrl = d.fileWriting(args, folder + fs + fileName);
		}

		// ----------------------------------------//parte jsoup
		WebCrawler c = new WebCrawler();
		c.downloadImages(listUrl, folder);
	}


}

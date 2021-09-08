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
	final char fs = File.separatorChar;

	private static String createFileName(String exte) {
		final int FILE_NAME_MAX_LENGTH = 10;
		final int ALPHABET_SPACER = 26;
		String name = "";
		Random randInt = new Random();
		int intValueOfChar;
		char finalChar;
		for (int i = 0; i < FILE_NAME_MAX_LENGTH; i++) {
			intValueOfChar = randInt.nextInt(ALPHABET_SPACER) + 'a';
			final boolean doUppercase = intValueOfChar % 2 == 0;
			if (doUppercase)
				finalChar = Character.toUpperCase((char) intValueOfChar);
			else
				finalChar = (char) intValueOfChar;
			name = name + finalChar;
		}
		name = name + exte;
		return name;
	}

	private String extractExtensionFromUrl(String url) {
		String exte = null;
		if (url.contains(".png"))
			exte = ".png";
		else if (url.contains(".jpg"))
			exte = ".jpg";
		else if (url.contains(".jpeg"))
			exte = ".jpeg";
		else if (url.contains(".ico"))
			exte = ".ico";
		else
		{
			System.out.println("WARNING: estensione non riconosciuta");
			exte=null;
		}
		return exte;
	}

	private void saveImage(String imageUrl, String destinationFile) throws IOException {
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

	public void downloadImages(String url, String path) throws IOException {
		String est;
		String nameFile;
		est = extractExtensionFromUrl(String.valueOf(url));
		nameFile = createFileName(est);
		System.out.println(nameFile);
		saveImage(url, path + fs + nameFile);
	}

	public void downloadImages(String[] listUrl, String path) throws IOException {
		String ext;
		String nameFile;
		for (int i = 0; i < listUrl.length; i++)// finchè non siamo a fine file
		{
			Document doc = Jsoup.connect(listUrl[i]).get();
			Elements links = doc.select("img[src]");
			for (Element url : links) {
				ext = extractExtensionFromUrl(String.valueOf(url));
				nameFile = createFileName(ext);
				System.out.println(nameFile);
				saveImage(String.valueOf(url), path + fs + nameFile);
			}
		}
	}
}

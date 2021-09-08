import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

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
		Login a= new Login();
		boolean resp=a.Control(folder+fs+"Creds.txt") ;
		if(resp==true)
		{
			String inserUsername;
			Scanner inputUsername = new Scanner(System.in);
			String inserPassword;
			Scanner inputPassword = new Scanner(System.in);
			System.out.println("Inserire lo username");
			inserUsername= inputUsername.nextLine();
			System.out.println("Inserire la password");
			inserPassword= inputPassword.nextLine();
			boolean control;
			control=a.UserLogin(inserUsername, inserPassword, folder+fs+"Creds.txt");
			if(control==false)
			{
				System.out.println("Account non registrato");
				System.exit(0);
			}
		}

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

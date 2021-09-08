import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {

	public boolean Control(String file)
	{
		boolean resp;
		File f= new File(file);
		resp= f.exists();
		return resp;
	}
	
	public boolean UserLogin(String username, String password, String path) throws IOException
	{
		boolean resp=false;
		final int parts=2;
		String part1;
		String part2;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		String splitting[]= new String [parts];
		while (line != null)
		{
			splitting= line.split(":");
			part1=splitting[0];
			part2=splitting[1];
			if(part1.equals(username)&&part2.equals(password))
			{
				resp=true;
				line=null;
			}
			else
				line=reader.readLine();
				
		}
		return resp;
	}
}

import java.io.*;
import java.util.*;

public class NetflixFileReader 
{
	Scanner scanner;
	
	public NetflixFileReader(File file) throws FileNotFoundException 
	{
		scanner = new Scanner(file);
	}
	
	public List<Media> movieList()
	{
		List<Media> mediaList = new LinkedList<Media>();
		
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			
			// Basic Parameter of each Media object.
			String title = line.substring(0, line.indexOf("(")).trim();;		
			int year = 0;
			float rating = 0.0f;
			
			if(year > 10)
			{
				// Parse the length of the movie then add.
				String length = "";
				
				// Add a movie to a list.
				mediaList.add(new Movie(title, year, rating, length));
			}
			else
			{
				// Parse the number of seasons then add.
				int season = 0;
				
				// Add a series to a list.
				mediaList.add(new Series(title, year, rating, season));
			}
		}
		
		return mediaList;
	}
}
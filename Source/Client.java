import java.io.*;
import java.util.*;

public class Client 
{
	public static void main(String args[])
	{
		NetflixFileReader netflix = null;
		
		try
		{
			 netflix = new NetflixFileReader(new File("NetflixUSA_Oct15_cleaned.txt"));	 
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find Netflix text file.");
		}	
		
		List<Media> mediaList = netflix.movieList();
		System.out.println(mediaList.get(0).getTitle());
		System.out.println(mediaList.get(0).getYear());
		System.out.println(mediaList.get(0).getRating());
	}
}

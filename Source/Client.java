import java.io.*;
import java.util.*;

public class Client 
{
	public static void main(String args[])
	{
		NetflixFileReader netflix = null;
		List<Filter> filters = new LinkedList<Filter>();
		
		try
		{
			netflix = new NetflixFileReader(new File("NetflixUSA_Oct15_cleaned.txt"));	 
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find Netflix text file.");
		}	
		
		List<Media> mediaList = netflix.movieList();
				
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a filter, or -1 to show filtered list.");
		
		String field = "";
		char relation = ' ';
		String target = "";
		
		do
		{
			System.out.print("Field: ");
			field = scanner.next();
			
			System.out.print("Relation: ");
			relation = scanner.next().trim().charAt(0);
			
			System.out.print("Target: ");
			target = scanner.next();
			
			System.out.println();
			
			filters.add(new Filter(field, relation, target));
		} while(relation != '1');
		
		for(int i = 0; i < mediaList.size(); i++)
		{
			System.out.println(mediaList.get(i));
		}
	}
}

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
		List<Media> temp = mediaList;
		
		Scanner scanner = new Scanner(System.in);		
		String field;
		String target;
		char relation;
		
		boolean doContinue = false;
		
		String command = "";
		
		// Do loop start.
		int counter = 0;
		do
		{
			System.out.print("Add or remove a filter ('add, 'remove): ");
			
			command = scanner.next().toLowerCase();
			
			if(command.contains("add"))
			{
				System.out.print("Field: ");
				field = scanner.next().trim();

				System.out.print("Relation: ");
				relation = scanner.next().trim().charAt(0);
				scanner.nextLine();	
			
				System.out.print("Target: ");
				target = scanner.nextLine();
									
				filters.add(new Filter(field, relation, target));
				
				System.out.print("Continue? (Enter 'true' or 'false': ");
				doContinue = Boolean.parseBoolean(scanner.next().trim().toLowerCase());
			
				System.out.println();
				
				if(counter >= 1)
				{
					temp = filters.get(counter - 1).filteredMedia(temp);
				}
				
				mediaList = filters.get(counter++).filteredMedia(mediaList);
				
				for(int i = 0; i < mediaList.size(); i++)
				{
					System.out.println(mediaList.get(i));
				}
			}
			else if(command.contains("remove"))
			{
				filters.remove(filters.size() - 1);
				mediaList = temp;
				
				System.out.print("Continue? (Enter 'true' or 'false': ");
				doContinue = Boolean.parseBoolean(scanner.next().trim().toLowerCase());
				
				System.out.println();
				
				for(int i = 0; i < mediaList.size(); i++)
				{
					System.out.println(mediaList.get(i));
				}
			}
			else
			{
				System.err.println("Unknown command.");
				// Go back to start.
				doContinue = true;
			}
			
		} while(doContinue);
		// Do loop end.		
		
		scanner.close();
	}
}

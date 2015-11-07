// Authors: Benjamin Brown and Jake Jones
// Assignment: Project 2
// Filename: netflixFileReader.java

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
			String title = "";
			int year = 0;
			float rating = 0.0f;	
			
			int i = 0;
			while(i < line.length())
			{
				if((line.charAt(i) == '(') && ((line.charAt(i + 1) == '1') || (line.charAt(i + 1) == '2')))
				{
					// Get title and year.
					title = line.substring(0, i).trim();
					year = Integer.parseInt(line.substring(i + 1, i + 5).trim());
						
					if(line.charAt(i + 5) == '-')
					{
						// Move through the line.
						i += 5;
					}	
					if(line.charAt(i + 7) == '(')
					{
						// Move through the line.
						i += 7;
					}
					
					// Move through the line.
					i +=  11;
					
					// Move to first rating.
					if(line.charAt(i) != ',' && line.charAt(i + 1) != '|')
					{					
						if(line.charAt(i + 2) != 's')
						{
							rating = Float.parseFloat(line.substring(i, i + 3).trim());	
							
							if((i + 11) < line.length())
								// Move through the line.
								i += 11;
						}
						else
						{
							rating = Float.parseFloat(line.substring(i, i + 1));
							
							if((i + 9) < line.length())
								// Move through the line.
								i += 9;
						}	
					}
					
					// Movie and Series code.
					if(line.charAt(i) != ',')
					{
						if(line.charAt(line.length() - 1) == 'm' || line.charAt(line.length() - 1) == 'r')
						{
							String length = "";
							
							for(int j = i; j < line.length(); j++)
							{
								length += line.charAt(j);
							}
							
							// Add a movie to a list.
							mediaList.add(new Movie(title, year, rating, length));
						}
						else
						{
							String length = "";			
							
							for(int j = i; j < line.length(); j++)
							{
								length += line.charAt(j);
							}
							
							// Add a series to a list.
							mediaList.add(new Series(title, year, rating, length));
						}
					}
					else if(line.charAt(i) == ',' && i < line.length())
					{
						if(line.charAt(line.length() - 1) == 'm' || line.charAt(line.length() - 1) == 'r')
						{
							String length = "";
							
							for(int j = i + 2; j < line.length(); j++)
							{
								length += line.charAt(j);
							}
							
							// Add a movie to a list.
							mediaList.add(new Movie(title, year, rating, length));
						}
						else
						{
							String length = "";			
							
							for(int j = i + 2; j < line.length(); j++)
							{
								length += line.charAt(j);
							}
							
							if(length.isEmpty())
							{
								// Length is unknown 
								length = "???";
							}
							
							// Add a series to a list.
							mediaList.add(new Series(title, year, rating, length));
						}
					}
					else
					{
						mediaList.add(new Movie(title, year, rating, "???"));
					}
				}
				else
				{
					i++;
				}
				
			}
		}		
		
		return mediaList;
	}
}
// Authors: Benjamin Brown and Jake Jones
// Assignment: Project 2
// Filename: netflixFileReader.java

import java.util.*;

public class Filter
{	
	String field;
	char relation;
	String target;
	
	public Filter(String field, char relation, String target)
	{
		this.field = field.toLowerCase();
		this.relation = relation;
		this.target = target;
		
	}
	
	public List<Media> filteredMedia(List<Media> mediaList)
	{	
		List<Media> filteredMedia = new LinkedList<Media>();
		
		switch(relation)
		{
			case '=':
				if(field.contains("genre"))
				{
					if(target.contains("movie"))
					{
						for(int i = 0; i < mediaList.size(); i++)
						{
							if(mediaList.get(i) instanceof Movie)
							{
								filteredMedia.add(mediaList.get(i));
							}
						}
					}
					else if(target.contains("series"))
					{
						for(int i = 0; i < mediaList.size(); i++)
						{
							if(mediaList.get(i) instanceof Series)
							{
								filteredMedia.add(mediaList.get(i));
							}
						}
					}
				}
				else if(field.contains("title"))
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if(mediaList.get(i).title.contains(target))
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				break;
			case '<':
				if(field.contains("year"))
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if(mediaList.get(i).year < Integer.parseInt(target))
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				else if(field.contains("rating"))
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if(mediaList.get(i).rating < Float.parseFloat(target))
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				break;
			case '>':
				if(field.contains("year"))
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if(mediaList.get(i).year > Integer.parseInt(target))
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				else if(field.contains("rating"))
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if( mediaList.get(i).rating > Float.parseFloat(target))
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				break;
			default:
				System.err.println("Incorrect input.");
				break;
		}
		
		return filteredMedia;
	}
}

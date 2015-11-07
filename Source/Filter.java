import java.util.*;

public class Filter
{	
	String field;
	char relation;
	String target;
	
	public Filter(String field, char relation, String target)
	{
		this.field = field;
		this.relation = relation;
		this.target = target;
		
	}
	
	public List<Media> filteredMedia(List<Media> mediaList, List<Filter> filter)
	{	
		List<Media> filteredMedia = new LinkedList<Media>();
		
		switch(relation)
		{
			case '=':
				if(field == "genre")
				{
					if(target == "movie")
					{
						for(int i = 0; i < mediaList.size(); i++)
						{
							if(mediaList.get(i) instanceof Movie)
							{
								filteredMedia.add(mediaList.get(i));
							}
						}
					}
					else if(target == "series")
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
				else if(field == "title")
				{
					for(int i = 0; i < mediaList.size(); i++)
					{
						if(target == mediaList.get(i).title)
						{
							filteredMedia.add(mediaList.get(i));
						}
					}
				}
				else
				{
					return mediaList;
				}
				break;
			case '<':
				
				break;
			case '>':
				break;
			default:
				return mediaList;
		}
		
		return filteredMedia;
	}
}

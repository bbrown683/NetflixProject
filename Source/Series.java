public class Series extends Media
{
	int season;
	
	public Series(String title, int year, float rating, int season)
	{
		super(title, year, rating);
		
		this.season = season;
	}	
	
	public String toString()
	{
		return "Series Title: " + super.getTitle() + "\nFirst Aired: " + getYear() +
				"\nAverage Rating: " + getRating() + "\nNumber of Seasons: " + season; 
	}
	
}

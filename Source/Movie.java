public class Movie extends Media
{
	String length;
	
	public Movie(String title, int year, float rating, String length)
	{
		super(title, year, rating);
		
		this.length = length;
	}
	
	public String toString()
	{
		return "\nMovie Title: " + super.getTitle() + "\nRelease Date: " + getYear() +
		"Average Rating: " + getRating() + "Length: " + length; 
	}
}

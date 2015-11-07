public class Series extends Media
{
	String length;
	
	public Series(String title, int year, float rating, String length)
	{
		super(title, year, rating);
		
		this.length = length;
	}	
	
	public String toString()
	{
		return "Series Title: " + super.getTitle() + "\nFirst Aired: " + getYear() +
				"\nAverage Rating: " + getRating() + "\nLength: " + length + "\n"; 
	}	
}

// Authors: Benjamin Brown and Jake Jones
// Assignment: Project 2
// Filename: Media.java

public abstract class Media 
{
	String title;
	int year;
	float rating;
	
	public Media(String title, int year, float rating)
	{
		this.title = title;
		this.year = year;
		this.rating = rating;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setRating(float rating)
	{
		this.rating = rating;
	}
	
	public float getRating()
	{
		return rating;
	}
	
	public String toString()
	{
		return "Movie Title: " + title + "\nRelease Date: " + year +
				"\nAverage Rating: " + rating + "\n"; 
	}
}

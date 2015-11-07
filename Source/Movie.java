// Authors: Benjamin Brown and Jake Jones
// Assignment: Project 2
// Filename: Movie.java

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
		return "Movie Title: " + super.getTitle() + "\nRelease Date: " + getYear() +
		"\nAverage Rating: " + getRating() + "\nLength: " + length + "\n"; 
	}
}

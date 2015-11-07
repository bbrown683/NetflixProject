import java.util.*;

public class Filter
{
	String expression;
	
	public Filter(String expression)
	{
		this.expression = expression;
	}
	
	public List<Media> filteredMedia()
	{
		return new LinkedList<Media>();
	}
}

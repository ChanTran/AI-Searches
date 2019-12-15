

public class City {

	private String cityName;
	private int actualDistance;
	private int estimatedDistance;
	
	public City(String name)
	{
		cityName = name;
		actualDistance = 0;
		estimatedDistance = 0;
	}
	public City(String name, int actualDistance)
	{
		cityName = name;
		this.actualDistance = actualDistance;
		estimatedDistance = 0;
	}
	public City(String name, int actualDistance, int estimatedDistance)
	{
		cityName = name;
		this.actualDistance = actualDistance;
		this.estimatedDistance = estimatedDistance;
	}
	public City(City obj2)
	{
		cityName = obj2.cityName;
		actualDistance = obj2.actualDistance;
		estimatedDistance = obj2.estimatedDistance;
	}
	
	public void set(String name, int aDist, int eDist)
	{
		cityName = name;
		actualDistance = aDist;
		estimatedDistance = eDist;
	}
	
	public String getCityName()
	{
		return cityName;
	}
	public int getActualDistance()
	{
		return actualDistance;
	}
	public int getEstimatedDistance()
	{
		return estimatedDistance;
	}
}

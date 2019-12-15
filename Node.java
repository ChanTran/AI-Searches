

public class Node {
	private Node left;
	private Node right;
	private int nodeNum;
	private City city;
	private int depth;
	
	public Node(int num, City city)
	{
		nodeNum = num;
		this.city = new City(city);
		left = null;
		right = null;
	}
	public Node(Node obj)
	{
		nodeNum = obj.getNodeNum();
		this.city = obj.getCity();
		left = obj.getLeft();
		right = obj.getRight();
	}
	
	
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void setNodeNum(int num)
	{
		nodeNum = num;
	}
	public int getNodeNum()
	{
		return nodeNum;
	}
	
	public void setCity(City city)
	{
		this.city = new City(city);
	}
	public City getCity()
	{
		return new City(city);
	}
	
	public void setLeft(Node l)
	{
		left = l;
	}
	public Node getLeft()
	{
		return left;
	}
	public void setRight(Node r)
	{
		right = r;
	}
	public Node getRight()
	{
		return right;
	}
}



public class BestFirstSearchDriver {
	public static void main(String[] args)
	{
		int id = 1;
		BinaryTree tree = new BinaryTree(id++, new City("Philly", 0, 18)); // City, Actual Distance, Estimated Distance
		Node two = new Node(id++, new City("Chicago", 0, 16));
		Node three = new Node(id++, new City("Boston", 0 , 4));
		Node four = new Node(id++, new City("Salt Lake City", 0, 5));
		Node five = new Node(id++, new City("Los Angeles", 0 , 10));
		Node six = new Node(id++, new City("Reading", 0, 3));
		Node seven = new Node(id++, new City("Harrisburg", 0, 2));
		
		//Created the nodes, now adding them to the tree
		System.out.println("Tree Order:");
		tree.add(tree.getRoot(), two, 0);
		tree.add(tree.getRoot(), three, 1);
		tree.add(two, four, 0);
		tree.add(two, five, 1);
		tree.add(three, six, 0);
		tree.add(three, seven, 1);
		tree.printTree();
		
		System.out.println("\nBest First Search for Salt Lake City:");
		tree.bestFirstSearch(tree.getRoot(), "Salt Lake City");
	}
}

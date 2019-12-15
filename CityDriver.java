

public class CityDriver {
	public static void main(String[] args)
	{
		int id = 1;
		BinaryTree tree = new BinaryTree(id++, new City("Philly"));
		Node two = new Node(id++, new City("Chicago"));
		Node three = new Node(id++, new City("Boston"));
		Node four = new Node(id++, new City("Salt Lake City"));
		Node five = new Node(id++, new City("Los Angeles"));
		Node six = new Node(id++, new City("Reading"));
		Node seven = new Node(id++, new City("Harrisburg"));
		
		//Created the nodes, now adding them to the tree
		/*
		* 			1
		* 		/		\
		* 		2		3
		* 	/	\		/		\
		* 4		5		6		7
		* 
		*/
		System.out.println("Tree Order:");
		tree.add(tree.getRoot(), two, 0);
		tree.add(tree.getRoot(), three, 1);
		tree.add(two, four, 0);
		tree.add(two, five, 1);
		tree.add(three, six, 0);
		tree.add(three, seven, 1);
		tree.printTree();
		
		//Performing specific searches
		System.out.println("\nDFS:");
		tree.depthFirstSearch(tree.getRoot());
		System.out.println("\nDFS finding specific node: Looking for Reading");
		tree.depthFirstSearchSpecific(tree.getRoot(), "Reading");
		System.out.println("\nDFS finding specific node: Looking for Salt Lake City");
		tree.depthFirstSearchSpecific(tree.getRoot(), "Salt Lake City");
		System.out.println("\nBFS finding specific node: Looking for Reading");
		tree.breadthFirstSearch(tree.getRoot(), "Reading");
		
	}
}

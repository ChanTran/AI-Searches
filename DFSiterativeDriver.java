

public class DFSiterativeDriver {
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
		System.out.println("Tree Order:");
		tree.add(tree.getRoot(), two, 0);
		tree.add(tree.getRoot(), three, 1);
		tree.add(two, four, 0);
		tree.add(two, five, 1);
		tree.add(three, six, 0);
		tree.add(three, seven, 1);
		tree.printTree();
		
		//Max depth and dfs iterative deepening
		System.out.println("\nDepth of tree:");
		System.out.println(tree.maxDepth(tree.getRoot()));
		tree.setDepth(tree.maxDepth(tree.getRoot()));
		tree.dfsID(tree.getRoot());
		System.out.println();
		tree.dfsIdSteps(tree.getRoot(), "Reading");
	}
}

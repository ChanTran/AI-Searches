
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BinaryTree {
	private Node root;
	private int flag = 0;
	private int depth = 0;
	private boolean goal = false;
	private static int numberNodes;
	
	public BinaryTree(int num, City city){
		root = new Node(num, new City(city));
		numberNodes++;
	}
	
	/*
	 * Add nodes to the binary tree
	 * @param parent - parent node
	 * @param child - child node
	 * @param side - side node is to be placed on
	 */
	public void add(Node parent, Node child, int side)
	{
		if(side == 0)
			parent.setLeft(child);
		else if (side == 1)
			parent.setRight(child);
		numberNodes++;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	/*
	 * 
	 */
	
	public int getDepth()
	{
		return depth;
	}
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/*
	 * Finds the depth of the tree
	 * @param node - feed the root node here
	 */
	public int maxDepth(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int leftDepth = maxDepth(node.getLeft());
		int rightDepth = maxDepth(node.getRight());

		return (Math.max(leftDepth, rightDepth))+1;
	}
	
	/*
	 * Simply prints the tree in the console with the current nodes added in the tree
	 * Format of tree:
	 * 			1
	 * 		/		\
	 * 		2		3
	 * 	/	\		/		\
	 * 4	5		6		7
	 */
	public void printTree()
	{
		Queue<Node> que = new LinkedList<>(); // Use a queue here
		que.add(root);
		while(!que.isEmpty())
		{
			Node nodePop = que.poll(); //Retrieves and removes head of queue
			System.out.println(nodePop.getNodeNum() + ": " + nodePop.getCity().getCityName());
			
			//Now we will look at the left and right nodes and add them to the queue.
			if(nodePop.getLeft() != null)
			{
				que.add(nodePop.getLeft());
			}
			if(nodePop.getRight() != null)
			{
				que.add(nodePop.getRight());
			}
		}
	}
	
	
	/*
	 * Employs estimated distance "heuristic" in order to perform best first search
	 * Uses a PriorityQueue that implements Comparator in order to sort every time a node gets added.
	 * @param node - the root of the tree
	 * @param solution - goal you want to find
	 */
	public void bestFirstSearch(Node node, String solution)
	{
		boolean test = false;
		PriorityQueue<Node> que = new PriorityQueue<Node>(numberNodes, new Comparator<Node>() {
			public int compare(Node node1, Node node2) // This allows Node objects to be compared and sorted, similar to bubble sort..compares until nothing needs to be swapped.
			{
				if(node1.getCity().getEstimatedDistance() > node2.getCity().getEstimatedDistance())
					return 1; // greater
				if(node1.getCity().getEstimatedDistance() < node2.getCity().getEstimatedDistance())
					return -1; // lesser
				return 0; // equal
			}
		});
		que.add(node);
		while(!que.isEmpty())
		{
			Node nodePop = que.poll();
			System.out.println("Transversing through Node #" + nodePop.getNodeNum() + " " + nodePop.getCity().getCityName() + " Heuristic Value: " + nodePop.getCity().getEstimatedDistance());
			if(nodePop.getCity().getCityName().equals(solution))
			{
				System.out.println("Solution found.");
				test = true;
				break;
			}
			if(nodePop.getLeft() != null)
			{
				que.add(nodePop.getLeft());
			}
			if(nodePop.getRight() != null)
			{
				que.add(nodePop.getRight());
			}
		}
		if(!test)
		{
			System.out.println("Solution cannot be found.");
		}
	}
	
	
	/*
	 * Performs DFS (no solution, just shows transverse of whole tree)
	 * Uses recursion, dives all of left first.
	 * @param node - root
	 */
	public void depthFirstSearch(Node node) // give it the root here
	{
		if(node != null)
		{
			System.out.println("Searching..#" + node.getNodeNum() + ": " + node.getCity().getCityName());
			depthFirstSearch(node.getLeft());
			depthFirstSearch(node.getRight());
		}
	}
	
	/*
	 * dfsID and dfs goes hand in hand, performs DFS iterative deepening
	 * Uses the depth variable defined above in order keep track about what depth we're on. 
	 * Goes through left recursion and checks length every time until base case, then goes on to do the right.
	 * @param node - root
	 */
	public void dfsID(Node node)
	{
		for(int i = 1; i <= depth; i++)
		{
			System.out.println("Depth " + (i-1) + ":");
			dfs(node, i);
		}
	}
	public void dfs(Node node, int length)
	{
		if(length <= 0)
			return;
		if(node != null)
		{
			System.out.println("Node #" + node.getNodeNum() + " " + node.getCity().getCityName());
			dfs(node.getLeft(), length-1);
			dfs(node.getRight(), length-1);
		}
	}
	
	/*
	 * Use this method if you want to find a specific node
	 * Uses recursion to go all of left first before going right
	 * @param cityName - goal/solution to be found
	 * @param node - root
	 */
	public void depthFirstSearchSpecific(Node node, String cityName) // give it the root here
	{
		if(node != null)
		{
			if(node.getCity().getCityName().equals(cityName))
			{
				System.out.println("Searching..#" + node.getNodeNum() + ": " + node.getCity().getCityName());
				System.out.println("DFS found " + cityName + " at node #" + node.getNodeNum());
				flag = 1;
			}
			else if(flag == 0)
			{
				System.out.println("Searching..#" + node.getNodeNum() + ": " + node.getCity().getCityName());
				depthFirstSearchSpecific(node.getLeft(), cityName);
				depthFirstSearchSpecific(node.getRight(), cityName);
			}
		}
		if(node != null && (node.getNodeNum() == root.getNodeNum()))
		{
			flag = 0; //reset flag after search is done
		}
	}
	
	/*
	 * Performs breadth first search, searches level by level for solution
	 * Uses a queue -> FIFO
	 * @param cityName - solution
	 * @param node - put root here
	 */
	public void breadthFirstSearch(Node node, String cityName)
	{
		Queue<Node> que = new LinkedList<>(); // Use a queue here
		que.add(root);
		while(!que.isEmpty())
		{
			Node nodePop = que.poll(); //Retrieves and removes head of queue
			System.out.println("Searching..#" + nodePop.getNodeNum() + ": " + nodePop.getCity().getCityName());
			if(nodePop.getCity().getCityName().equals(cityName))
			{
				System.out.println("BFS found " + cityName + " at node #" + nodePop.getNodeNum());
				break;
			}
			//Now we will look at the left and right nodes and add them to the queue.
			if(nodePop.getLeft() != null)
			{
				que.add(nodePop.getLeft());
			}
			if(nodePop.getRight() != null)
			{
				que.add(nodePop.getRight());
			}
		}
	}
	
	/*
	 *  A minor different way of performing dfs and dfs iterative deepening
	 *  Uses Stack class instead of recursion in order to push and pop nodes (Last in first out basis)
	 * @param node - root
	 * @param target - solution/goal
	 */
	public void dfsIdSteps(Node node, String target)
	{
		System.out.println("Searching for " + target + "..");
		int currentDepth = 0;
		while(!goal)
		{
			System.out.println("\nDepth " + currentDepth);
			Stack<Node> stack = new Stack<>();
			ArrayList<Node> list = new ArrayList<>();
			node.setDepth(0);
			stack.push(node); // to the top
			while(!stack.isEmpty())
			{
				Node popped = stack.pop();
				list.add(popped);
				for(int i = 0; i < list.size(); i++)
				{
					System.out.println(" (Node #" + list.get(i).getNodeNum() + " " + list.get(i).getCity().getCityName() + ")");
				}
				System.out.println();
				if(popped.getCity().getCityName().equals(target))
				{
					return;
				}
				if(popped.getDepth() >= currentDepth)
				{
					continue;
				}	
				if(popped.getRight() != null)
				{
					Node right = popped.getRight();
					right.setDepth(popped.getDepth()+1);
					stack.push(right);
				}
				if(popped.getLeft() != null)
				{
					Node left = popped.getLeft();
					left.setDepth(popped.getDepth()+1);
					stack.push(left);
				}
			}
			currentDepth++;
			if(currentDepth >= depth)
			{
				goal = true;
				System.out.println("\nTarget cannot be found.");
			}
		}
		goal = false;
	}
	
}

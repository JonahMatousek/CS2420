package assign08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.xml.crypto.NodeSetData;



/**
 * 
 * @author Daniel Kopta && Casey Parker && Jonah Matousek
 * 
 * This Graph class acts as a starting point for your maze
 *         path finder. Add to this class as needed.
 */
public class Graph {

	// The graph itself is just a 2D array of nodes
	private Node[][] nodes;

	// The node to start the path finding from
	private Node start;

	// Store data of visited current node along with previous node
	private HashMap<Node, Boolean> visited;

	// The size of the maze
	private int width;
	private int height;

	/**
	 * Constructs a maze graph from the given text file.
	 * 
	 * @param filename - the file containing the maze
	 * @throws Exception
	 */
	public Graph(String filename) throws Exception {
		BufferedReader input;
		input = new BufferedReader(new FileReader(filename));

		if (!input.ready()) {
			input.close();
			throw new FileNotFoundException();
		}

		// read the maze size from the file
		String[] dimensions = input.readLine().split(" ");
		height = Integer.parseInt(dimensions[0]);
		width = Integer.parseInt(dimensions[1]);
		visited = new HashMap<Node, Boolean>();

		// instantiate and populate the nodes
		nodes = new Node[height][width];
		for (int i = 0; i < height; i++) {
			String row = input.readLine().trim();

			for (int j = 0; j < row.length(); j++)
				switch (row.charAt(j)) {
				case 'X':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isWall = true;
					break;
				case ' ':
					nodes[i][j] = new Node(i, j);
					break;
				case 'S':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isStart = true;
					start = nodes[i][j];
					break;
				case 'G':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isGoal = true;
					break;
				default:
					throw new IllegalArgumentException("maze contains unknown character: \'" + row.charAt(j) + "\'");
				}
		}
		input.close();
	}

	/**
	 * Outputs this graph to the specified file. Use this method after you have
	 * found a path to one of the goals. Before using this method, for the nodes on
	 * the path, you will need to set their isOnPath value to true.
	 * 
	 * @param filename - the file to write to
	 */
	public void printGraph(String filename) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(height + " " + width);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					output.print(nodes[i][j]);
				}
				output.println();
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	

	/**
	 * Traverse the graph with BFS (shortest path to closest goal)
	 * A side-effect of this method should be that the nodes on the path
	 * have had their isOnPath member set to true.
	 * @return - the length of the path
	 */
	public int CalculateShortestPath()
	{	
		start.isOnPath = true;
		if(start.isGoal)
			return 0;
		
		int length = 0;
		Node current = start;
		Queue<Node> q = new LinkedList<>();
		q.add(current);
		visited.put(current,true);
		while(!q.isEmpty()) {
			current = q.poll();
			current.isOnPath = true;
			if(current.isGoal)
				return length;
			
			getNeighbors(current,nodes);
			for(Node i : current.neighbors) {
				q.add(i);
				visited.put(i,true);
			}
			
			
			
		}
		
			
		return 0;
	}
	
	private void getNeighbors(Node node,Node[][] nodes) {
		Set<Node> neighbors = new HashSet<Node>();
		
		neighbors.add(nodes[node.row+1][node.col]);
		neighbors.add(nodes[node.row-1][node.col]);
		neighbors.add(nodes[node.row][node.col+1]);
		neighbors.add(nodes[node.row][node.col-1]);
		for(Node i:neighbors) {
			if(i.isWall)
				neighbors.remove(i);
		}
		node.neighbors = neighbors;
		
	}
	
	
	
	/**
	 * Traverse the graph with DFS (any path to any goal) A side-effect of this
	 * method should be that the nodes on the path have had their isOnPath member
	 * set to true.
	 * 
	 * @return - the length of the path
	 */
	public int CalculateAPath() 
		{
			int length = 0;
			if (start.isGoal == true)
				return length;

			Stack<Node> stack = new Stack<>();
			stack.push(start);

			while (!stack.empty()) {
				Node temp = stack.pop();
				

				if (!visited.get(temp)) {
					temp.isOnPath = true;
					visited.put(temp, true);
				}
				
				getNeighbors(temp,nodes);
				
				for(Node i:temp.neighbors) {
					Node temp1 = i;
					if(!visited.get(temp1));
					stack.push(temp1);
					//temp1.isOnPath = true;
					length++;
				}

			}
			visited = new HashMap<Node,Boolean>();
			return length;
		}
		
	

	/**
	 * @author Daniel Kopta A node class to assist in the implementation of the
	 *         graph. You will need to add additional functionality to this class.
	 */
	private static class Node {
		// The node's position in the maze
		private int row, col;

		// The type of the node
		private boolean isStart;
		private boolean isGoal;
		private boolean isOnPath;
		private boolean isWall;
		private Set<Node> neighbors;

		// TODO: You will undoubtedly want to add more members and functionality to this
		// class.

		public Node(int r, int c) {
			isStart = false;
			isGoal = false;
			isOnPath = false;
			row = r;
			col = c;
			neighbors = new HashSet<>();

		}
		
		

		@Override
		public String toString() {
			if (isWall)
				return "X";
			if (isStart)
				return "S";
			if (isGoal)
				return "G";
			if (isOnPath)
				return ".";
			return " ";
		}
	}

}

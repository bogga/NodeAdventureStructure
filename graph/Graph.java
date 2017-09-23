package graph;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Graph{

	private HashMap<String, Node<?>> nodes;
	private HashMap<Node<?>, HashMap<Node<?>, Integer>> connections;
	//private HashMap<Node<?>, HashMap<Node<?>, HashSet<Node<?>>>> shortestRoute;

	/**
	 * Creates a graph with no nodes
	 */
	public Graph(){
		nodes = new HashMap<>();
		connections = new HashMap<>();
	}

	/**
	 * Creates a graph populated with the specified (all of them are disconnected)
	 * 
	 * @param nodes
	 *          Nodes to be added to the graph
	 */
	public Graph(Node<?>... nodes){
		for (Node<?> node : nodes){
			addNode(node);
		}
		connections = new HashMap<>();
	}

	/**
	 * Creates a graph populated with the specified (all of them are disconnected)
	 * 
	 * @param output
	 *          The writer where the results of adding the node is going to be
	 *          displayed
	 * @param nodes
	 *          Nodes to be added to the graph
	 * @throws IOException
	 */
	public Graph(Writer output, Node<?>... nodes) throws IOException{
		for (Node<?> node : nodes){
			output.write("The addition of " + node.getName() + " was " + (addNode(node) ? "" : "not") + " succesfull");
		}
	}

	/**
	 * Add a new node to the graph. If the name of the node is already present the
	 * method fails.
	 * 
	 * @param node
	 *          Node to be added
	 * @return The success of the addition
	 */
	public boolean addNode(Node<?> node){
		if (nodes.containsKey(node.getName()) && connections.containsKey(node)){
			connections.put(node, new HashMap<>());
			return true;
		}
		return false;
	}

	/**
	 * Creates a one-way connection from node a to node b
	 * 
	 * @param a
	 *          The node that the edge comes out of
	 * @param b
	 *          The node that the edge goes into
	 * @param distance
	 *          distance between them
	 * @param override
	 *          should the connection between a and b exists setting this to true
	 *          overrides the existing connection
	 * @return Success of the connection
	 */
	public boolean connectAtoB(Node<?> a, Node<?> b, int distance, boolean override){
		if (nodes.containsKey(a.getName()))
			addNode(a);
		if (nodes.containsKey(b.getName()))
			addNode(b);
		if (connections.get(a).containsKey(b)){
			if (!override){
				return false;
			}
		}
		connections.get(a).put(b, distance);
		return true;
	}

	/**
	 * Creates a two-way connection from node a to node b
	 * 
	 * @param a
	 *          The node that the edge comes out of
	 * @param b
	 *          The node that the edge goes into
	 * @param distance
	 *          distance between them
	 * @param override
	 *          should the connection between a and b exists setting this to true
	 *          overrides the existing connection
	 * @return Success of the connection
	 */
	public boolean connectAandB(Node<?> a, Node<?> b, int distance, boolean override){
		return (connectAtoB(a, b, distance, override) && connectAtoB(b, a, distance, override));
	}

	protected Node<?>[] getConnectionsOf(Node<?> a){
		return (Node<?>[]) connections.get(a).keySet().toArray();
	}

	/**
	 * Returns the names of all the nodes out degree connections of the specified
	 * node
	 * 
	 * @param name
	 *          Name of the node's connections we want to get
	 * @return an array containing all the names this nodes is connected to
	 */
	public String[] getConnectionsOf(String name){
		Node<?>[] nodeS = getConnectionsOf(nodes.get(name));
		String[] ns = new String[nodeS.length];
		for (int i = 0; i < nodeS.length; i++){
			ns[i] = nodeS[i].getName();
		}
		return ns;
	}

	@Deprecated
	protected Integer getDistanceBetweenAandB(Node<?> a, Node<?> b){
		Integer distance = connections.get(a).get(b);
		return distance == null ? -1 : distance;
	}

	@Deprecated
	/**
	 * Retrieve the distance between node A and node A
	 * 
	 * @param a
	 *          - Name of A
	 * @param b
	 *          - Name of B
	 * @return The distance between nodes
	 */
	public Integer getDistanceBetweenAandB(String a, String b){
		Node<?> A, B;
		if ((A = nodes.get(a)) == null)
			return -1;
		if ((B = nodes.get(b)) == null)
			return -1;
		return getDistanceBetweenAandB(A, B);
	}

	/**
	 * Returns the name of the closest node or "String not found" if the node is
	 * non-existent
	 * 
	 * @param nodeName
	 *          - Name of the node whose closes neighbor's name we want to know
	 * @return The name of the closest neighbor
	 */
	public String getClosest(String nodeName){
		// check if a node with such a name exists
		Node<?> node = nodes.get(nodeName);
		return (node == null) ? "String not found" : getClosest(node).getName();
	}

	protected Node<?> getClosest(Node<?> node){
		Node<?>[] closestNodes = getConnectionsOf(node);
		Node<?> closest = closestNodes[0];
		// int closestDistance = -1;

		for (int i = 0; i < closestNodes.length; i++){
			// compares the distance to the closest and the next in line for check
			if (connections.get(node).get(closest) < connections.get(node).get(closestNodes[i])){
				closest = closestNodes[i];
				// closestDistance = connections.get(node).get(closestNodes[i]);
			}
		}
		return closest;
	}

	/**
	 * Get the distance between all the nodes in the specified order. Should there
	 * be a node that is not connected to the next in the list the method returns
	 * -1. Loops will also return -1
	 * 
	 * @param ns
	 *          Path described as sequence of node names
	 * @return distance from the first to the last node
	 */
	public Integer getDistanceOf(String... ns){
		HashSet<Node<?>> path = new HashSet<>();
		// construct
		for (String n : ns){
			Node<?> node = nodes.get(n);
			if (node == null || path.add(node))
				return -1;
		}

		return getDistanceOf(path);
	}

	protected Integer getDistanceOf(HashSet<Node<?>> path){
		Integer distance = 0;
		Node<?> previous = null;

		Iterator<Node<?>> it = path.iterator();
		previous = it.next();
		
		do{
			Node<?> current = it.next();
			// distance between previous and current if they are connected
			Integer dist = connections.get(previous).get(current);

			// if they are not connected
			if (dist == null)
				return -1;
			else
				distance += dist;

			previous = current;
		
		} while (it.hasNext());
		
		return distance;
	}

	public Node<?> getNode(String name) {
		return nodes.get(name);
	}
	
//	public void Dijkstra() {
//		String[] keys = (String[]) nodes.keySet().toArray();
//		
//	}
}

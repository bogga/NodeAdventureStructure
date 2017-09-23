package graph;

public class Node<T> {

	private static char letter = 'A';

	private String name;
	private T value;
	// private HashMap<Connectable, Integer> connections;

	public Node(String name, T v){
		this.name = name;
		value = v;
		// connections = new HashMap<>(conns);
	}

	public Node(String name){
		this(name, null);
	}

	public Node(T value){
		this("" + letter++, value);
	}

	public Node(){
		this("" + letter++, null);
	}

	public String getName(){
		return new String(name);
	}

	public void rename(String n){
		name = n;
	}

	public T getValue(){
		return value;
	}

	public void changeValue(T v){
		value = v;
	}

	public String getType(){
		return value.getClass().getName();
	}
}

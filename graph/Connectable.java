package graph;

public interface Connectable{

	void connect(int distance, Node<?> node);

	void disconnect(Node<?> node);

}

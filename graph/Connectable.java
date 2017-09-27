package graph;

public interface Connectable{

	void connect(int distance, Connectable node);

	void disconnect(Connectable node);

}

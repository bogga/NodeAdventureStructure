package graph;

import java.util.HashSet;
import java.util.Iterator;

public class Driver{

	public static void main(String[] args){
		Node<Integer> nodeA = new Node<Integer>("A", 20);
		HashSet<Node<?>> set = new HashSet<>();
		set.add(nodeA);
		set.add(new Node<String>("B", "my name jeff"));
		for (Iterator<Node<?>> it = set.iterator(); it.hasNext();){
			Node<?> node = it.next();
			System.out.println(node.getName() + "  " + node.getValue());
		}

	}

}

import java.util.Scanner;
import java.util.ArrayList;

public class Node{
	String displayText;
	String mainText;
	ArrayList<Node> options = new ArrayList<Node>();

	public Node(String display, String main){
		displayText = display;
		mainText = main;
	}

	public void addOption(Node option){
		options.add(option);
	}

	public void addOption(Node option, String displayText){
		option.displayText = displayText;
		options.add(option);
	}

	public void addOption(ArrayList<Node> option){
		options.addAll(option);
	}

	public void display(){
		System.out.println("==== ==== ====");
		System.out.println(mainText);

		if (options.size() > 0)
			for (int i = 0; i < options.size(); i++)
				System.out.println((i + 1) + ": " + options.get(i).displayText);
		else
			System.out.println("There aren't any options here!");

		System.out.println("==== ==== ====");
	}

	public Node choose(){
		display();

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt() - 1;
		return options.get(choice);
	}

	public Node clone(){
		Node node = new Node(displayText, mainText);
		node.addOption(options);

		return node;
	}
}

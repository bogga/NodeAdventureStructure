import java.util.Scanner;
import java.util.ArrayList;

public class Node
{
  String displayText;
  String mainText;
  ArrayList<Node> options = new ArrayList<Node>();

  public Node(String display, String main)
  {
    displayText = display;
    mainText = main;
  }

  public void addOption(Node option)
  {
    options.add(option);
  }

  public void addOption(ArrayList<Node> option)
  {
    options.addAll(option);
  }

  public void display()
  {
    System.out.println(mainText);

    for (int i = 0; i < options.size(); i++)
        System.out.println(i + ": " + options.get(i).displayText);
  }

  public int choose()
  {
    display();

    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}

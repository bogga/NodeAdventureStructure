public class Node
{

  String displayText;
  String mainText;
  List<Node> options;

  public Node(String display, String main)
  {
    displayText = display;
    mainText = main;
  }

  public void addOption(Node option)
  {
    options.add(option);
  }

  public void addOption(List<Node> option)
  {
    options.addAll(option);
  }
}

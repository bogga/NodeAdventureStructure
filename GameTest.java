public class GameTest
{
  public static void main(String[] args)
  {
    Node start = new Node("Go right", "You reach a clearing in the forest. It has two paths!");
    Node startLeft = new Node("Go left", "You went left! Shame, as this is a dead end");
    Node startRight = start;

    start.addOption(startLeft);
    start.addOption(startRight);

    start.display();
  }
}

public class GameTest
{
  public static void main(String[] args)
  {
    boolean playing = true;

    Node start = new Node("", "You reach a clearing in the forest. It has two paths!");
    Node startLeft = new Node("Go left", "You went left! Shame, as this is a dead end");
    Node startRight = new Node("Go right", "You reach a clearing in the forest. It has two paths!");

    start.addOption(startLeft);
    start.addOption(startRight);
    startRight.addOption(start.options);
    startLeft.addOption(start, "Go back");
    Node leftDie = new Node("Run into the bushes", "You ran into a bear's open mouth and died!");
    startLeft.addOption(leftDie);
    startLeft.addOption(startLeft.clone(), "Do nothing");

    Node current = start;

    while (playing)
      current = current.choose();
  }
}

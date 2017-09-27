package game;

@FunctionalInterface
public interface Action{
 
	/**
	 * Executes an action 
	 * @param board THe board the game is played on
	 * @return return a number of a choice(should the action lead to one)
	 */
	public int doIt(GameBoard board);
}

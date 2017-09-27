package game;

public abstract class Occurrence{
	
	public final float chance;
	public final String initText;
	protected ActionTree actionTree;
	
	protected final GameBoard board;
	
	/**
	 * Create a new occurrence 
	 * @param chance the chance of the occurrence happening
	 * @param initText text that appears when this occurs 
	 */
	protected Occurrence(float chance, String initText, ActionTree actionTree2, GameBoard board) {
		this.chance = chance;
		this.initText = initText;
		this.actionTree = actionTree2;
		this.board = board;
	}
	
	public abstract void occur();
	
	public abstract void end();
}

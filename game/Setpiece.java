package game;

public abstract class Setpiece{
	public final String name;
	private final String displayText;
	private final String mainText;

	private Setpiece[] connections;

	public Setpiece(String name, String display, String main){
		this.name = name;
		displayText = display;
		mainText = main;
		connections = new Setpiece[4];
	}

}

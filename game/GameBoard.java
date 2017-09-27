package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GameBoard{

	public final Character hero;
	public final ArrayList<Setpiece> setPieces;
	private Setpiece currentPlace;
	private Occurrence currentOccurrence;
	
	private Character[] npcs;

	public GameBoard(Character hero, ArrayList<Setpiece> setpieces, String start) throws NoSuchElementException{
		this.hero = hero;
		this.setPieces = setpieces;
		npcs = new Character[3];
		currentOccurrence = null;

		for (Iterator<Setpiece> iterator = setPieces.iterator(); iterator.hasNext();){
			Setpiece p = iterator.next();
			if (p.name == start){
				currentPlace = p;
				break;
			}
		}

		if (currentPlace == null)
			throw new NoSuchElementException("No such set piece exists");
	}

	public void addNpc(Character npc) throws IndexOutOfBoundsException{
		for (int i = 0; i < npcs.length; i++){
			if (npcs[i] == null){
				npcs[i] = npc;
				return;
			}
		}

		throw new IndexOutOfBoundsException("Way too many character in scene");
	}
	
	public void changeOccurrence(Occurrence occ) {
		currentOccurrence = occ;
	}
	
	public Occurrence currentOccurrence() {
		return currentOccurrence;
	}
}

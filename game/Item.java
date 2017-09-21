package game;

public abstract class Item implements Stats{

	public final String name;
	//private int[] stats;

	/**
	 * Creates an item with the specified characteristics
	 * 
	 * @param name
	 *          name of item
	 * @param statType
	 *          the type of the status the item has
	 * @param value
	 *          the value of the stat
	 */
	public Item(String name,int hp,  int atk, int def, int reflex){
		this.name = name;
		//stats = new int[4];
		
		basicStats[HP] = hp;
		basicStats[ATK] = atk;
		basicStats[DEF] = def;
		basicStats[REF] = reflex;
	}
	
	public int[] getStats() {
		return basicStats.clone();
	}

	@Override
	public void increseStat(int statType, int value){
		basicStats[statType] += value;
	}

	@Override
	public void decreseStat(int statType, int value){
		basicStats[statType] -= value;
	}
}

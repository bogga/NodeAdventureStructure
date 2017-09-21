package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Character implements Stats{


	ArrayList<Item> items;

	/**
	 * Creates a new character with randomized stats
	 */
	public Character(){
		
		Random rand = new Random();
		for (int i = 0; i < basicStats.length; i++){
			basicStats[i] = rand.nextInt(10);
		}

		items = new ArrayList<>();
	}

	/**
	 * Retrieves the stats of the character
	 * 
	 * @return a String of the name of the stat and its value
	 */
	public String getStats(){
		return "HP " + basicStats[Stats.HP] + " ATK " + basicStats[Stats.ATK] + " DEF " + basicStats[Stats.DEF] + " REFLEX "
				+ basicStats[Stats.REF];
	}

	/**
	 * Adds a new item to the character and increases his stats
	 * 
	 * @param newItem
	 *          item to be added
	 */
	public void addItem(Item newItem){
		int[] itemStats = newItem.getStats();

		for (int i = 0; i < itemStats.length; i++){
			increseStat(i, itemStats[i]);
		}

		items.add(newItem);
	}

	/**
	 * Drops a specified item and decreases the character's stats
	 * 
	 * @param itemName
	 *          name of the item to be dropped
	 * @return the dropped item
	 */
	public Item dropItem(String itemName){
		for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();){
			Item item = iterator.next();

			if (item.name == itemName){
				int[] itemStats = item.getStats();
				for (int i = 0; i < itemStats.length; i++){
					decreseStat(i, itemStats[i]);
				}
				items.remove(item);
				return item;
			}
		}

		return null;
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

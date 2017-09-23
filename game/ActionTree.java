package game;

import graph.Graph;
import graph.Node;

public class ActionTree extends Graph{

	/**
	 * The idea is that this class would add the type of generic protection (cuz i
	 * still don't know much about gennerics)
	 * 
	 */
	public ActionTree(){
		super();
	}

	/**
	 * Add a new action to the tree
	 * @param node Action to be added to the tree
	 * @return tru if the addition is successful
	 */
	public boolean addAction(Node<? extends Action> node){
		return super.addNode(node);
	}

	/**
	 * Retrieve an Action from the tree 
	 * @param name The name of the Action
	 * @return An Action corresponding to the specified name
	 */
	public Action getAction(String name){
		return (Action) getNode(name).getValue();
	}

	/**
	 * Make a choice how to forward the story
	 * @param name Name of the current action you are in
	 * @param choice number of the choice you have made
	 * @return THe action that you have picked
	 */
	public Action makeAChoice(String name, int choice){
		Node<?> curr = getNode(name);
		Node<?>[] connected = getConnectionsOf(curr);
		
		for (int i = 0; i < connected.length; i++)
			if (choice == getDistanceOf(curr.getName(), connected[i].getName()))
				return (Action) connected[i].getValue();

		return null;
	}

	@Override
	@Deprecated
	public boolean addNode(Node<?> node){
		try{
			throw new Exception("Don't use this method from this class");
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

}

package game;

import java.util.Random;
import java.util.Scanner;

import graph.Node;

public class Ambush extends Occurrence{

	Character ambusher;

	public Ambush(float chance, String initText, ActionTree actionTree, GameBoard board){
		super(chance, initText, actionTree, board);
		board.addNpc((ambusher = new Character("gayASS Ambusher")));
	}

	@Override
	public void occur(){
		System.out.println("!!!!Suddenly le wild " + ambusher.name + " lunges forward to attack you !!!!");
		if (ambusher.getStat(Stats.REF) < board.hero.getStat(Stats.REF)){
			System.out.println("unfortunately you are not fast enough to doge it");

			Scanner scanner = new Scanner(System.in);
			while (true){

				System.out.println("you have 2 options:");
				System.out.println("1 - defflect with your sword(-2 attack)");
				System.out.println("2 - deflect with your shield(-2 deff)");

				int answer = scanner.nextInt();
				if (answer == 1){
					board.hero.decreseStat(Stats.ATK, 2);
					System.out.println("you lost 2 attack");
					break;
				} else if (answer == 2){
					board.hero.decreseStat(Stats.DEF, 2);
					System.out.println("you lost 2 deffence");
					break;
				}
				System.out.println("NO you cant do that");
			}
		} else
			System.out.println("fortunately for you " + ambusher.name + " wasn't fast enough and you dodge it");

		System.out.println("You look at your foe. He looks like a formidable foe:\n" + ambusher.getStats());

	}

	@Override
	public void end(){

	}

	public void buildActionTree(){
		actionTree.addAction(
				new Node<Action>("Start", () -> System.out.println("====SUDDENLY====\nle wild " + ambusher.name + " appears")));
		actionTree.addAction(new Node<Action>("Dodge", () -> {
			if (ambusher.getStat(Stats.REF) < board.hero.getStat(Stats.REF)){
				System.out.println("unfortunately you are not fast enough to doge it");
				Scanner scanner = new Scanner(System.in);
				while (true){

					System.out.println("you have 2 options:");
					System.out.println("1 - defflect with your sword(-2 attack)");
					System.out.println("2 - deflect with your shield(-2 deff)");

					int answer = scanner.nextInt();
					if (answer == 1){
						board.hero.decreseStat(Stats.ATK, 2);
						System.out.println("you lost 2 attack");
						break;
					} else if (answer == 2){
						board.hero.decreseStat(Stats.DEF, 2);
						System.out.println("you lost 2 deffence");
						break;
					}
					System.out.println("NO you cant do that");
				}
			} else
				System.out.println("fortunately for you " + ambusher.name + " wasn't fast enough and you dodge it");

		}));

	}

	public String battle(Character hero, Character ambusher){
		Random rand = new Random();
		int dmg;
		if (hero.getStat(Stats.REF) * rand.nextInt(10) > ambusher.getStat(Stats.REF) * rand.nextInt(10)){
			dmg = hero.getStat(Stats.ATK) - ambusher.getStat(Stats.DEF) / 3;
			if (dmg > 0)
				ambusher.decreseStat(Stats.HP, dmg);
			else
				System.out.println("Eventhough you were faster and landed a hit your foe seams undammaged");
		} else{
			dmg = hero.getStat(Stats.ATK) - ambusher.getStat(Stats.DEF) / 3;
			if (dmg > 0)
				;
		}
		return "";
	}

}

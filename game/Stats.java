package game;

interface Stats{
	static int HP = 0;
	static int ATK = 1;
	static int DEF = 2;
	static int REF = 3;
	
	int[] basicStats = new int[4];
	
	public void increseStat(int statType, int value);
	public void decreseStat(int statType, int value);
}

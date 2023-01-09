package game;

public class You {
	
	static public int hp = 100;
	static public int mp = 100;
	int power = 10;
	
	public void skil() {
		power=power*2;
		mp-=20;
	};

}

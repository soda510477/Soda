
public class Minions extends Monster {
	String[] names = {"¤p­ô¥¬ªL","¥vµÜ©i","¤p¾uÅ\","¤ì§¯","½v±aªÎªÎ","¤T²´³¹³½"};
	public Minions() {
		setName(names[floor]);
		setHealth(30);
		setAttack(3);
		setDefend(1);
		addHealth(20*floor);
		addAttack(floor);
		addDefend(floor);
	}
	public Minions(String n, int h,int a,int d) {
		super(n, h, a, d);
		addHealth(20*floor);
		addAttack(floor);
		addDefend(floor);
	}
}


public abstract class Creature {
	public static int species;
	protected String name;
	protected int health;
	protected int attack;
	protected int defend;
	public static int floor = 1;
	public Creature() {
	}
	public Creature(String n,int h, int a, int d) {
		setName(n);
		setHealth(h);
		setAttack(a);
		setDefend(d);
	}
	
	protected void setName(String n) {
		name = n;
	}
	protected void setHealth(int h) {
		health = h;
	}
	protected void setAttack(int a) {
		attack = a;
	}
	protected void setDefend(int d) {
		defend = d;
	}
	protected String getName() {
		return name;
	}
	protected int getHealth() {
		return health;
	}
	protected int getAttack() {
		return attack;
	}
	protected int getDefend() {
		return defend;
	}
	protected void addHealth(int h) {
		health = health + h;
	}
	protected void addAttack(int a) {
		attack = attack + a;
	}
	protected void addDefend(int d) {
		defend = defend + d;
	}
}

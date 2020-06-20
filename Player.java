
public class Player extends Creature {
	protected int money;
	public Player() {
	}
	public Player(String n, int h,int a,int d,int m) {
		super(n, h, a, d);
		setMoney(m);
	}
	protected void setMoney(int m) {
		money = m;
	}
	protected int getMoney() {
		return money;
	}
	protected void addMoney(int m) {
		money = money + m;
	}
}


public class Boss extends Monster {
	public Boss(String n, int h,int a,int d) {
		super(n, h, a, d);
		addHealth(60*floor);
		addAttack(3*floor);
		addDefend(3*floor);
	}
}


public class Human extends Player {
	Human (String n,int h, int a, int d, int m) {
		super(n, h, a, d, m);
		addAttack(3);
		addDefend(3);
	}
}

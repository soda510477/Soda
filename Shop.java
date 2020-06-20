
public class Shop extends Option {
	public void buyAttack() {
		setMoney(money-25);
		addAttack(1);
	}
	public void buyHealth() {
		setMoney(money-25);
		addHealth(20);
	}
	public void buyDefend() {
		setMoney(money-25);
		addDefend(1);
	}
}

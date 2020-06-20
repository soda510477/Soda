import java.util.ArrayList;

public class Option extends Player {
	static ArrayList<Player> player = new ArrayList<Player>();
	public boolean addPlayer(Player p) {
    	player.add(p);
        return true;
    }
	public Player getPlayer(int i) {
		return player.get(i);
	}
}

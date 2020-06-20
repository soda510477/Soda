import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class BattleGUI extends JFrame {
	private Container cp;
	private JButton continueButton;
	private JTextArea textarea;
	public Player player;
	public Monster monster;
	public int fail;
	public GUI2 g;
	public BattleGUI(Player player){
		setTitle("�԰�����");
		setSize(300,500);
		setLocation(100,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		continueButton = new JButton("�~��");
		textarea = new JTextArea(20,20);
				
		cp = getContentPane();
		cp.setLayout(new BorderLayout(20,30));
		
		JPanel textpan = new JPanel();
		textpan = new JPanel(new FlowLayout());
		textpan.setBorder(BorderFactory.createTitledBorder("�԰���T"));
		
		textpan.add(new JScrollPane(textarea));
		cp.add(textpan);
		cp.add(continueButton,BorderLayout.SOUTH);
		
		continueButton.addActionListener(new continuebutton());
		
		textarea.append(player.getName()+"�Ө�F"+"��"+1+"�h"+"\n");
		monster = new Minions();
		int playerHealth = player.getHealth();
		int monsterHealth = monster.getHealth();
		do {
			if(player.getAttack()-monster.getDefend() <= 0) {
				monsterHealth = monsterHealth - 1;
				textarea.append(player.getName()+"��"+monster.getName()+"�y���F1�I�ˮ`"+"\n");
				if(monsterHealth <= 0) {
					break;
				}
			}
			else {
				monsterHealth = monsterHealth - (player.getAttack()-monster.getDefend());
				textarea.append(player.getName()+"��"+monster.getName()+"�y���F"+(player.getAttack()-monster.getDefend())+"�I�ˮ`"+"\n");
				if(monsterHealth <= 0) {
					break;
				}
			}
			if(monster.getAttack()-player.getDefend() <= 0) {
				playerHealth = playerHealth - 1;
				textarea.append(monster.getName()+"��"+player.getName()+"�y���F1�I�ˮ`"+"\n");
				if(playerHealth <= 0) {
					break;
				}
			}
			else {
				playerHealth = playerHealth - (monster.getAttack()-player.getDefend());
				textarea.append(monster.getName()+"��"+player.getName()+"�y���F"+(monster.getAttack()-player.getDefend())+"�I�ˮ`"+"\n");
				if(playerHealth <= 0) {
					break;
				}
			}
		} while(playerHealth > 0 & monsterHealth > 0);
		if (playerHealth>0) {
			textarea.append(player.getName()+"�����F"+monster.getName()+"��o�F100��"+"\n");
			player.addMoney(100);
			Creature.floor = Creature.floor + 1;
			textarea.append(Integer.toString(Creature.floor));
		}
		else {
			textarea.append(monster.getName()+"�����F"+player.getName()+"\n");
			continueButton.setText("�C������");
			fail=1;
		}
	}
	private class continuebutton implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			if (fail == 1) {
				System.exit(0);
			}
			else {
				setVisible(false);
				revalidate();
				//System.out.println(Creature.floor);
				g.revalidate();
				g.setVisible(true);
			}
		}
	}
}

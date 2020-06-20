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

public class GUI2 extends JFrame{
	private Container cp;
	private JLabel nameLabel, hpLabel, atkLabel, defLabel, nm, hp, atk, def,layer;
	private JButton shopButton, battleButton, exitButton, optionButton;
	public Player player;
	public GUI2(Player player){	
		setTitle("主頁面");
		setSize(300,500);
		setLocation(100,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameLabel = new JLabel("名稱:");
		hpLabel = new JLabel("生命值:");
		atkLabel = new JLabel("攻擊力:");
		defLabel = new JLabel("防禦力:");
		nm = new JLabel(player.getName());
		hp = new JLabel(Integer.toString(player.getHealth()));
		atk = new JLabel(Integer.toString(player.getAttack()));
		def = new JLabel(Integer.toString(player.getDefend()));
		
		layer = new JLabel("第"+Integer.toString(1)+"層",SwingConstants.CENTER);
		
		shopButton = new JButton("商店");
		battleButton = new JButton("戰鬥");
		exitButton = new JButton("退出");
		optionButton = new JButton("選項");
		
		cp = getContentPane();
		cp.setLayout(new BorderLayout(20,30));
		
		JPanel SBEPan = new JPanel();
		SBEPan.setLayout(new GridLayout(1,3,10,20));
		
		JPanel LySBEPan = new JPanel();
		LySBEPan.setLayout(new GridLayout(2,1,10,20));
		
		JPanel LayerPan = new JPanel();
		LayerPan.setLayout(new GridLayout(1,3,10,20));
		
		JPanel LayerPan2 = new JPanel();
		LayerPan2.setLayout(new GridLayout(1,3,10,20));
		
		JPanel InfoPan = new JPanel();
		InfoPan.setLayout(new GridLayout(4,2,10,20));
		
		cp.add(LySBEPan, BorderLayout.SOUTH);
		cp.add(InfoPan, BorderLayout.CENTER);
		SBEPan.add(optionButton);
		SBEPan.add(exitButton);
		LayerPan2.setBorder(BorderFactory.createLineBorder(null));
		LayerPan2.add(layer);
		LayerPan.add(battleButton);	
		LayerPan.add(LayerPan2);
		LayerPan.add(shopButton);
		LySBEPan.add(LayerPan);
		LySBEPan.add(SBEPan);
		
		InfoPan.setBorder(BorderFactory.createTitledBorder("角色面板"));
		InfoPan.add(nameLabel);
		InfoPan.add(nm);
		InfoPan.add(hpLabel);
		InfoPan.add(hp);
		InfoPan.add(atkLabel);
		InfoPan.add(atk);
		InfoPan.add(defLabel);
		InfoPan.add(def);
		
		ShopGUI s = new ShopGUI(player);
		s.player=this.player;
		BattleGUI b = new BattleGUI(player);
		b.player=this.player;
		b.g = this;
		exitButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			 }
		});
		battleButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 b.setVisible(true);
			 }
		});
		shopButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 s.setVisible(true);
			 }
		});
	}
}
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JTextArea;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JComboBox;
import javax.swing.JScrollPane;
	import javax.swing.JPanel;
	import java.awt.event.*;
	import java.awt.Container;
	import java.awt.FlowLayout;
	import java.awt.BorderLayout;
	import java.awt.GridLayout;

	public class GUI extends JFrame{
		private Container cp;
		private JLabel inpLabel1, inpLabel2;
		private JTextField input1, input2;
		private JButton button1, button2, button3;
		private JTextArea textarea;
		private JComboBox<String> types;
		public Player player;
		public GUI(){
		 setTitle("創建角色");
		 setSize(300,500);
		 setLocation(100,150);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 inpLabel1 = new JLabel("名稱");
		 inpLabel2 = new JLabel("種族");
		 input1 = new JTextField(15);
		 input2 = new JTextField(15);
		 button1 = new JButton("下一步");
		 button2 = new JButton("取消");
		 textarea = new JTextArea(75,20);
		 final String[] species= {"Human","Elf","Dwarf","Lycan"};
		 
		 types = new JComboBox(species);
		 
		 
		 
		 cp = getContentPane();
		 cp.setLayout(new BorderLayout(20,30));
		 JPanel cpan = new JPanel();
		 cpan.setLayout(new FlowLayout());
		 
		 JPanel span = new JPanel();
		 span.setLayout(new FlowLayout());
		 
		 JPanel tpan = new JPanel();
		 tpan.setLayout(new FlowLayout());
		 
		 JPanel fpan3 = new JPanel();
		 fpan3.setLayout(new FlowLayout());
		 
		 JPanel fpan = new JPanel();
		 fpan.setLayout(new GridLayout(3,1,10,20));
		 
		 JPanel fpan2 = new JPanel();
		 fpan2.setLayout(new GridLayout(2,1,10,20));
		 
		 JPanel bpan = new JPanel();
		 bpan.setLayout(new BorderLayout(10,20));
		 
		 JPanel butpan = new JPanel();
		 butpan.setLayout(new GridLayout(1,2,10,20));
		 
		 JPanel bpan2 = new JPanel();
		 bpan2.setLayout(new BorderLayout(10,20));
		 
		 JPanel boxpan = new JPanel();
		 boxpan.setLayout(new GridLayout(2,1,10,20));
		 JPanel boxpan2 = new JPanel();
		 boxpan2.setLayout(new GridLayout(2,1,10,20));
		 
		 JPanel gpan = new JPanel();
		 gpan.setLayout(new GridLayout(2,2,10,20));
		 cp.add(fpan, BorderLayout.CENTER);
		 cp.add(butpan,BorderLayout.SOUTH);
		 
		 cpan.add(inpLabel1);
		 cpan.add(input1);
		 span.add(inpLabel2);
		 span.add(types);
		 tpan.add(textarea, BorderLayout.EAST);
		 bpan2.add(tpan);
		 fpan2.add(cpan);
		 fpan2.add(span);
		 bpan.add(fpan2, BorderLayout.CENTER);
		 butpan.add(button1);
		 butpan.add(button2);
		 fpan.add(bpan);
		 fpan.add(bpan2);
		 
		 
		 
		 types.addActionListener(new typeSelect());
		 button1.addActionListener(new nextStep()); 
		 button2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			 }
		 });
		 
		 

		 
		}
		
		private class typeSelect implements ActionListener  {
			public void actionPerformed(ActionEvent e)  {
					String typeSel = (String) types.getSelectedItem();//get the selected item

	                switch (typeSel) {
	                    case "Elf":
	                    	textarea.setText("你所選擇的種族是:Elf"+"\n"+"生命值:100"+"攻擊力:3"+"防禦力:1");
	                        break;
	                    case "Dwarf":
	                    	textarea.setText("你所選擇的種族是:Dwarf"+"\n"+"生命值:50"+"攻擊力:3"+"防禦力:7");
	                        break;
	                    case "Lycan":
	                    	textarea.setText("你所選擇的種族是:Lycan"+"\n"+"生命值:50"+"攻擊力:9"+"防禦力:1");
	                        break;
	                    case "Human":
	                    	textarea.setText("你所選擇的種族是:Human"+"\n"+"生命值:50"+"攻擊力:6"+"防禦力:4");
	                        break;
	                }
	            }
			}				
		
		
		private class nextStep implements ActionListener  {
			public void actionPerformed(ActionEvent e)  {
				if(input1.getText().length() <= 1) {
					JOptionPane.showMessageDialog(null, "???");
				}
				else {
					
					String type = (String) types.getSelectedItem();
						
					switch (type) {
	                	case "Elf":
	                		player = new Elf(input1.getText(), 50, 3, 1, 100);
	                        break;
	                    case "Dwarf":
	                    	player = new Dwarf(input1.getText(), 50, 3, 1, 100);
	                        break;
	                    case "Lycan":
	                    	player = new Lycan(input1.getText(), 50, 3, 1, 100);
	                        break;
	                    case "Human":
	                    	player = new Human(input1.getText(), 50, 3, 1, 100);
	                        break;
					}
					setVisible(false);
					GUI2 g = new GUI2(player);
					g.player = player;
					
					g.setVisible(true);										
				}				
			}
		}
		public static void main(String[] args ) {
			GUI f = new GUI();
			f.setVisible(true);
		}
	}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Une ComboBox");
    String[] tab = {"val 1", "val 2", "val 3", "val 4"};
    JComboBox combo_val = new JComboBox(tab);

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		combo.setPreferredSize(new Dimension(100, 20));
		combo.addItem("Option 1");
		combo.addItem("Option 2");
		combo.addItem("Option 3");
		combo.addItem("Option 4");
		combo.setSelectedItem(3);
		

	    //combo_val.setPreferredSize(new Dimension(100,20));
	    combo_val.setBackground(Color.blue);
	    
		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		top.add(combo_val);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		
		//Adding combo listner
		combo_val.addItemListener(new ItemState());
		combo_val.addActionListener(new ItemAction());
	}
	
	class ItemState implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			System.out.println("trigger at" + e.getItem());
		}
	}
	class ItemAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Action at" + combo_val.getSelectedItem());
		}
	}
	
}
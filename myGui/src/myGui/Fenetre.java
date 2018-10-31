package myGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private Panneau pan = new Panneau();
	private JButton bouton_go = new MyButton("GO");
	private JButton bouton_stop = new JButton("STOP");
	private JLabel label = new JLabel("Le JLabel");

	boolean isAnimate = true;
	boolean isBackX, isBackY;
	private int x, y;
	private Thread t;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu animate = new JMenu("Animate");
	private JMenuItem menuItemGo = new JMenuItem("Go");
	private JMenuItem menuItemStop = new JMenuItem("Stop");
	private JMenuItem menuItemExit = new JMenuItem("Exit");

	// combo for form selection
	private JComboBox<String> comboForm = new JComboBox<String>();
	private JCheckBox checkBox_morph = new JCheckBox("Morph");

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Menu
		this.setJMenuBar(menuBar);
		menuBar.add(animate);
		animate.add(menuItemGo);
		animate.add(menuItemStop);
		animate.addSeparator();
		animate.add(menuItemExit);
		
		menuItemGo.addActionListener(new BoutonGoListener());
		menuItemStop.addActionListener(new BoutonStopListener());
		
		menuItemExit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          System.exit(0);
	        }
	      });

		// Center container
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		// South container
		JPanel panel_south = new JPanel();
		panel_south.add(bouton_go);
		panel_south.add(bouton_stop);
		container.add(panel_south, BorderLayout.SOUTH);

		// actions for button clicks
		bouton_go.setPreferredSize(new Dimension(50, 50));
		bouton_go.addActionListener(new BoutonGoListener());
		bouton_stop.addActionListener(new BoutonStopListener());

		// North container
		container.add(label, BorderLayout.NORTH);

		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.DARK_GRAY);
		label.setHorizontalAlignment(JLabel.CENTER);

		// add combos on a top panel
		JPanel top = new JPanel();
		container.add(top, BorderLayout.NORTH);
		top.add(comboForm);
		comboForm.addItem("CARRE");
		comboForm.addItem("TRIANGLE");
		comboForm.addItem("CERCLE");
		comboForm.addItem("ETOILE");
		comboForm.addActionListener(new comboFormListener());
		
		// add checkbox for morph
		top.add(checkBox_morph);
		checkBox_morph.addActionListener(new checkBoxMorphListener());
		
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}

	private void go() {

		// get x & y position
		x = pan.getPosX();
		y = pan.getPosY();

		while (this.isAnimate) {
			if (x < 1)
				isBackX = false;
			if (x > pan.getWidth() - 50)
				isBackX = true;
			if (y < 1)
				isBackY = false;
			if (y > pan.getHeight() - 50)
				isBackY = true;

			if (!isBackX)
				pan.setPosX(++x);
			else
				pan.setPosX(--x);
			if (!isBackY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);

			pan.repaint();

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class BoutonGoListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			int option = JOptionPane.showConfirmDialog(null, "Really go ?", "Go confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				isAnimate = true;
				bouton_go.setEnabled(false);
				bouton_stop.setEnabled(true);
				t = new Thread(new PlayAnimation());
				t.start();
			}
		}
	}

	class BoutonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			isAnimate = false;
			bouton_go.setEnabled(true);
			bouton_stop.setEnabled(false);
		}
	}

	class comboFormListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pan.setForm(comboForm.getSelectedItem().toString());
		}
	}

	class PlayAnimation implements Runnable {
		public void run() {
			go();
		}
	}

	class checkBoxMorphListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (checkBox_morph.isSelected())
				pan.setMorph(true);
			else
				pan.setMorph(false);
		}
	}
}

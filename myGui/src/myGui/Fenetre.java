package myGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Fenetre extends JFrame implements ActionListener {
	private JPanel container = new JPanel();
	private Panneau pan = new Panneau();
	private JButton bouton_go = new Bouton("GO");
	private JButton bouton_stop = new JButton("STOP");
	private JLabel label = new JLabel("Le JLabel");
	
	boolean isAnimate = true;
	boolean isBackX, isBackY;
	private int x, y;
	private Thread t;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu Animate = new JMenu("Animate");
	private JMenuItem menuItemGo = new JMenuItem("Go");
	private JMenuItem menuItemStop = new JMenuItem("Stop");
	private JMenuItem menuItemExit = new JMenuItem("Exit");

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Menu
		this.setJMenuBar(menuBar);
		menuBar.add(Animate);
		Animate.add(menuItemGo);
		Animate.add(menuItemStop);
		Animate.addSeparator();
		Animate.add(menuItemExit);
		
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
		bouton_stop.addActionListener(new BoutonStopListener2());

		// North container
		container.add(label, BorderLayout.NORTH);

		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.DARK_GRAY);
		label.setHorizontalAlignment(JLabel.CENTER);

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
			
			JOptionPane jop_confirmGo = new JOptionPane();			
			int option = jop_confirmGo.showConfirmDialog(null, 
					"Really go ?", 
					"Go confirmation", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				isAnimate = true;
				bouton_go.setEnabled(false);
				bouton_stop.setEnabled(true);
				t = new Thread(new PlayAnimation());
				t.start();			
			}
		}
	}

	class BoutonStopListener2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			isAnimate = false;
			bouton_go.setEnabled(true);
			bouton_stop.setEnabled(false);
		}
	}

	class PlayAnimation implements Runnable {
		public void run() {
			go();
		}
	}
}

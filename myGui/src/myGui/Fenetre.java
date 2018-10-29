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
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.config.management.policy.ManagedServiceAssertion.ImplementationRecord;

public class Fenetre extends JFrame implements ActionListener {
	private Panneau pan = new Panneau();
	private JButton bouton = new Bouton("GO");
	private JButton bouton2 = new JButton("STOP");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Le JLabel");
	private int compteur = 0;
	boolean isAnimate = true;
	boolean isBackX, isBackY;
	private int x, y;
	private Thread t;

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Center container
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		// South container
		JPanel panel_south = new JPanel();
		panel_south.add(bouton);
		panel_south.add(bouton2);
		container.add(panel_south, BorderLayout.SOUTH);

		// actions for button clicks
		bouton.setPreferredSize(new Dimension(150, 120));
		bouton.addActionListener(new BoutonListener());
		bouton2.addActionListener(new BoutonListener2());

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

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bouton) {
			this.compteur++;
			label.setText("clickS count = " + this.compteur);
		} else if (arg0.getSource() == bouton2) {
			this.compteur--;
			label.setText("clickS count = " + this.compteur);

		}
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

	class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			isAnimate = true;
			bouton.setEnabled(false);
			bouton2.setEnabled(true);
			//go();
			t = new Thread (new PlayAnimation());
			t.start();
		}
	}

	class BoutonListener2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			isAnimate = false;
			bouton.setEnabled(true);
			bouton2.setEnabled(false);
		}
	}
	
	class PlayAnimation implements Runnable{
		public void run() {
			go();
		}
	}
}

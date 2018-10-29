package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {
	private JLabel label = new JLabel();
	private Horloge horloge;

	public Fenetre() {
		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);

		// horloge instance
		this.horloge = new Horloge();
		this.horloge.addObservateur(new Observateur() {

			@Override
			public void update(String hour) {
				label.setText(hour);
			}
		});

		// setup Jlabel
		Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);

		// add label to frame
		this.getContentPane().add(this.label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();
	}

	// Méthode main() lançant le programme
	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
	}
	
	class Bouton_1_Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			isAnimate = false;
			bouton.setEnabled(true);
			bouton2.setEnabled(false);
		}
	}
	
}
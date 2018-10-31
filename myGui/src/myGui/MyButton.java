package myGui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class MyButton extends JButton implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Image img;

	public MyButton(String str) {
		super(str);
		this.name = str;
		try {
			img = ImageIO.read(new File("fondBouton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
		g2d.setPaint(gp);
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.setColor(Color.black);
		
		FontMetrics fm = g2d.getFontMetrics();
		int height = fm.getHeight();
		int width = fm.stringWidth(this.name);
		
		g2d.drawString(this.name, 
				this.getWidth() / 2 - (width/2), 
				(this.getHeight()/2 + height / 4));
	}

	public void mouseClicked(MouseEvent event) {
		// Inutile d'utiliser cette m�thode ici
	}

	public void mouseEntered(MouseEvent event) {
		// Nous changeons le fond de notre image pour le jaune lors du survol, avec le
		// fichier fondBoutonHover.png
		try {
			img = ImageIO.read(new File("fondBoutonHover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mouseExited(MouseEvent event) {
		// Nous changeons le fond de notre image pour le vert lorsque nous quittons le
		// bouton, avec le fichier fondBouton.png
		try {
			img = ImageIO.read(new File("fondBouton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mousePressed(MouseEvent event) {
		// Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec
		// le fichier fondBoutonClic.png
		try {
			img = ImageIO.read(new File("fondBoutonClic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mouseReleased(MouseEvent event) {
		// Nous changeons le fond de notre image pour le orange lorsque nous rel�chons
		// le clic, avec le fichier fondBoutonHover.png
		try {
			img = ImageIO.read(new File("fondBoutonHover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
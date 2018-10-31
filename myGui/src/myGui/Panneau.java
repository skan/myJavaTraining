package myGui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX = 0;
	private int posY = 0;
	private String form = "CARRE";
	private int morph_increment = 0;
	private boolean isMorphReduce = false;
	private int drawSize = 50;
	private boolean isMorphUsed = false;
	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillOval(posX, posY, 50, 50);
		if (this.isMorphUsed)
			drawMorph(g);
		else
			draw(g);
	}

	private void draw(Graphics g) {
		if (this.form.equals("ROND")) {
			g.fillOval(posX, posY, 50, 50);
		}
		if (this.form.equals("CARRE")) {
			g.fillRect(posX, posY, 50, 50);
		}
		if (this.form.equals("TRIANGLE")) {
			// Calcul des sommets
			// Le sommet 1 se situe � la moiti� du c�t� sup�rieur du carr�
			int s1X = posX + 25;
			int s1Y = posY;
			// Le sommet 2 se situe en bas � droite
			int s2X = posX + 50;
			int s2Y = posY + 50;
			// Le sommet 3 se situe en bas � gauche
			int s3X = posX;
			int s3Y = posY + 50;
			// Nous cr�ons deux tableaux de coordonn�es
			int[] ptsX = { s1X, s2X, s3X };
			int[] ptsY = { s1Y, s2Y, s3Y };
			// Nous utilisons la m�thode fillPolygon()
			g.fillPolygon(ptsX, ptsY, 3);
		}
		if (this.form.equals("ETOILE")) {
			// Pour l'�toile, on se contente de tracer des lignes dans le carr�
			// correspondant � peu pr�s � une �toile...
			// Mais ce code peut �tre am�lior� !
			int s1X = posX + 25;
			int s1Y = posY;
			int s2X = posX + 50;
			int s2Y = posY + 50;
			g.drawLine(s1X, s1Y, s2X, s2Y);
			int s3X = posX;
			int s3Y = posY + 17;
			g.drawLine(s2X, s2Y, s3X, s3Y);
			int s4X = posX + 50;
			int s4Y = posY + 17;
			g.drawLine(s3X, s3Y, s4X, s4Y);
			int s5X = posX;
			int s5Y = posY + 50;
			g.drawLine(s4X, s4Y, s5X, s5Y);
			g.drawLine(s5X, s5Y, s1X, s1Y);
		}
	}

	// M�thode qui peint le morphing
	private void drawMorph(Graphics g) {
		// On incr�mente
		morph_increment++;
		// On regarde si on doit r�duire ou non
		if (drawSize >= 50)
			isMorphReduce = true;
		if (drawSize <= 10)
			isMorphReduce = false;
		if (isMorphReduce)
			drawSize = drawSize - getUsedSize();
		else
			drawSize = drawSize + getUsedSize();

		if (this.form.equals("ROND")) {
			g.fillOval(posX, posY, drawSize, drawSize);
		}
		if (this.form.equals("CARRE")) {
			g.fillRect(posX, posY, drawSize, drawSize);
		}
		if (this.form.equals("TRIANGLE")) {
			int s1X = posX + drawSize / 2;
			int s1Y = posY;
			int s2X = posX + drawSize;
			int s2Y = posY + drawSize;
			int s3X = posX;
			int s3Y = posY + drawSize;
			int[] ptsX = { s1X, s2X, s3X };
			int[] ptsY = { s1Y, s2Y, s3Y };
			g.fillPolygon(ptsX, ptsY, 3);
		}
		if (this.form.equals("ETOILE")) {
			int s1X = posX + drawSize / 2;
			int s1Y = posY;
			int s2X = posX + drawSize;
			int s2Y = posY + drawSize;
			g.drawLine(s1X, s1Y, s2X, s2Y);
			int s3X = posX;
			int s3Y = posY + drawSize / 3;
			g.drawLine(s2X, s2Y, s3X, s3Y);
			int s4X = posX + drawSize;
			int s4Y = posY + drawSize / 3;
			g.drawLine(s3X, s3Y, s4X, s4Y);
			int s5X = posX;
			int s5Y = posY + drawSize;
			g.drawLine(s4X, s4Y, s5X, s5Y);
			g.drawLine(s5X, s5Y, s1X, s1Y);
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setForm(String string) {
		this.form = string;
	}

	// Retourne le nombre � retrancher ou � ajouter pour le morphing
	private int getUsedSize() {
		int res = 0;
		// reset number of loop when 10 reached
		if (morph_increment / 10 == 1) {
			morph_increment = 0;
			res = 1;
		}
		return res;
	}

	public boolean isMorph() {
		return isMorphUsed;
	}

	public void setMorph(boolean bool) {
		this.isMorphUsed = bool;
		// Init size
		drawSize = 50;
	}

}
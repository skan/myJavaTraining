import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = -50;
	private int posY = -50;
	private int drawSize = 50;
	// Un bool�en pour le mode morphing
	// Un autre pour savoir si la taille doit �tre r�duite
	private boolean morph = false, reduce = false;
	private String forme = "ROND";
	// Le compteur de rafra�chissements
	private int increment = 0;

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		// Si le mode morphing est activ�, on peint le morphing
		if (this.morph)
			drawMorph(g);
		// Sinon, on peint le mode normal
		else
			draw(g);
	}

	private void draw(Graphics g) {
		if (this.forme.equals("ROND")) {
			g.fillOval(posX, posY, 50, 50);
		}
		if (this.forme.equals("CARRE")) {
			g.fillRect(posX, posY, 50, 50);
		}
		if (this.forme.equals("TRIANGLE")) {
			int s1X = posX + 50 / 2;
			int s1Y = posY;
			int s2X = posX + 50;
			int s2Y = posY + 50;
			int s3X = posX;
			int s3Y = posY + 50;
			int[] ptsX = { s1X, s2X, s3X };
			int[] ptsY = { s1Y, s2Y, s3Y };
			g.fillPolygon(ptsX, ptsY, 3);
		}
		if (this.forme.equals("ETOILE")) {
			int s1X = posX + 50 / 2;
			int s1Y = posY;
			int s2X = posX + 50;
			int s2Y = posY + 50;
			g.drawLine(s1X, s1Y, s2X, s2Y);
			int s3X = posX;
			int s3Y = posY + 50 / 3;
			g.drawLine(s2X, s2Y, s3X, s3Y);
			int s4X = posX + 50;
			int s4Y = posY + 50 / 3;
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
		increment++;
		// On regarde si on doit r�duire ou non
		if (drawSize >= 50)
			reduce = true;
		if (drawSize <= 10)
			reduce = false;
		if (reduce)
			drawSize = drawSize - getUsedSize();
		else
			drawSize = drawSize + getUsedSize();

		if (this.forme.equals("ROND")) {
			g.fillOval(posX, posY, drawSize, drawSize);
		}
		if (this.forme.equals("CARRE")) {
			g.fillRect(posX, posY, drawSize, drawSize);
		}
		if (this.forme.equals("TRIANGLE")) {
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
		if (this.forme.equals("ETOILE")) {
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

	// Retourne le nombre � retrancher ou � ajouter pour le morphing
	private int getUsedSize() {

		int res = 0;
		// Si le nombre de tours est de dix, on r�initialise l'incr�ment et on retourne
		// 1
		if (increment / 10 == 1) {
			increment = 0;
			res = 1;
		}
		return res;
	}

	public int getDrawSize() {
		return drawSize;
	}

	public boolean isMorph() {
		return morph;
	}

	public void setMorph(boolean bool) {
		this.morph = bool;
		// On r�initialise la taille
		drawSize = 50;
	}

	public void setForme(String form) {
		this.forme = form;
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
}
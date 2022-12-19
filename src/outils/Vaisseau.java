package outils;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vaisseau {
	private int x,y;
	private Image image;
	
	public Vaisseau(int x, int y, Image img) throws SlickException {
		this.x = x;
		this.y = y;
		this.image = img;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(image, x, y);
	}
	
	public void gauche() {
		if(x-10-25>=0)
			x-=10;
	}
	 
	public void droite() {
		if(x + 10 + 25 < 1200)
			x+=10;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}


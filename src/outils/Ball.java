package outils;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Ball {

	protected float x;
	protected float y;
	protected float Vx;
	protected float Vy = 2200.f;
	protected float w;
	protected float h;
	protected Image image;
	protected int puiss; // puissance de l'arme
	//protected Sound son1; // bruit de l'arme le joueur tire
	public boolean use = false;// est ce que l'arme est utilisée

	public Ball(Joueur j) {
		// TODO Auto-generated constructor stub

		this.w = 20.f;
		this.h = 20.f;
		this.x = j.getX() + j.getW() / 2.f - y;
		this.y = j.getY();
		this.Vx = 90.f;
		this.Vy = 1000.f;
		this.use = true;

	}

	// constructeur de ball enemies
	public Ball(float x, float y, float Vy) {
		// TODO Auto-generated constructor stub

		this.w = 20.f;
		this.h = 20.f;
		this.x = x;
		this.y = y;
		this.Vx = 90.f;
		this.Vy = Vy;
		this.use = true;

	}

	public boolean toucheE(Enemie e) {
		// renvoie true si la balle touche l'enemie e

		if (y <= e.getY()) {
			if (x >= e.getX() && x <= e.getX() + e.getW() || x + h >= e.getX() && x + h <= e.getX() + Enemie.w)
				return true;
		}
		return false;

	}

	public boolean toucheJ(Joueur j) {
		// renvoie true si la bal touche l'enemie e

		if ((y+h) > j.getY()) {
			if (x > j.getX() && x <=( j.getX() + j.getW() )|| (x + w) > j.getX() && (x + h) < (j.getX() + j.getW())){
				
				return true;
			}
		}
		return false;

	}

	public boolean horCadre() {

		if (this.x < 1 || this.x > 1000 || this.y < 0 || this.y > 650)
			return true;
		else
			return false;
	}

	public void mooveUp(int delta) {
		// monter
		y -= delta * Vy / 1000;

	}

	public void mooveDown(int delta) {
		// descendre
		y += delta * Vy / 1000;

	}

	// faire revenir la ball vers la joueur
	public void revenir(Joueur j) {
		if (y <= -10.f) {
			x = j.getX() + j.getW() / 2 - w / 2;
			y = j.getY();
			use = false;

		}
	}

	public void supprimerJ(Joueur j) {
		j.setImage(null);
	}

	// getters and setters

//	public Sound getSon1() {
//		return son1;
//	}
//
//	public void setSon1(Sound son1) {
//		this.son1 = son1;
//	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVx() {
		return Vx;
	}

	public void setVx(float vx) {
		Vx = vx;
	}

	public float getVy() {
		return Vy;
	}

	public void setVy(float vy) {
		Vy = vy;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public boolean getUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public int getPuiss() {
		return puiss;
	}

	public void setPuiss(int puiss) {
		this.puiss = puiss;
	}

	public void dessiner() {
		// TODO Auto-generated method stub
		image.draw(x, y, w, h);

	}

	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		// image.draw(x, y, w, h);
		g.drawImage(image, x, y);

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

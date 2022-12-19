package outils;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Joueur {
	private float x = 500.f; // position du joueur
	private float y = 510.f;
	private float Vx;// vitesse par rapport a x
	private float Vy;
	private float w = 90.f;// largeur du joueur
	private float h = 90.f;// hauteur
	// private static int lop=1;
	private Image image; // image associ�e au joueur
	private int sens = 0; //
	private int points = 0; // score
	private int sang;
	//protected Sound sontir;

	// private ArrayList<Ball> armes;
	// represente le nombre de bal en cour d emeon joueur
	public ArrayList<Ball> armes = new ArrayList<Ball>();

	// represente le nombre de bal en cour d emeon joueur
	// public ArrayList<Ball> armes = new ArrayList<Ball>();
	//private Sound son; // le son lorsque mo joueur meurt

	// constructors
// vitesse  laquelle le joueur se deplca
	public Joueur(float Vx, float Vy) throws SlickException {
		// TODO Auto-generated constructor stub
		this.x = 500.f;
		this.y = 510.f;
		this.Vx = Vx;
		this.Vy = Vy;
		this.w = 90.f;// initialisation en double de la largeur de la fenetre
		this.h = 90.f;
		this.sang = 30; // sang du joueur au d�but du jeu
		// sontir= new Sound("images/tirbal.ogg");

		try {
			this.image = new Image("images/vaisseau4.png").getScaledCopy((int) w, (int) h);
			// this.son = new Sound("images/meurt.ogg");
		} catch (SlickException e) {
			System.out.println(e.getMessage());
		}

	}

/// methods

	public int getSang() {
		return sang;
	}

	public void setSang(int sang) {
		this.sang = sang;
	}

	// deplacer un joueur de gauche a droite
	public void deplacer(int delta) {

		if (sens == 0) {

		} else if (sens == -1) {
			x = x - delta * Vx / 1000f;
		} else {
			x = x + delta * Vx / 1000f;
		}
	}

	public void tirer(int delta) {

		for (int i = 0; i < armes.size(); i++)
			if (armes.get(i) != null)
				armes.get(i).mooveUp(delta);
	}

	public ArrayList<Ball> getArmes() {
		return armes;

	}

	public void setArmes(ArrayList<Ball> armes) {
		this.armes = armes;
	}

//
//	public Sound getSon() {
//		return son;
//	}
//
//	public void setSon(Sound son) {
//		this.son = son;
//	}
//
//	// collision avec un element de type enemie
	public boolean collisionJ(Enemie e) {

		if (y <= e.getY() + Enemie.h) {

			if (x >= e.getX() && x <= e.getX() + Enemie.w || x + w >= e.getX() && x + w <= e.getX() + Enemie.w) {

				return true;
			}

		}
		return false;

	}

	// joueur touche le bonus
//	
//	public boolean toucheB(Bonus b) {
//		
//		if(y<=b.getH()+b.getY()) {
//			if(x>=b.getX() && x<=b.getX()+b.getW() || (x+h)>=b.getX() && (x+h)<=b.getX()+b.getW()) {
//				return true;		
//			}
//		}
//		return  false;
//	}
//	// detruire un enemie qu'on a touché
//
	public boolean destruct(Enemie e) {

		if (collisionJ(e)) {
			e = null;
			points++;
			// System.out.println("meurt ");
			return true;

		}
		return false;
	}

	// dessiner le joueur
	public void dessiner() {

		image.draw(x, y, w, h);
	}

	public String toString() {

		return " ";
	}

	// getters and setters

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public void setImage(org.newdawn.slick.Image image2) {
		this.image = image2;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		if (x >= 0 && x < 1000)
			this.x = x;

	}

	public Image getImage() {
		return image;
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

//	public Sound getSontir() {
//		return sontir;
//	}
//
//	public void setSontir(Sound sontir) {
//		this.sontir = sontir;
//	}
}

//}

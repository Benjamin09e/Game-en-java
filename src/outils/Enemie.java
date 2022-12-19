package outils;
import java.util.ArrayList;

import org.newdawn.slick.Image;

public abstract class Enemie {

	protected float x ;// (float) (Math.random() * 300 + 500);
	protected float y ;
	protected float Vx;
	protected float Vy;
	protected static float h = 90.f;// hauteur
	protected static float w = 90.f;// largeur
	protected Image image;

	protected int sang; // sang de l'enemie
	protected ArrayList<Ball> armes;// = new ArrayList<Ball>();// le type de ball de l'enemie
	protected float r;
	protected int  yettouche;

	protected Enemie(float Vx, float Vy) {
		this.Vx = Vx;
		this.Vy = Vy;
		this.yettouche=0;
	}

	public void dessiner() {

		// dessiner un enemie
		this.image.draw(x, y, Enemie.w, Enemie.h);
	}

	public void tirer(int delta) {

		for (int i = 0; i < armes.size(); i++) {
			armes.get(i).mooveDown(delta);
		}

	}

	public boolean horCadre() {
		
		if(this.x<1 || this.x>1000 || this.y<0 || this.y>650)
			return true;
		else
			return false;
	}

	public float getX() {
		return x;
	}


	public int getYettouche() {
		return yettouche;
	}

	public void setYettouche(int yettouche) {
		this.yettouche = yettouche;
	}

	protected void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	protected void setY(float y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public float getH() {

		return h;
	}

	protected void setH(float h) {
		this.h = h;
	}

	public float getW() {
		return w;
	}

	protected void setW(float w) {
		this.w = w;
	}

	public int getSang() {
		return sang;
	}

	public void setSang(int sang) {
		this.sang = sang;
	}

	public ArrayList<Ball> getArmes() {
		return armes;
	}

	public void setArmes(ArrayList<Ball> armes) {
		this.armes = armes;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
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

	public abstract void moove(int delta);



}

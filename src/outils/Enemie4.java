package outils;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemie4 extends Enemie {
	protected ArrayList<Ball> armes = new ArrayList<Ball>();// le type de ball de l'enemie


	protected Enemie4(float Vx, float Vy) {
		super(Vx,Vy);

		this.x=0;
		this.y=0;
		//this.armes.add(new Ball2(500.f,500.f,5.f));
		try {
			image= new Image("images/enemie4.png");//getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void moove(int delta) {
		
//    	x+=Vx*delta/100.f;
//		x=x+Vx*delta/1000.f;
//		y=x;
//	y = y + Vy * delta / 1000.f; // deplacement vers le bas
	}

}

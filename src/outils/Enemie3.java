package outils;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemie3 extends Enemie {
	protected ArrayList<Ball> armes = new ArrayList<Ball>();// le type de ball de l'enemie

	public Enemie3(float Vx, float Vy)   {
		super(Vx, Vy);
		// TODO Auto-generated constructor stub
		
		//this.sang=40;
		//this.armes.add(new Ball1(500.f,500.f,5.f));
		this.x=100;//(float)Math.random()*600.f;
		this.y=100;
		try {
			image= new Image("images/ennemi3.png").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void moove(int delta ) {
		//x=x+Vx*delta/1000; 
		
		y=y+Vx*delta/1000.f;// deplacement selon la droite y=x premiere bissectrice
		
	}


}

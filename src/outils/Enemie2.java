package outils;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemie2 extends Enemie {
	protected ArrayList<Ball> armes = new ArrayList<Ball>();// le type de ball de l'enemie


	public Enemie2(float Vx, float Vy)  {
		super(Vx, Vy);

		this.Vx=Vx;
		this.Vy=Vy;
		//this.sang = 21;
		this.x=100;
		this.y=100;//(float) (Math.random()*400);
	//	this.armes.add(new Ball1(500.f,500.f,5.f));
		try {
			image= new Image("images/ennemi2.png").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// TODO Auto-generated constructor stub
	}
	
	public void  moove(int delta ) {
		
		x=x+Vx*delta/1000.f;// deplacement  vers la droite 
		
		
	}


}

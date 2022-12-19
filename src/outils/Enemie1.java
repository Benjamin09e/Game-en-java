package outils;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemie1 extends Enemie {
	protected ArrayList<Ball> armes = new ArrayList<Ball>();// le type de ball de l'enemie


	public Enemie1(float Vx, float Vy )  {
		super(Vx, Vy);
		// TODO Auto-generated constructor stub
		this.Vx=Vx;
		this.Vy=Vy;
		//this.sang=1;
		this.armes.add(new Ball2(x,y,5.f));
		try {
			image= new Image("images/ennemi1.png").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		 y= 0;
		 x= (float) (Math.random()*300)+200;
		
		r=(float) Math.sqrt(Math.pow(x, 2.0)+Math.pow(y, 2.0));

	}
	
	public void moove(int delta) {
		
		 x=x-delta*Vx/1000;
			
		 y=(float) Math.sqrt(r*r-x*x);  //deplacement en cercle de rayon r
		 
	}
}

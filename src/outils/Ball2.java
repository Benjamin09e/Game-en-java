package outils;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball2 extends Ball {


	public Ball2(Joueur j) {
		super(j);
		// TODO Auto-generated constructor stub
		this.puiss = 2;
		this.w = 10.f;
		
		try {
			image= new Image("images/bombe2.jpg").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public Ball2(float x, float y, float Vy) {
		super(x, y, Vy);
		// TODO Auto-generated constructor stub
		try {
			image= new Image("images/bombe1.jpg").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

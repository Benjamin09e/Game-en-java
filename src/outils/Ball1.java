package outils;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball1 extends Ball {

	public Ball1(float x, float y, float Vy) {
		super(x, y, Vy);
		// TODO Auto-generated constructor stub
		this.w=10.f;
		this.puiss=1;
		try {
			image= new Image("images/bombe.jpg").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Ball1(Joueur j)  {
		super(j);
	
		this.puiss=1;
		this.w=10.f;
		try {
			image= new Image("images/bombe.jpg").getScaledCopy((int)w,(int)h);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// TODO Auto-generated constructor stub
	}


}

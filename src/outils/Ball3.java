package outils;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball3 extends Ball {


	public Ball3(Joueur j) {
		super(j);
		// TODO Auto-generated constructor stub
		this.puiss = 3;
		this.w = 40.f;
		this.h=80.f;
		try {
			image= new Image("images/bombe.jpg").getScaledCopy((int)w,(int)h);
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public Ball3(float x, float y, float Vy) {
		super(x, y, Vy);
		// TODO Auto-generated constructor stub
		
		try {
			image= new Image("images/bombe.jpg").getScaledCopy((int)w,(int)h);
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dessiner() {
		// dessiner une bal

		this.image.draw(x, y, w, h);
	}

}

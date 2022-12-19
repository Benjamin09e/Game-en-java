package outils;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball4 extends Ball {
	

	protected Ball4(float x, float y, float Vy) {
		super(x, y, Vy);
		// TODO Auto-generated constructor stub
		try {
			image= new Image("images/bal3.png");//getScaledCopy((int)w,(int)h);
			this.image=image;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Ball4(Joueur j)  {
		super(j);
		// TODO Auto-generated constructor stub
		this.puiss = 4;
		this.w = 110.f;
		this.h=110.f;
		try {
			image= new Image("images/bal3.png").getScaledCopy((int)w,(int)h);
			this.image=image;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

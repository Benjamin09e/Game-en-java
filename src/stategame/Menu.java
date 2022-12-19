package stategame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	int Xpos, Ypos;
	Image img1;
	Image images2;
	Image images1;
	//private Sound s;
	public static final int ID = 1;
	private StateBasedGame game;
	

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.setGame(sbg);
		this.img1 = new Image("images/img1.png");
		this.images2 = new Image("images/images2.png");
		this.images1 = new Image("images/images1.png");
		//this.s=new Sound("son/ikiki.ogg");
		//s.play();
		this.Xpos = 0;
		this.Ypos = 0;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		img1.draw(0,0,1000,650);
		images2.draw(20, 30);
		images1.draw(180, 390);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();

		// essayer de recuperer avec la souris
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(Play.ID);
		}

	}

	@Override
	public int getID() {
		return ID;
	}
	
//	public Sound getS() {
//		return s;
//	}
//
//	public void setS(Sound s) {
//		this.s = s;
//	}

	public StateBasedGame getGame() {
		
		
		return game;
	}
	

	public void setGame(StateBasedGame game) {
		this.game = game;
	}
	
	

}

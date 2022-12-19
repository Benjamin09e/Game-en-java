package stategame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import outils.Vie;

public class Over extends BasicGameState  implements Vie{
	public static final int ID = 3;
	Image over2;
	  private StateBasedGame game;

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.setGame(game);
		this.over2=new Image("images/over2.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.drawString("Dommage, vous avez perdu. Voulez vous recommencer (O/N) ?", 300, 300);
		over2.draw(0,0,1000,650);
		g.drawString("Fin de la partie, vous avez perdu. ", 600, 90);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input s = gc.getInput();
		Play c=new Play();
		if (s.isKeyPressed(Input.KEY_O)) {
			//c.init();
			sbg.enterState(c.ID);
		} else if (s.isKeyPressed(Input.KEY_N)) {
			gc.exit();
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	public StateBasedGame getGame() {
		return game;
	}

	public void setGame(StateBasedGame game) {
		this.game = game;
	}

}

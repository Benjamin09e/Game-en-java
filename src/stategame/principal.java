package stategame;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



public class principal extends StateBasedGame {
	
	public principal(String name) {
		super(name);
	}

	/*initialisation des etats.*/
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu());
		addState(new Play());
		addState(new Over());
	}

	/*initialisation du jeu.*/
	public static void main(String[] args) throws SlickException {
	AppGameContainer app;
	app = new AppGameContainer(new principal("Shoot'em Up"), 1000, 650, false);
	app.setDisplayMode(1000, 650, false);

	app.setShowFPS(false);
	app.start();
	}

}



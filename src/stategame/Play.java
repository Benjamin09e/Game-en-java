package stategame;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import outils.Ball;
import outils.Ball1;
import outils.Ball2;
import outils.Ball3;
import outils.Enemie;
import outils.Enemie1;
import outils.Enemie2;
import outils.Enemie3;
import outils.Joueur;
import outils.Vie;

public class Play extends BasicGameState implements Vie {

	public static final int ID = 2;
	private StateBasedGame game;

	//private static final boolean[][] Boolean = null;
	private Joueur j;
	//private Sound son1;
	private int timegame;
//	// private Enemie2 enemy;

	private float yFond;
	private boolean pause = false;
	// private Meteo m;
	private Image impause;
	private int prob;
	private int probbonus;
	private int probmeteo;
	Image fond3;
	static int cpt = 10,  niv = 1 , nbEnMort = 0;
	// private Bonus b;
	private double poss = 0; // activation de certaine armes
	//private boolean actions[] = new boolean[6];
	private Image[] imageactions = new Image[6];
	//private Sound sondebut;
	private int pow;
	private int points;
	private int sang = 40;
	private Ball b1;
	private Image imsang;
	private Image impoints;
	private float temps = 0;
//	private Image imbonus;
//	private int bonnus = 0;
//	// public Joueur j1;

	private ArrayList<Enemie> enemies = new ArrayList<Enemie>();
	// private ArrayList<Bonus> tabbonus = new ArrayList<Bonus>();
	// private ArrayList<Meteo> tabmeteo = new ArrayList<Meteo>();
	private ArrayList<Ball> tabbal = new ArrayList<Ball>();

//	public void init() {
//		sang = 60;
//	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.setGame(sbg);
		j = new Joueur(400, 200);
		fond3 = new Image("images/fond3.jpg");
		imsang = new Image("images/sang.png");
		impoints = new Image("images/piece.png");
		sang = 30;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		fond3.draw(0, 0, 1000, 800);
		if (j != null)
			j.dessiner();

		new String();
		g.drawString(String.valueOf(sang), 73.f, 50.f);
		imsang.draw(40.f, 47.f, 30.f, 30.f);

		impoints.draw(40.f, 75.f, 30.f, 30.f);
		g.drawString(new String().valueOf(points), 75.f, 78.f);

		// dessiner les enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).dessiner();
		}

		// dessiner les balles
		if (j != null && j.getArmes().isEmpty() == false) {
			for (int i = 0; i < j.getArmes().size(); i++) {
				if (j.getArmes().get(i).use == true) {
					j.getArmes().get(i).dessiner();
					//System.out.println("hello");
				}
			}
		}
		g.drawString("Nombre d'ennemis restants: " + (cpt), 120, 60);
		g.drawString("Niveau : " + (niv), 250, 40);
		if (niv == 2&& cpt == 0 && sang > 0) {
			g.drawString("Felicitation!  Vous avez gagnez...", 304, 370);
		}
		if (!tabbal.isEmpty()) {

			for (Ball b : tabbal) {
				b.dessiner(g);
				// b.image.draw(b.getX(), b.getY(),b.getW(), b.getH());

			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		Graphics g = null;
		Input input = gc.getInput();
		int h = 0;
		if (niv <= 3) {
			temps += delta / 1000f;

			/**
			 * gestion des niveaux Niv. 1
			 **/
			if (niv == 2) {

				if (temps >= 4.3f) {
					for (Enemie e : enemies) {
						tabbal.add(new Ball3(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));
					}
					temps = 0;
				}
			}
			if (niv == 3) {

				if (temps >= 4.f) {
					for (Enemie e : enemies) {
						tabbal.add(new Ball3(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));
					}
				}
				temps = 0;
			}
			if (niv == 1) {

				if (temps >= 1.f) {
					for (Enemie e : enemies) {
						tabbal.add(new Ball3(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));
					}
				}
			
		}
		}

		// probabilite

		// pour mettre ou retirer la pause
		if (input.isKeyPressed(input.KEY_P)) {
			pause = !pause;
		}

		if (input.isKeyPressed(input.KEY_ESCAPE)) {
			gc.exit();
		} else if (pause == true) {
			// lorsque la pause est a true ne rien faire
			// on est en pause
			// on purrait mettre le score en couir ou l
 
		} else {

			// probabilite d'apparution 

			prob = (int) (Math.random() * 500);
			probbonus = (int) (Math.random() * 400);
			probmeteo = (int) (Math.random() * 500);

			// generer les enemies
			if (prob == 0) {
				switch ((int) (Math.random() * 3)) {
				case 0:
					enemies.add(new Enemie1(200.f, 50.f));
					break;
				case 1:
					enemies.add(new Enemie2(200.f, 50.f));
					break;
				case 2:
					enemies.add(new Enemie3(200.f, 50.f));
					break;
				case 3:
					// enemies.add(new Enemie1(200.f, 50.f));
					break;

				}
			}

			// deplacer les enemies

			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).moove(delta);
			}

			// deplacement
			if (j != null && input.isKeyDown(Input.KEY_LEFT) && j.getX() >= 0)
				j.setSens(-1);
			else if (j != null && input.isKeyDown(Input.KEY_RIGHT) && j.getX() <= 1000 - j.getW())
				j.setSens(1);
			else if (j != null)
				j.setSens(0);

			if (j != null)
				j.deplacer(delta);
			// fin deplacement

			// generer une balle de type 2
			if (input.isKeyPressed(Input.KEY_Q)) {

				
				if (j != null) {
					j.getArmes().add(new Ball2(j));

				}

			}

			// fin

			 //balle de type 3
			if (input.isKeyPressed(Input.KEY_D)) {
				// creation d'une nouvelle ball si on n'a pas encore atteint 5
				j.getArmes().add(new Ball3(j));

			}

			// balle de type 1
		if (input.isKeyPressed(Input.KEY_S)) {
			// creation d'une nouvelle ball si on n'a pas encore atteint 5
				j.getArmes().add(new Ball1(j));

			}

			// tirer
			if (j != null)
				j.tirer(delta);

			// supprimer les ball hors cadre
			if (j != null) {
				for (int i = 0; i < j.getArmes().size(); i++) {

					if (j.getArmes().get(i).horCadre() == true) {
						j.getArmes().remove(j.getArmes().get(i));
					}
				}

			}

			// supprimer les enemies hors cadre
			if (j != null) {
				for (int i = 0; i < enemies.size(); i++) {

					if (enemies.get(i).horCadre() == true) {
						enemies.remove(i);
					}
				}

			}

			temps += delta / 1000.f;

			// creation de bal
			if (temps >= 1) {
				for (Enemie e : enemies) {
					// association d'une balle aux ennemis
					int probtir = (int) (Math.random() * 2);
					if (probtir == 0 && !pause)
						if (e instanceof Enemie3) {
							tabbal.add(new Ball3(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));
						}
					if (e instanceof Enemie1) {
						tabbal.add(new Ball2(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));
					} else if (e instanceof Enemie2) {
						tabbal.add(new Ball1(e.getX() + e.getW() / 2.f, e.getY() + e.getH(), 300.f));

					}
				}
				temps = 0;
			}

			for (Ball b : tabbal) {
				if (!pause)
					b.mooveDown(delta);
				// System.out.println("moving");
			}

			// collision joueur enemie
			if (j != null && enemies.size() != 0) {
				for (int k = 0; k < enemies.size(); k++) {

					if (j.collisionJ(enemies.get(k)) && enemies.get(k).getYettouche() == 0) {
						sang = sang - 1;
						enemies.get(k).setYettouche(1);
						//System.out.println("oui");
						// enemies.get(k).setImage(new Image("images/explosion.png"));

					}

				}

			}

			// collision joueur ball enemies
			if (j != null) {
				for (Ball b : tabbal) {
					if (b.toucheJ(j)) {
						sang--;
						tabbal.remove(b);
						break;
					}

				}

			}

			if (j != null) {

				for (int i = 0; i < j.getArmes().size(); i++) {
					for (int k = 0; k < enemies.size(); k++) {

						if (j.getArmes().get(i).toucheE(enemies.get(k)) == true) {

							// j.getArmes().remove(i);
							if (enemies.get(k).getSang() <= 0) {
								points++;
								enemies.remove(enemies.get(k));
								j.getArmes().remove(i);
								cpt --;
								if(cpt == 0) {
									cpt = 10;
									niv += 1;
								}
								
								break;

							} else {
								// j.getArmes().remove(j.getArmes().get(i));
								if ((j.getArmes().get(i) instanceof Ball1)) {
									enemies.get(k).setSang(enemies.get(k).getSang() - 1);
									// j.getArmes().remove(i);
								}

//								if ((j.getArmes().get(i) instanceof Ball2)) {
//									enemies.get(k).setSang(enemies.get(k).getSang() - 2);
//									// j.getArmes().remove(i);
//
//								}
//								if ((j.getArmes().get(i) instanceof Ball3)) {
//									enemies.get(k).setSang(enemies.get(k).getSang() - 3);
//									// j.getArmes().remove(i);
//
//								}
//								if ((j.getArmes().get(i) instanceof Ball4)) {
//									enemies.get(k).setSang(enemies.get(k).getSang() - 4);
//									// j.getArmes().remove(k);
//
//								}

							}

						}

					}

				}
			}

			if (sang <= 0) {
				j = null;
				//System.out.println(sang);
			}
			if (j == null)
				sbg.enterState(Over.ID);

			// fin non pause
		}

	}

	@Override
	public int getID() {
		return ID;
	}

	public StateBasedGame getGame() {
		return game;
	}

	public void setGame(StateBasedGame game) {
		this.game = game;
	}

}

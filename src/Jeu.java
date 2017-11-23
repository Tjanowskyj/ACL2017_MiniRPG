

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Model.Map1;

public class Jeu extends StateBasedGame {

	
	public static final String NAME = "MiniRPG"; //nom du jeu
	public static final int MAP1 = 1; //Identifiant de la carte 1
	public static final int FPS = 60;
	public static AppGameContainer agc;

	
	public Jeu(String name) {
		super(name);
		this.addState(new Map1(MAP1));
	}

	
	
	@Override
	public void initStatesList(GameContainer game) throws SlickException {
		this.getState(MAP1).init(game, this); // pré-chargement de la map1
		this.enterState(MAP1); //on entre dans la MAP1
	}

	public static void main(String[] args) {
		AppGameContainer agc;
		try {
			agc = new AppGameContainer(new Jeu(NAME));
			agc.setTargetFrameRate(FPS);
			agc.setDisplayMode(320, 320, false); //largeur, hauteur, plein écran
			agc.setShowFPS(true);//affichage du nombre d'images par seconde
			agc.start(); // lancement du jeu
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}

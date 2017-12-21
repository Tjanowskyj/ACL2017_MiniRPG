package Main;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Model.*;
import View.GameOver;
public class Jeu extends StateBasedGame {

	
	
	public static final int JEU = 1; //Identifiant de la carte 1
	public static final int GAMEOVER = 66; //Identifiant de l'état Game Over
	public static final int VICTOIRE = 99;
	
	public Jeu(String name) {
		super(name);
		this.addState(new JeuEnCours());
		this.addState(new GameOver());
	}
	
	@Override
	public void initStatesList(GameContainer game) throws SlickException {
		this.getState(JEU).init(game, this); // pré-chargement de la map1
		this.getState(GAMEOVER).init(game, this);
		this.enterState(JEU); //on entre dans la MAP1
	}


	
}

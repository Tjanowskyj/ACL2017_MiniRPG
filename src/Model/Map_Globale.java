package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Map_Globale extends BasicGameState {

	// protected ArrayList<Monstre> tab_monstres;

	protected TiledMap map; // carte de la classe Map
	protected static Hero p;
	protected StateBasedGame sbg;

	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;

	public abstract void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException;

	public abstract void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException;

	public abstract int getID();

	public void deplacementHero(GameContainer gc, Hero personnage) {
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {

			this.p.changeX(1, map);

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Q)) {

			this.p.changeX(-1,  map);

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Z)) {

			this.p.changeY(-1, map);

		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {

			this.p.changeY(1, map);

		}

	}

}

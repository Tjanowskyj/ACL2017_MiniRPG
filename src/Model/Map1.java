package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Map1 extends Map_Globale {
	
	private int state;
	
	public Map1(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.sbg = sbg;
		this.map = new TiledMap("res/maps/Map1.tmx");
		this.p = new Hero(2,2);
		this.p.init(gc, sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		this.sbg= sbg;
		this.map.render(0,0);
		p.render(gc, sbg, g);		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException {
		this.p.update(gc, sbg, arg0);
		this.sbg= sbg;
		this.deplacementHero(gc, p);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.state;
	}

}

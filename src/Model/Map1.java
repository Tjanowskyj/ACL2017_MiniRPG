package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Main.Jeu;

import java.util.ArrayList;

public class Map1 extends Map {
	
	
	

	public Map1(String tiledMap, int nord, int sud, int est, int ouest)
			throws SlickException {
		super(tiledMap, nord, sud, est, ouest);
		// TODO Auto-generated constructor stub
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		super.init(gc,sbg);
		this.sbg = sbg;
		this.map = new TiledMap("res/maps/Map1.tmx");

	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		super.update(gc, sbg, arg0);
		/*
		if(this.p.getPosX() == 21 && this.p.getPosY() == 1){
			this.sbg.enterState(Jeu.MAP2);
			this.p.setPosX(22);this.p.setPosY(22);
		}*/
	}

}

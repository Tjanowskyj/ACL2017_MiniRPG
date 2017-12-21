package Model;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Main.Jeu;

public class Map2 extends Map {

	

	public Map2(String tiledMap, int nord, int sud, int est, int ouest)
			throws SlickException {
		super(tiledMap, nord, sud, est, ouest);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		super.init(gc, sbg);
		this.sbg = sbg;
		this.map = new TiledMap("res/maps/Map2.tmx");
		initMonstre(gc,sbg);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		super.update(gc, sbg, arg0);

		/*
		if(this.p.getPosX() == 22 && this.p.getPosY() == 23){
			this.sbg.enterState(Jeu.MAP1);
			this.p.setPosX(21);this.p.setPosY(2);
		}*/

	}



}

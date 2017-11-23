package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;

public class Map1 extends Map_Globale {
	
	private int state;
	
	public Map1(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.sbg = sbg;
		this.map = new TiledMap("res/maps/Map1.tmx");
		int xJoueur = 2;
		int yJoueur = 2;
		this.p = new Hero(xJoueur,yJoueur,30);
		this.monstres = new ArrayList<Monstre>();
		this.monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		//this.monstres.add(new Fantome(4,4,5));
		initMonstre(gc,sbg);
		this.p.init(gc, sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		this.sbg= sbg;
		this.map.render(0,0);
		p.render(gc, sbg, g);
		renderMonstre(gc,sbg,g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException {
		this.incrementCompteur();
		this.p.update(gc, sbg, arg0);
		this.sbg= sbg;
		this.deplacementHero(gc, p);
		this.deplacementMonstre();
		//this.degatPersonnage();
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.state;
	}

	private void initMonstre(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for(Monstre m : monstres){
			m.init(gc,sbg);
		}
	}

	private void renderMonstre(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Monstre m : monstres){
			m.render(gc,sbg,g);
		}
	}



}
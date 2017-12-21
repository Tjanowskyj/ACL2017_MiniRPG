package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Main.Jeu;

import java.util.ArrayList;

public class Map1 extends Map_Globale {
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.sbg = sbg;
		this.map = new TiledMap("res/maps/Map1.tmx");
		int xJoueur = 16;
		int yJoueur = 14;
		this.p = new Hero(xJoueur,yJoueur,3);
		this.monstres = new ArrayList<Monstre>();
		this.monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		this.monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		this.monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		this.monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		//this.monstres.add(new Fantome(4,4,5));
		initMonstre(gc,sbg);
		this.p.init(gc, sbg);
		this.initHud(p, gc, sbg);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jeu.MAP1;
	}
}

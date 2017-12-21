package Model;

import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Controlers.Controlers;
import Main.Jeu;
import View.Hud;

public class JeuEnCours extends BasicGameState{

	protected static Hero p;
	protected Hud hud;
	protected Map[] monde;
	protected Map mapLocal;
	private static int compteur = 0;
	protected int xDepart = 16;
	protected int yDepart = 14;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		this.p = new Hero(xDepart,yDepart,3);
		this.p.init(gc, sbg);
		monde = new Map[20];
		monde[0] = new Map("res/maps/Map1.tmx");
		monde[1] = new Map("res/maps/Map2.tmx");
		mapLocal = monde[1];
		hud = new Hud(p);
		hud.init(gc, sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		mapLocal.render(gc, sbg, g);
		p.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		compteur++;
		Controlers.mouvementsHero(gc, p, mapLocal.map);
		this.deplacementMonstre(compteur);
		if(this.p.hp<=0) {
			sbg.enterState(Jeu.GAMEOVER);
		}
		
	}

	@Override
	public int getID() {
		return Jeu.JEU;
	}
	
	
	
	public void deplacementMonstre(int compteur){
		List<Monstre> monstres = mapLocal.monstres;
		TiledMap map = mapLocal.map;
		if(compteur > 60){
			compteur = 0;
			for(Monstre m : monstres){
				m.deplacement(map);
			}
			//degatPersonnage();
		}
	}

	public void degatPersonnage(int compteur) {
		List<Monstre> monstres = mapLocal.monstres;
		TiledMap map = mapLocal.map;
		p.attaquer(compteur,monstres,map,p);
		for(Monstre m : monstres){
			m.attaquer(compteur,monstres,map,p);
		}
	}
	
	
	

}

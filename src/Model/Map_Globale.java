package Model;

import Controlers.Controlers;
import Main.Jeu;
import View.Hud;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.List;
import java.util.Random;

public abstract class Map_Globale extends BasicGameState {

	// protected ArrayList<Monstre> tab_monstres;

	protected TiledMap map; // carte de la classe Map
	protected static Hero p;
	protected StateBasedGame sbg;
	protected static List<Monstre> monstres;
	private static int compteur = 0;
	protected Hud hud;
	
	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;

	public abstract void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException;

	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		this.incrementCompteur();
		this.p.update(gc, sbg, arg0);
		this.hud.update(gc, sbg, arg0);
		this.sbg= sbg;
		this.degatPersonnage();
		this.gameOver(sbg);
		this.deplacementHero(gc, p);
		this.deplacementMonstre();
	}


	public abstract int getID();

	public void deplacementHero(GameContainer gc, Hero personnage) {
		Controlers.mouvementsHero(gc, p, map);
	}
	
	public void initHud(Hero p, GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.hud = new Hud(p);
		this.hud.init(gc, sbg);
	}

	public void deplacementMonstre(){
		if(compteur > 60){
			compteur = 0;
			for(Monstre m : monstres){
				m.deplacement(map);
			}
			//degatPersonnage();
		}
	}
	
	public Monstre placementMonstre(int i,int xJoueur,int yJoueur) {
		Random rand = new Random();
		Monstre res = null;
		int x = rand.nextInt(map.getWidth() - 2) +1;
		int y = rand.nextInt(map.getHeight() - 2) +1;
		int obstacles = map.getLayerIndex("Obstacles");
		int frontiere = map.getLayerIndex("Frontières");
		while(Math.abs(x-xJoueur)<3 && Math.abs(y-yJoueur) < 3
				&& map.getTileId( x, y, obstacles) != 0 && map.getTileId(x,y,frontiere) == 1) { //tant que la case x,y n'est pas une case vide
			x = rand.nextInt(map.getWidth()-2)+1;
			y = rand.nextInt(map.getHeight()-2)+1;
		}
		switch(i) {
		case 0:
			res = new Fantome(x,y,5);
			break;
		default :	
			break;
		}
		
		return res;
	}
	
	public void degatPersonnage() {
		p.attaquer(compteur,monstres,map,p);
		for(Monstre m : monstres){
			m.attaquer(compteur,monstres,map,p);
		}
	}

	public void incrementCompteur(){
		compteur++;
	}
	
	public void gameOver(StateBasedGame sg) {
		if(this.p.estMort()) {
			sg.enterState(Jeu.GAMEOVER);
		}
	}
	

	public void initMonstre(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for(Monstre m : monstres){
			m.init(gc,sbg);
		}
	}

	public void renderMonstre(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Monstre m : monstres){
			m.render(gc,sbg,g);
		}
	}
}

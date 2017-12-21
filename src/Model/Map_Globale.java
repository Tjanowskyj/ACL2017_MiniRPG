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
	protected static List<Monstre> monstres;
	protected static List<Objet> objets;
	private static int compteur = 0;
	protected Hud hud;
	
	private final static String OBSTACLES = "Obstacles";
	private final static String FRONTIERES = "Frontières";
	private final static String POTIONS = "Potions";
	private final static String PIEGES = "Pièges";
	private final static String KEY = "Clef";
	
	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		this.map.render(0,0);
		p.render(gc, sbg, g);
		this.hud.render(gc, sbg, g);
		this.renderMonstre(gc,sbg,g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		this.incrementCompteur();
		this.hud.update(gc, sbg, arg0);
		this.degatPersonnage();
		this.gameOver(sbg);
		this.deplacementHero(gc);
		this.deplacementMonstre();
	}


	public abstract int getID();

	public void deplacementHero(GameContainer gc) {
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
		int obstacles = map.getLayerIndex(OBSTACLES);
		int frontiere = map.getLayerIndex(FRONTIERES);
		while(Math.abs(x-xJoueur)<3 && Math.abs(y-yJoueur) < 3
				&& map.getTileId( x, y, obstacles) != 0 && map.getTileId(x,y,frontiere) == 1) { //tant que la case x,y n'est pas une case vide
			x = rand.nextInt(map.getWidth()-2)+1;
			y = rand.nextInt(map.getHeight()-2)+1;
		}
		switch(i) {
		case 0:
			res = new Fantome(x,y,2);
			res.setDirection("B");
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
	
	
	public void initObjet(GameContainer gc, StateBasedGame sbd, Graphics g) throws SlickException{
		int potion = map.getLayerIndex(POTIONS);
		int piege = map.getLayerIndex(PIEGES);
		int cle = map.getLayerIndex(KEY);
		for(int i = 0 ; i < map.getWidth() ; i++){
			for(int j =0 ; j < map.getHeight() ; j++){
				if(map.getTileId(i,j,potion) == 1){
					objets.add(new Potion(i,j));
				}
				if(map.getTileId(i, j, piege) == 1){
					objets.add(new Piege(i,j));
				}
				if(map.getTileId(i, j, cle) == 1){
					objets.add(new Key(i,j));
				}
			}
		}
		for(Objet o : objets){
			o.init(gc,sbd);
		}
	}
	
	
}

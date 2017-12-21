package Model;

import Controlers.Controlers;
import Main.Jeu;
import View.Hud;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map extends BasicGameState {

	// protected ArrayList<Monstre> tab_monstres;

	protected TiledMap map; // carte de la classe Map
	protected StateBasedGame sbg;
	protected List<Monstre> monstres;
	protected List<Objet> objets;
	protected int[] mapAdjacentes;
	
	
	
	private final static String OBSTACLES = "Obstacles";
	private final static String FRONTIERES = "Frontières";
	private final static String POTIONS = "Potions";
	private final static String PIEGES = "Pièges";
	private final static String KEY = "Clef";
	
	
	public Map(String tiledMap,int nord,int sud,int est,int ouest) throws SlickException{
		this.map = new TiledMap(tiledMap);
		this.monstres = new ArrayList<Monstre>();
		this.mapAdjacentes = new int[4];
		this.mapAdjacentes[0] = nord;
		this.mapAdjacentes[1] = sud;
		this.mapAdjacentes[2] = est;
		this.mapAdjacentes[3] = ouest;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		initMonstre(gc,sbg);
		//initObjet(gc,sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		this.sbg= sbg;
		this.map.render(0,0);
		this.renderMonstre(gc,sbg,g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		this.sbg= sbg;
		
	}


	public int getID(){
		return 0;
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
			res = new Fantome(x,y,2);
			res.setDirection("B");
			break;
		default :	
			break;
		}
		
		return res;
	}
	
	public void ajoutMonstre(int type,int nombre,int xJoueur, int yJoueur){
		for(int i = 0;i<nombre;i++){
			monstres.add(this.placementMonstre(0, xJoueur, yJoueur));
		}
	}
	
	public void initObjet(GameContainer gc, StateBasedGame sbd) throws SlickException{
		int potion = map.getLayerIndex(POTIONS);
		int piege = map.getLayerIndex(PIEGES);
		int cle = map.getLayerIndex(KEY);
		for(int i = 0 ; i < map.getWidth() ; i++){
			for(int j =0 ; j < map.getHeight() ; j++){
				if(map.getTileId(i,j,potion) != 0){
					objets.add(new Potion(i,j));
				}
				if(map.getTileId(i, j, piege) != 0){
					objets.add(new Piege(i,j));
				}
				if(map.getTileId(i, j, cle) != 0){
					objets.add(new Key(i,j));
				}
			}
		}
		for(Objet o : objets){
			o.init(gc,sbd);
		}
	}
	
	
	
}

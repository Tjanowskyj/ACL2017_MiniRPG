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
	protected static List<Monstre> monstres;
	protected int Nord;
	protected int Sud;
	protected int Est;
	protected int Ouest;
	
	public Map(String tiledMap) throws SlickException{
		this.map = new TiledMap(tiledMap);
		this.monstres = new ArrayList<Monstre>();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		initMonstre(gc,sbg);
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
	
}

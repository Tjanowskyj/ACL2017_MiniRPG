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
	private final static String NORD = "Nord";
	private final static String SUD = "Sud";
	private final static String EST = "Est";
	private final static String OUEST = "Ouest";
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		this.p = new Hero(xDepart,yDepart,3);
		this.p.init(gc, sbg);
		monde = new Map[20];
		monde[0] = new Map("res/maps/Map1.tmx",1,2,-1,-1);
		monde[1] = new Map("res/maps/Map2.tmx",-1,0,3,-1);
		monde[2] = new Map("res/maps/Map3.tmx",0,-1,-1,-1);
		monde[3] = new Map("res/maps/Map4.tmx",-1,-1,-1,1);
		monde[4] = new Map("res/maps/Map5.tmx",0,-1,-1,-1);
		hud = new Hud(p);
		hud.init(gc, sbg);
		chargementMap(0,gc,sbg,4,0);
	}
	
	public void chargementMap(int num,GameContainer gc, StateBasedGame sbg,int nbMonstres,int typeM) throws SlickException{
		if(num==2){
			if(this.p.getKey()){
				num=4;
			}
		}
		if(monde[num].monstres.size()==0){
			monde[num].ajoutMonstre(typeM, nbMonstres, p.posX, p.posY);
			monde[num].init(gc, sbg);
		}
		mapLocal = monde[num];
	}
	
	public void changementMap(GameContainer gc, StateBasedGame sbg) throws SlickException{
		TiledMap map = mapLocal.map;
		int nord = map.getLayerIndex(NORD);
		int sud = map.getLayerIndex(SUD);
		int est = map.getLayerIndex(EST);
		int ouest = map.getLayerIndex(OUEST);
		int i = p.posX;int j = p.posY;
		int[] position; 
		if(map.getTileId(i,j,nord) != 0){
			chargementMap(mapLocal.mapAdjacentes[0],gc,sbg,4,0);
			position = getEntre(sud,mapLocal.map);
			p.setPosX(position[0]);
			p.setPosY(position[1]-1);
		}
		if(map.getTileId(i, j, sud) != 0){
			if(mapLocal==monde[4]){
				sbg.enterState(Jeu.VICTOIRE);
			}
			chargementMap(mapLocal.mapAdjacentes[1],gc,sbg,4,0);
			position = getEntre(nord,mapLocal.map);
			p.setPosX(position[0]);
			p.setPosY(position[1]+1);
		}
		if(map.getTileId(i, j, est) != 0){
			chargementMap(mapLocal.mapAdjacentes[2],gc,sbg,4,0);
			position = getEntre(ouest,mapLocal.map);
			p.setPosX(position[0]+1);
			p.setPosY(position[1]);
		}
		if(map.getTileId(i, j, ouest) != 0){
			chargementMap(mapLocal.mapAdjacentes[3],gc,sbg,4,0);
			position = getEntre(est,mapLocal.map);
			p.setPosX(position[0]-1);
			p.setPosY(position[1]);
		}
	}

	public int[] getEntre(int layer,TiledMap map){
		int[] position = new int[2];
		for(int i = 0 ; i < map.getWidth() ; i++){
			for(int j =0 ; j < map.getHeight() ; j++){
				if(map.getTileId(i, j, layer) != 0){
					position[0]=i;position[1]=j;
					break;
				}
			}
		}
		return position;
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		mapLocal.render(gc, sbg, g);
		p.render(gc, sbg, g);
		hud.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		compteur++;
		degatPersonnage(gc);
		Controlers.mouvementsHero(gc, p, mapLocal.map);
		this.deplacementMonstre();
		if(this.p.hp<=0) {
			sbg.enterState(Jeu.GAMEOVER);
		}
		mapLocal.effetObjet(p);
		changementMap(gc,sbg);
		if(compteur > 60){
			compteur = 0;
		}
		
	}

	@Override
	public int getID() {
		return Jeu.JEU;
	}
	
	
	
	public void deplacementMonstre(){
		TiledMap map = mapLocal.map;
		List<Monstre> monstres = mapLocal.monstres;
		if(compteur > 60){
			for(Monstre m : monstres){
				m.deplacement(map);
			}
		}
	}

	public void degatPersonnage(GameContainer gc) {
		TiledMap map = mapLocal.map;
		List<Monstre> monstres = mapLocal.monstres;
		Controlers.attaquerHero(gc,p,map,monstres,compteur);
		for(Monstre m : monstres){
			m.attaquer(compteur,p);
		}
	}
}

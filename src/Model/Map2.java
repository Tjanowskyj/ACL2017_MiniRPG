package Model;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import Main.Jeu;

public class Map2 extends Map_Globale {

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.map = new TiledMap("res/maps/Map2.tmx");
		this.monstres = new ArrayList<Monstre>();
		this.monstres.add(this.placementMonstre(0, this.p.getPosX(), this.p.getPosY()));
		this.monstres.add(this.placementMonstre(0, this.p.getPosX(), this.p.getPosY()));
		this.monstres.add(this.placementMonstre(0, this.p.getPosX(), this.p.getPosY()));
		this.monstres.add(this.placementMonstre(0, this.p.getPosX(), this.p.getPosY()));
		this.monstres.add(new Fantome(4,4,5));
		initMonstre(gc,sbg);
		this.initHud(p, gc, sbg);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException{
		super.update(gc, sbg, arg0);
		if(this.p.getPosX() == 22 && this.p.getPosY() == 21){
			sbg.enterState(Jeu.MAP1);
			this.p.setPosX(22);this.p.setPosY(2);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Jeu.MAP2;
	}

}

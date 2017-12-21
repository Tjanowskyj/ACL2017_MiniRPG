package Controlers;

import Model.Monstre;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.tiled.TiledMap;

import Model.Hero;

import java.util.List;

public class Controlers {

	
	public static boolean mouvementsHero(GameContainer gc, Hero p, TiledMap map){
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {

			p.changeX(1, map);
			p.setDirection("D");
			return true;
		}
		if (gc.getInput().isKeyPressed(Input.KEY_Q) || gc.getInput().isKeyPressed(Input.KEY_A)) { //QWERTY

			p.changeX(-1,  map);
			p.setDirection("G");
			return true;

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Z) || gc.getInput().isKeyPressed(Input.KEY_W)) { //QWERTY

			p.changeY(-1, map);
			p.setDirection("H");
			return true;

		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {

			p.changeY(1, map);
			p.setDirection("B");
			return true;

		}
		return false;
	}

	public static boolean attaquerHero(GameContainer gc, Hero p, TiledMap map, List<Monstre> monstres,int compteur){
		if(gc.getInput().isKeyPressed(Input.KEY_E)){
			p.attaquer(compteur,monstres,map);
			return true;
		}
		return false;

	}
	
}

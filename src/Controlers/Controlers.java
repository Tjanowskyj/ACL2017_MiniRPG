package Controlers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.tiled.TiledMap;

import Model.Hero;

public class Controlers {

	
	public static boolean mouvementsHero(GameContainer gc, Hero p, TiledMap map){
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {

			p.changeX(1, map);
			return true;
		}
		if (gc.getInput().isKeyPressed(Input.KEY_Q) || gc.getInput().isKeyPressed(Input.KEY_A)) { //QWERTY

			p.changeX(-1,  map);
			return true;

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Z) || gc.getInput().isKeyPressed(Input.KEY_W)) { //QWERTY

			p.changeY(-1, map);
			return true;

		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {

			p.changeY(1, map);
			return true;

		}
		return false;
	}
	
}

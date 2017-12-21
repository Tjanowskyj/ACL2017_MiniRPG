package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.List;

public class Fantome extends Monstre {


	public Fantome(int x, int y, int hp) {
		super(x, y, hp);
	}

	@Override
	public void changeX(int x, TiledMap map) {
		int objectLayer = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX + x, this.posY, objectLayer) == 0) {
			this.posX += x;
		}
	}

	@Override
	public void changeY(int y, TiledMap map) {
		int objectLayer = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX, this.posY + y, objectLayer) == 0) {
			this.posY += y;
		}
	}


	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.image = new Image("res/sprites/fantome.png");
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		this.image.draw(this.posX * 32, this.posY * 32);
	}



}



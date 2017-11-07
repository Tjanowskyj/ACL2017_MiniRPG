package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;

public class Hero extends Personnage{
	
	private Image image;

	public Hero(int x, int y) {
		super(x, y);
	}

	@Override
	public void attaquer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		this.image = new Image("res/sprites/herov1.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		this.image.draw(this.posX * 32, this.posY * 32);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void changeX(int x, TiledMap map) {
		int objectLayer = map.getLayerIndex("Obstacles");
		map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX + x, this.posY, objectLayer) == 0) {
			this.posX += x;
		}
	}

	
	public void changeY(int y, TiledMap map) {
		int objectLayer = map.getLayerIndex("Obstacles");
		map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX, this.posY + y, objectLayer) == 0) {
			this.posY += y;
		}		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return -1;
	}

}

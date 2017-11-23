package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Personnage extends BasicGameState {
	protected int posX;
	protected int posY;
	protected int hp;
	protected Image image;
	
	public Personnage(int x, int y, int hp){
		this.posX = x;
		this.hp = hp;
		this.posY = y;
	}
	
	public abstract void changeX(int x, TiledMap map);
	
	public abstract void changeY(int y, TiledMap map);

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return -1;
	}
}

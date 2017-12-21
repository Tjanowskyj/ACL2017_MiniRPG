package Model;

import java.util.List;

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
	protected boolean mort;
	
	public Personnage(int x, int y, int hp){
		this.posX = x;
		this.hp = hp;
		this.posY = y;
		this.mort = false;
	}
	
	public abstract void changeX(int x, TiledMap map);
	
	public abstract void changeY(int y, TiledMap map);

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	public abstract void attaquer(int compteur, List<Monstre> monstres, TiledMap map, Hero p);
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	public int getHp() {
		return hp;
	}

	public void takeDammage(int dps){
		if(this.hp >0) this.hp -= dps;
		if(hp <= 0 ){
			this.mort = true;
		}
	}
	
	public void heal(){
		if(this.hp < 3) this.hp++;
	}

	public boolean estMort() {
		return this.mort;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}

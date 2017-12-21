package Model;

import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;

public abstract class Objet extends BasicGameState{
	protected int posX;
	protected int posY;
	protected Image image; 	
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public abstract void effetObjet(Hero p);
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return -1;
	}
}

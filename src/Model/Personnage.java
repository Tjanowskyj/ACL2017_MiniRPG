package Model;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Personnage extends BasicGameState {
	protected int posX;
	protected int posY;
	protected int hp;	
	
	public Personnage(int x, int y){
		this.posX = x;
		this.hp = 3;
		this.posY = y;
	}
	
	public abstract void attaquer();
	
	/*public void bouger(String s){
		switch (s){
			case "droite":
				if(this.g.dispo(this.posX,this.posY+1))
					this.posY = this.posY+1;
				break;
			case "gauche":
				if(this.g.dispo(this.posX,this.posY-1))
					this.posY = this.posY-1;
				break;
			case "haut":
				if(this.g.dispo(this.posX-1,this.posY))
					this.posX = this.posX -1 ;
				break;
			case "bas":
				if(this.g.dispo(this.posX+1,this.posY))
					this.posX = this.posX +1;
				break;	
		}
	}*/
	
	public abstract void changeX(int x, TiledMap map);
	
	public abstract void changeY(int y, TiledMap map);

	public int getX(){
		return this.posX;
	}

	public int getY(){
		return this.posY;
	}
}

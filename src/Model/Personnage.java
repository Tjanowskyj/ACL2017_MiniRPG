package Model;

public abstract class Personnage {
	protected int posX;
	protected int posY;
	protected int hp;
	
	
	public Personnage(int x, int y, int vie){
		this.posX = x;
		this.hp = vie;
		this.posY = y;
	}
	
	public abstract void attaquer();
	
	public void bouger(String s){
		switch (s){
			case "droite":
				if(Game.dispo(this.posX+1,this.posY))
					this.posX = this.posX+1;
				break;
			case "gauche":
				if(Game.dispo(this.posX-1,this.posY))
					this.posX = this.posX-1;
				break;
			case "haut":
				if(Game.dispo(this.posX,this.posY-1))
					this.posY = this.posY -1 ;
				break;
			case "bas":
				if(Game.dispo(this.posX,this.posY+1))
					this.posY = this.posY +1;
				break;	
		}
	}
}

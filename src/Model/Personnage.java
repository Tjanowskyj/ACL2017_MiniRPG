package Model;

public abstract class Personnage {
	protected int posX;
	protected int posY;
	protected int hp;
	protected Game g;
	
	
	public Personnage(int x, int y, int vie, Game game){
		this.posX = x;
		this.hp = vie;
		this.posY = y;
		this.g = game;
	}
	
	public abstract void attaquer();
	
	public void bouger(String s){
		switch (s){
			case "droite":
				if(this.g.dispo(this.posX+1,this.posY))
					this.posX = this.posX+1;
				break;
			case "gauche":
				if(this.g.dispo(this.posX-1,this.posY))
					this.posX = this.posX-1;
				break;
			case "haut":
				if(this.g.dispo(this.posX,this.posY-1))
					this.posY = this.posY -1 ;
				break;
			case "bas":
				if(this.g.dispo(this.posX,this.posY+1))
					this.posY = this.posY +1;
				break;	
		}
	}
}

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
				this.posX = this.posX+1;
				break;
			case "gauche":
				this.posX = this.posX-1;
				break;
			case "haut":
				this.posY = this.posY -1 ;
				break;
			case "bas":
				this.posY = this.posY +1;
				break;
			
			
		}
	}
}

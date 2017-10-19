package Model;

public class Labyrinthe {

	protected int[][] plateau;
	private final int taille;
	
	
	public Labyrinthe(int t){
		if(t<3){
			t=3;
		}
		this.taille = t;
		plateau = new int[t][t];
		for(int i = 0;i < t;i++){
			for(int j = 0;j < t;j++){
				if(i==0 || i==t-1 || j==0 || j==t-1){
					plateau[i][j] = 1; //mur = 1
				}else{
					plateau[i][j] = 0; //espace vide
				}
			}
		}
	}
	
	public int[][] getPlateau(){
		return this.plateau;
	}
	
	public int getCase(int i, int j){
		return this.plateau[i][j];
	}
	
	public int getTaille(){
		return this.taille;
	}

	public void setPersonnage(int x, int y){
		if(x>0 && x<this.taille-1 && y>0 && y<this.taille-1){
			this.plateau[x][y] = 2;
		}else{
			this.plateau[1][1] = 2;
		}
	}

}

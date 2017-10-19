package Model;

public class Labyrinthe {

	protected int[][] plateau;
	private final int taille;
	
	
	public Labyrinthe(int t){
		if(t<2){
			t=2;
		}
		this.taille = t;
		plateau = new int[t][t];
		for(int i = 0;i < t;i++){
			for(int j = 0;j < t;j++){
				if(i==0 || i==t || j==0 || j==t){
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
	
	public int getTaille(){
		return this.taille;
	}

}

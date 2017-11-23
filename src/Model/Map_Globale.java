package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.List;
import java.util.Random;

public abstract class Map_Globale extends BasicGameState {

	// protected ArrayList<Monstre> tab_monstres;

	protected TiledMap map; // carte de la classe Map
	protected static Hero p;
	protected StateBasedGame sbg;
	protected static List<Monstre> monstres;
	private static int compteur = 0;

	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;

	public abstract void render(GameContainer gc, StateBasedGame stg, Graphics g) throws SlickException;

	public abstract void update(GameContainer gc, StateBasedGame sbg, int arg0) throws SlickException;

	public abstract int getID();

	public void deplacementHero(GameContainer gc, Hero personnage) {
		if (gc.getInput().isKeyPressed(Input.KEY_D)) {

			this.p.changeX(1, map);
			degatPersonnage();

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Q)) {

			this.p.changeX(-1,  map);
			degatPersonnage();

		}
		if (gc.getInput().isKeyPressed(Input.KEY_Z)) {

			this.p.changeY(-1, map);
			degatPersonnage();

		}
		if (gc.getInput().isKeyPressed(Input.KEY_S)) {

			this.p.changeY(1, map);
			degatPersonnage();

		}

	}

	public void deplacementMonstre(){
		if(compteur > 1000){
			compteur = 0;
			for(Monstre m : monstres){
				Random rand = new Random();
				int nombreAleatoire = rand.nextInt(4 - 1 + 1) + 1;
				switch (nombreAleatoire){
					case 1:
						m.changeX(1,map);
						break;
					case 2:
						m.changeX(-1,map);
						break;
					case 3:
						m.changeY(1,map);
						break;
					case 4:
						m.changeY(-1,map);
						break;
				}
			}
			degatPersonnage();
		}
	}
	
	public Monstre placementMonstre(int i,int xJoueur,int yJoueur) {
		Random rand = new Random();
		Monstre res = null;
		int x = rand.nextInt(map.getWidth());
		int y = rand.nextInt(map.getHeight());
		int objectLayer = map.getLayerIndex("Obstacles");
		map.getTileId(0, 0, objectLayer);
		int fantome = map.getLayerIndex("Fantôme");
		map.getTileId(0, 0, fantome);
		while(Math.abs(x-xJoueur)<3 && Math.abs(y-yJoueur)<3
				&& map.getTileId( x, y, objectLayer) != 0
				&& map.getTileId( x, y, fantome) != 0) { //tant que la case x,y n'est pas une case vide
			x = rand.nextInt(map.getWidth()-3)+3;
			y = rand.nextInt(map.getHeight()-3);
		}
		switch(i) {
		case 0:
			res = new Fantome(x,y,5);
			break;
		default :	
			break;
		}
		
		return res;
	}
	
	public void degatPersonnage() {
		int xM,yM,xH,yH;
		xH = this.p.posX;
		yH = this.p.posY;
		boolean dessus,dessous,droite,gauche;
		Monstre m;
		for(int i =0;i<monstres.size();i++) {
			m = monstres.get(i);
			xM = m.posX;
			yM = m.posY;
			dessus = xM==xH && yM<yH;
			dessous = xM==xH && yM>yH;
			droite = xM>xH && yM==yH;
			gauche = xM<xH && yM==yH;
			if(dessus || dessous || droite || gauche) {
				m.hp--;
				p.hp--;
			}
			if(m.hp == 0) {
				monstres.remove(m);
			}
		}
		
	}

	public void incrementCompteur(){
		compteur++;
	}

}

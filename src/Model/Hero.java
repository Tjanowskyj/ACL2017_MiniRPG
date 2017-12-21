package Model;

import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.List;

public class Hero extends Personnage{

	private boolean mort;

	public Hero(int x, int y, int hp) {
		super(x, y,hp);
	}


	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		this.image = new Image("res/sprites/herov1.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		this.image.draw(this.posX * 32, this.posY * 32);
	}



	public void changeX(int x, TiledMap map) {
		int frontiere = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		int obstacle = map.getLayerIndex("Obstacles");
		//map.getTileId(0, 0, fantome);
		if (map.getTileId(this.posX + x, this.posY, frontiere) == 0
				&& map.getTileId( this.posX + x, this.posY, obstacle) == 0) {
			this.posX += x;
		}
	}

	
	public void changeY(int y, TiledMap map) {
		int frontiere = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		int obstacle = map.getLayerIndex("Obstacles");
		//map.getTileId(0, 0, fantome);
		if (map.getTileId(this.posX, this.posY + y, frontiere) == 0
			&& map.getTileId( this.posX , this.posY + y, obstacle) == 0) {
			this.posY += y;
		}		
	}
	
	public void attaquer(int compteur, List<Monstre> monstres, TiledMap map){
		if(compteur > 60) {

			int xM, yM, xH, yH;
			xH = this.posX;
			yH = this.posY;
			boolean dessus, dessous, droite, gauche, confondu, nonObjet;
			Monstre m;
			int obstacle = map.getLayerIndex("Obstacles");
			for (int i = 0; i < monstres.size(); i++) {
				m = monstres.get(i);
				xM = m.getPosX();
				yM = m.getPosY();
				dessous = xM == xH && (((yH - yM) == -1) || ((yH - yM) == -2)) && this.getDirection().equals("B");
				dessus = xM == xH && (((yH - yM) == 1) || ((yH - yM) == 2)) && this.getDirection().equals("H");
				gauche = (((xM-xH) == -1) || (xM-xH) == -2 ) && yM == yH && this.getDirection().equals("G");
				droite = (((xM-xH) == 1) || (xM-xH) == 2) && yM == yH && this.getDirection().equals("D");
				confondu = (xM == xH) && (yM== yH);
				nonObjet = map.getTileId(xM,yM,obstacle) == 0;
				if ((dessus || dessous || droite || gauche || confondu) && nonObjet) {
					m.takeDammage(1);
					System.out.println(m.getHp());
				}
				if (m.getHp() == 0) {
					monstres.remove(m);
				}
			}
		}
	}




}

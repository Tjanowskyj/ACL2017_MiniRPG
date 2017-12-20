package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.List;

public class Fantome extends Monstre {


	public Fantome(int x, int y, int hp) {
		super(x, y, hp);
	}

	@Override
	public void changeX(int x, TiledMap map) {
		int objectLayer = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX + x, this.posY, objectLayer) == 0) {
			this.posX += x;
		}
	}

	@Override
	public void changeY(int y, TiledMap map) {
		int objectLayer = map.getLayerIndex("Frontières");
		//map.getTileId(0, 0, objectLayer);
		if (map.getTileId(this.posX, this.posY + y, objectLayer) == 0) {
			this.posY += y;
		}
	}


	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.image = new Image("res/sprites/fantome.png");
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		this.image.draw(this.posX * 32, this.posY * 32);
	}

	@Override
	public void attaquer(int compteur, List<Monstre> monstres, TiledMap map,Hero p) {
		if(compteur > 60) {

			int xM, yM, xH, yH;
			xM = this.posX;
			yM = this.posY;
			boolean dessus, dessous, droite, gauche, confondu;
			xH = p.getPosX();
			yH = p.getPosY();
			dessus = xM == xH && ((yH - yM) == -1);
			dessous = xM == xH && ((yH - yM) == 1);
			droite = ((xM-xH) == -1) && yM == yH;
			gauche = ((xM-xH) == 1) && yM == yH;
			confondu = (xM == xH) && (yM== yH);
			if (dessus || dessous || droite || gauche || confondu) {
				p.takeDammage(1);
			}
		}
	}

}



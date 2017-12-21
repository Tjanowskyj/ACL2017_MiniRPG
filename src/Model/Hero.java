package Model;

import java.util.List;

import org.newdawn.slick.Animation;
import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Hero extends Personnage{

	private boolean mort;
	private boolean key;
	private static Animation haut;
	private static Animation bas;
	private static Animation gauche;
	private static Animation droite;

	

	public Hero(int x, int y, int hp) {
		super(x, y,hp);
		key = false;
	}


	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		this.image = new Image("res/sprites/herov1.png");
		SpriteSheet g = new SpriteSheet("res/sprites/heros/gauche.png",
				32, 32);
		SpriteSheet d = new SpriteSheet("res/sprites/heros/droite.png",
				32, 32);
		SpriteSheet b = new SpriteSheet("res/sprites/heros/bas.png", 32,
				32);
		SpriteSheet h = new SpriteSheet("res/sprites/heros/haut.png", 32,
				32);
		this.haut = new Animation();
		this.bas = new Animation();
		this.gauche = new Animation();
		this.droite = new Animation();
		
		for(int i = 0;i < 3;i++){
			this.haut.addFrame(h.getSprite(i, 0), 150);
			this.bas.addFrame(b.getSprite(i, 0), 150);
			this.gauche.addFrame(g.getSprite(i, 0), 150);
			this.droite.addFrame(d.getSprite(i, 0), 150);
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		switch(this.direction){
		
		case "H":
			this.haut.draw(this.posX * 32, this.posY * 32);
			break;
		case "B" :
			this.bas.draw(this.posX * 32, this.posY * 32);
			break;
		case "G" :
			this.gauche.draw(this.posX * 32, this.posY * 32);
			break;
		case "D":
			this.droite.draw(this.posX * 32, this.posY * 32);
			break;
		}
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
			int xM, yM, xH, yH;
			xH = this.posX;
			yH = this.posY;
			Monstre m;
			int obstacle = map.getLayerIndex("Obstacles");
			for (int i = 0; i < monstres.size(); i++) {
				boolean dessus = false;
				boolean dessous = false;
				boolean droite = false;
				boolean gauche = false;
				boolean confondu = false;
				boolean nonObjet = false;
				m = monstres.get(i);
				xM = m.getPosX();
				yM = m.getPosY();
				int distance = (int)Math.abs(Math.sqrt(Math.pow(xM-xH,2.0) + Math.pow(yM-yH,2.0)));
				if(((distance >= 0) && (distance <= 2))){
					switch (this.getDirection()){
						case "H" :
							if(((yH - distance) == yM) && (xM == xH)){
								dessus = true;
							}
							break;

						case "B" :
							if(((yH + distance) == yM) && (xM == xH)){
								dessous = true;
							}
							break;

						case "G" :
							if(((xH - distance) == xM) && (yM==yH)){
								gauche = true;
							}
							break;

						case "D" :
							if(((xH + distance) == xM )&& (yM==yH)){
								droite = true;
							}
							break;
						default:
							break;
					}
				}
				confondu = (xM == xH) && (yM== yH);
				nonObjet = (map.getTileId(xM,yM,obstacle) == 0);
				if ((dessus || dessous || droite || gauche || confondu) && nonObjet) {
					m.takeDammage(1);
				}
				if (m.getHp() == 0) {
					monstres.remove(m);
				}
			}

	}


	public void getKey(){
		this.key = true;
	}

}

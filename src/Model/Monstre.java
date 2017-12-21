package Model;

import org.newdawn.slick.tiled.TiledMap;

import java.util.Random;

public abstract class Monstre extends Personnage {

    public Monstre(int x, int y, int hp) {
        super(x, y,hp);
    }
    
    public void deplacement(TiledMap map){
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(4 - 1 + 1) + 1;
        switch (nombreAleatoire){
            case 1:
                this.changeX(1,map);
                this.setDirection("D");
                break;
            case 2:
                this.changeX(-1,map);
                this.setDirection("G");
                break;
            case 3:
                this.changeY(1,map);
                this.setDirection("B");
                break;
            case 4:
                this.changeY(-1,map);
                this.setDirection("H");
                break;
        }
    }
}

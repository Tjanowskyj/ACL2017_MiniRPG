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

    public void attaquer(int compteur,Hero p) {
        if(compteur > 60) {
            int xM, yM, xH, yH;
            xM = this.posX;
            yM = this.posY;
            boolean dessus, dessous, droite, gauche, confondu;
            xH = p.getPosX();
            yH = p.getPosY();
            dessous = xM == xH && ((yH - yM) == -1);
            dessus = xM == xH && ((yH - yM) == 1);
            droite = ((xM-xH) == -1) && yM == yH;
            gauche = ((xM-xH) == 1) && yM == yH;
            confondu = (xM == xH) && (yM== yH);
            if (dessus || dessous || droite || gauche || confondu) {
                p.takeDammage(1);
            }
        }
    }
}

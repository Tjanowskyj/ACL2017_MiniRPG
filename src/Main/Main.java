package Main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		AppGameContainer agc;
		try {
			agc = new AppGameContainer(new Jeu("MiniRPG"));
			agc.setTargetFrameRate(60);
			agc.setDisplayMode(1024, 800, false); //largeur, hauteur, plein écran
			//agc.setFullscreen(true);
			agc.setShowFPS(true);//affichage du nombre d'images par seconde
			agc.start(); // lancement du jeu
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}

}

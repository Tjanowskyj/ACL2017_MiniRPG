package View;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Model.Hero;

public class Hud extends BasicGameState {

	private static Image[] coeurs;
	private Hero p;
	
	public Hud(Hero p) {
		this.p = p;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		this.coeurs = new Image[4];
		for (int i = 0; i < 4; i++) {
			this.coeurs[i] = new Image("res/hud/coeur_" + i + ".png");
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		if(this.p.getHp() >= 3) {	
			this.coeurs[3].draw(0,0);
		}else this.coeurs[this.p.getHp()].draw(0,0);	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return -1;
	}

}

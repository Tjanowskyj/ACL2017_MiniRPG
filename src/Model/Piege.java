package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Piege extends Objet{
	
	public Piege(int x, int y){
		this.posX = x;
		this.posY = y;
		this.active = true;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		this.image = new Image("res/sprites/Piege.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		this.image.draw(this.posX * 32, this.posY * 32);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effetObjet(Hero p) {
		// TODO Auto-generated method stub
		p.takeDammage(1);
	}

}

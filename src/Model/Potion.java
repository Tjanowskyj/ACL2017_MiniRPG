package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Potion extends Objet{

	public Potion(int x, int y){
		this.posX = x;
		this.posY = y;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		this.image = new Image("res/sprites/objets/Potion.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		this.image.draw(this.posX * 32, this.posY * 32);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void effetObjet(Hero p) {
		// TODO Auto-generated method stub
		p.heal();
	}



}

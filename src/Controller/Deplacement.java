package Controller;

import Model.Game;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Deplacement implements KeyListener {

    private Game game;

    public Deplacement(Game g){
        this.game = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Z){
            this.game.bouger("haut");
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            this.game.bouger("gauche");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            this.game.bouger("bas");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.game.bouger("droite");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

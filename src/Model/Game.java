package Model;

import java.util.Observable;

import Controller.Deplacement;
import View.VueTerminal;

import javax.swing.*;

public class Game extends Observable {

 /*   private Labyrinthe labyrinthe;
    private Personnage personnage;
    private VueTerminal vueTerminal;

    public Game(){
        this.labyrinthe = new Labyrinthe(10);
        this.personnage = new Hero(5,5,30, this);
        this.labyrinthe.setPersonnage(5,5);
        this.vueTerminal = new VueTerminal();
        this.addObserver(this.vueTerminal);
        this.setChanged();
        this.notifyObservers();

    }

    public void bouger(String d){
        this.labyrinthe.setCaseVide(personnage.getX(),personnage.getY());
        this.personnage.bouger(d);
        this.labyrinthe.setPersonnage(personnage.getX(),personnage.getY());
        this.setChanged();
        this.notifyObservers();
    }

    public Labyrinthe getLabyrinthe(){
        return this.labyrinthe;
    }

    public boolean dispo(int x, int y){
        return this.labyrinthe.getCase(x,y) == 0 ;
    }*/

}

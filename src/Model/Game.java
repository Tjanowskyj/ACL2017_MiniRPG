package Model;

import java.util.Observable;
import View.VueTerminal;

public class Game extends Observable {

    private Labyrinthe labyrinthe;
    private Personnage personnage;
    private VueTerminal vueTerminal;

    public Game(){
        this.labyrinthe = new Labyrinthe(10);
        this.personnage = new Hero(5,5,30, this);
        this.vueTerminal = new VueTerminal();
        this.addObserver(this.vueTerminal);
        this.setChanged();
        this.notifyObservers();
    }

    public void bouger(String d){
        this.personnage.bouger(d);
        this.setChanged();
        this.notifyObservers();
    }

    public Labyrinthe getLabyrinthe(){
        return this.labyrinthe;
    }

    public boolean dispo(int x, int y){
        return this.labyrinthe.getCase(x,y) == 0 ;
    }

}

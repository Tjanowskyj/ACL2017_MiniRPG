package Model;

import java.util.Observable;

public class Game extends Observable {

    private Labyrinthe labyrinthe;
    private Personnage personnage;
    private VueTerminale vueTerminale;

    public Game(){
        this.labyrinthe = new Labyrinthe();
        this.personnage = new Personnage(5,5,30);
        this.vueTerminale = new VueTerminake();
        this.addObserver(this.vueTerminale);
        this.setChanged();
        this.notifyObservers();
    }

    public void bouger(String d){
        this.personnage.bouger(d);
        this.setChanged();
        this.notifyObservers();
    }

    public int[][] getLabyrinthe(){
        return this.labyrinthe.getPlateau();
    }

    public static boolean dispo(int x, int y){
        return labyrinthe.getCase(x,y) == 0 ;
    }

}

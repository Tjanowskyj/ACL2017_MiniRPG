package Test;

import Model.Labyrinthe;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LabyrintheTest {

    @Test
    public void getCase() throws Exception {
        Labyrinthe l = new Labyrinthe(5);
        l.setPersonnage(2,2);
        assertTrue(l.getCase(2,2) == 2);
        assertTrue(l.getCase(0,0) == 1);
        assertTrue(l.getCase(1,1) == 0);
    }

    @Test
    public void getTaille() throws Exception {
        Labyrinthe l = new Labyrinthe(5);
        assertTrue(l.getTaille() == 5);
        assertTrue(l.getPlateau()[0].length == 5);
        assertTrue(l.getPlateau().length == 5);
    }

    @Test
    public void setPersonnage() throws Exception {
        Labyrinthe l = new Labyrinthe(5);
        l.setPersonnage(2,2);
        assertTrue(l.getCase(2,2) == 2);
    }

    @Test
    public void setPersonnage2() throws Exception {
        Labyrinthe l = new Labyrinthe(5);
        l.setPersonnage(8,8);
        assertTrue(l.getCase(1,1) == 2);
    }

    @Test
    public void setCaseVide() throws Exception {
        Labyrinthe l = new Labyrinthe(5);
        l.setPersonnage(2,2);
        assertTrue(l.getCase(2,2) == 2);
        l.setCaseVide(2,2);
        assertTrue(l.getCase(2,2) == 0);
    }

}
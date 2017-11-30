package Test;

import Model.Game;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void bougerHaut() throws Exception {
        Game g = new Game();
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(4,5) == 2);
    }

    @Test
    public void bougerBas() throws Exception {
        Game g = new Game();
        g.bouger("bas");
        assertTrue(g.getLabyrinthe().getCase(6,5) == 2);
    }

    @Test
    public void bougerDroite() throws Exception {
        Game g = new Game();
        g.bouger("droite");
        assertTrue(g.getLabyrinthe().getCase(5,6) == 2);
    }

    @Test
    public void bougerGauche() throws Exception {
        Game g = new Game();
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,4) == 2);
    }

    @Test
    public void bougerGaucheBloquerMur() throws Exception {
        Game g = new Game();
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,4) == 2);
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,3) == 2);
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,2) == 2);
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,1) == 2);
        g.bouger("gauche");
        assertTrue(g.getLabyrinthe().getCase(5,1) == 2);
    }

    @Test
    public void bougerDroiteBloquerMur() throws Exception {
        Game g = new Game();
        g.bouger("droite");
        assertTrue(g.getLabyrinthe().getCase(5,6) == 2);
        g.bouger("droite");
        assertTrue(g.getLabyrinthe().getCase(5,7) == 2);
        g.bouger("droite");
        assertTrue(g.getLabyrinthe().getCase(5,8) == 2);
        g.bouger("droite");
        assertTrue(g.getLabyrinthe().getCase(5,8) == 2);

    }

    @Test
    public void bougerBasBloquerMur() throws Exception {
        Game g = new Game();
        g.bouger("bas");
        assertTrue(g.getLabyrinthe().getCase(6,5) == 2);
        g.bouger("bas");
        assertTrue(g.getLabyrinthe().getCase(7,5) == 2);
        g.bouger("bas");
        assertTrue(g.getLabyrinthe().getCase(8,5) == 2);
        g.bouger("bas");
        assertTrue(g.getLabyrinthe().getCase(8,5) == 2);

    }

    @Test
    public void bougerHautBloquerMur() throws Exception {
        Game g = new Game();
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(4,5) == 2);
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(3,5) == 2);
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(2,5) == 2);
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(1,5) == 2);
        g.bouger("haut");
        assertTrue(g.getLabyrinthe().getCase(1,5) == 2);

    }
    
    @Test 
    public void dispoCase(){
    	Game g = new Game();
    	
    }




}
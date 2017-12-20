package Tests;

import Model.Fantome;
import Model.Hero;
import Model.Monstre;
import junit.framework.*;
import org.junit.Test;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;
import java.util.List;

public class TestV2 extends TestCase{

    /**
     * Cas normal du test d'attaque du Héro
     * @throws Exception
     */
    @Test
    public void testAttaqueJoueur() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(2,2,5);
        Fantome f = new Fantome(2,1,3);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        h.attaquer(61,l,t,h);
        assertEquals("Les hps du monstres devraient être plus bas.",2,f.getHp());
    }


    /**
     * Cas normal du test d'attaque d'un fantôme/monstre
     * @throws Exception
     */
    @Test
    public void testAttaqueMonstre() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(2,2,5);
        Fantome f = new Fantome(2,1,3);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        f.attaquer(61,l,t,h);
        assertEquals("Les hps du Joueur devraient être plus bas.",4,h.getHp());
    }


    /**
     * Test permettant de vérifier qu'un monstre se déplace bien de façon aléatoire.
     * /!\ NOTE : de temps en temps ce test ne passe pas, car l'algorithme de déplacement des monstres est un simple random, cela sera changer par la suite.
     * @throws Exception
     */
    @Test
    public void testDeplacementMonstre() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Fantome f = new Fantome(2,1,3);
        int xInit = 2;
        int yInit = 1;
        f.deplacement(t);
        assertFalse("Les coordonnées du monstre devraient être modifiées.",((xInit == f.getPosX()) && (yInit == f.getPosY())));
    }


    /**
     * Test permettant de vérifier qu'un Fantôme est bien intouchable lorsqu'il se trouve dans un obstacle.
     * @throws Exception
     */
    @Test
    public void testAttaqueJoueurMonstreIntouchable() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(4,2,5);
        Fantome f = new Fantome(4,3,3);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        h.attaquer(61,l,t,h);
        assertEquals("Les hps du monstres ne devraient pas être diminuées.",3,f.getHp());
    }

    /**
     * Test permettant de vérifier qu'un Fantôme peut toucher lorsqu'il est dans un obstacle
     * @throws Exception
     */
    @Test
    public void testAttaqueMonstreDansObstacle() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(4,2,5);
        Fantome f = new Fantome(4,3,3);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        f.attaquer(61,l,t,h);
        assertEquals("Les hps du héro devraient être plus bas.",4,h.getHp());
    }

    /**
     * Test permettant de vérifier que le héro et un monstre prennent bien des dégâts si leur coordonnées sont confondus.
     * @throws Exception
     */
    @Test
    public void testAttaqueJoueurMonstreConfondu() throws Exception{
        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(4,2,5);
        Fantome f = new Fantome(4,2,3);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        h.attaquer(61,l,t,h);
        f.attaquer(61,l,t,h);
        assertEquals("Les hps du monstres devraient être plus bas.",2,f.getHp());
        assertEquals("Les hps du héro devraient être plus bas",4,h.getHp());
    }

    @Test
    public void testMonstreDisparait() throws Exception{

        TiledMap t = new TiledMap("res/maps/Map1.tmx",false);
        Hero h = new Hero(4,2,5);
        Fantome f = new Fantome(4,2,1);
        List<Monstre> l = new ArrayList<Monstre>();
        l.add(f);
        h.attaquer(61,l,t,h);
        assertTrue("Le monstre ne devrait plus être dans la liste (il a perdu tous ses hps)",l.isEmpty());
    }
}

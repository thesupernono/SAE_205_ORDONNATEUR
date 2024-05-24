package modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JoueurTest{
    Joueur testJoueur = new Joueur(1,1);

    @Test
    void limiteTerrain(){
        //tests limite >= 12
        testJoueur.deplacement(new Position(12,1));
        assertEquals(11, testJoueur.getPosition().getPosX());
        testJoueur.deplacement(new Position(1,12));
        assertEquals(11, testJoueur.getPosition().getPosY());

        //tests limite <=0
        testJoueur.deplacement(new Position(0,1));
        assertEquals(1, testJoueur.getPosition().getPosX());
        testJoueur.deplacement(new Position(1,0));
        assertEquals(1, testJoueur.getPosition().getPosY());
    }

}


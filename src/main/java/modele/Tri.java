package modele;

import interfaces.CONSTANTES_MAP;

import java.util.Collection;
import java.util.HashMap;

/**
 * Objet qui contient les différents tris
 */
public class Tri implements CONSTANTES_MAP {

    private final HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
    private Position posJoueur = Map.getJoueur().getPosition();


    /**
     * Fait un tri basique par couleurs en bulle
     */
    public void TriBasique(){
        int taille = listeTemples.length;
        Temple tampon;
        for(int i=0; i < taille; i++) { //parcours la liste
            for(int j=1; j < (taille-i); j++) {
                if(listeTemples[j-1].getCouleur() > listeTemples[j].getCouleur()) {
                    //echanges les elements
                    tampon = listeTemples[j-1];
                    listeTemples[j-1] = listeTemples[j];
                    listeTemples[j] = tampon;
                }
            }
        }
    }

    /**
     * Fait un tri heuristique distances
     */
    public void TriHeuristique(){
        for (int i = 0; i < listeTemples.length; i++) { // on parcours tout les temples pour trouver les distances à trier
            boolean templesTriee = true; // variable permettant de stopper la boucle si le tri est terminé

            for(int j = 0; j < listeTemples.length - 1; j++){// verifie si nous sommes pas en fin de tableau
                int distance = posJoueur.distance(listeTemples[j].getPosition());
                int distanceDapres = posJoueur.distance(listeTemples[j+1].getPosition());
                if (distanceDapres < distance){
                    // echange les éléments
                    Temple tampon = listeTemples[j + 1];
                    listeTemples[j + 1] = listeTemples[j];
                    listeTemples[j] = tampon;

                    // continue le tableau en mettant la variable en false
                    templesTriee = false;
                }
            }
            if (templesTriee){
                break; // arrete la boucle
            }
        }
    }
}

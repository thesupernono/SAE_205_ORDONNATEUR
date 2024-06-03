package modele;

import java.util.Collection;
import java.util.HashMap;

public class Tri implements CONSTANTES_MAP{

    private final HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
    private Position posJoueur = Map.getJoueur().getPosition();


    /**
     * Fait un tri basique par couleurs en bulle
     */
    public void TriBasique(){
        int taille = listeTemples.length;
        Temple tampon;
        for(int i=0; i < taille; i++) {
            for(int j=1; j < (taille-i); j++) {
                if(listeTemples[j-1].getCouleur() > listeTemples[j].getCouleur()) {
                    //echanges des elements
                    tampon = listeTemples[j-1];
                    listeTemples[j-1] = listeTemples[j];
                    listeTemples[j] = tampon;
                }

            }
        }
    }

    public void TriHeuristique(){
        for (int i = 0; i < listeTemples.length; i++) { // on parcours tout les temples pour trouver les distances à trier
            // int distanceJoueur = posJoueur.distance(listeTemples[i].getPosition());
            for(int j = 0; j < listeTemples.length - 1; j++){// verifie si nous sommes pas en fin de tableau
                int distance = posJoueur.distance(listeTemples[j].getPosition());
                int distanceDapres = posJoueur.distance(listeTemples[j+1].getPosition());
                if (distanceDapres < distance){
                    Temple tampon = listeTemples[j + 1];
                    listeTemples[j + 1] = listeTemples[j];
                    listeTemples[j] = tampon;
                }
            }
        }
    }

    public Collection<Temple> getHashTemples(){
        return hashTemples.values();
    }

    public String toString() {
        String string = "";
        for (Temple temple : listeTemples) {
            string += "[" + temple.getPosition().getPosX() + ", " + temple.getPosition().getPosY() + ", " + temple.getPosition().distance(posJoueur) + ", " + temple.getCouleur() + "] ";
        }
        return string;
    }
}

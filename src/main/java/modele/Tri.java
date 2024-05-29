package modele;

import java.util.Collection;
import java.util.HashMap;

public class Tri implements CONSTANTES_MAP{

    private final HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
    private Position posJoueur = Map.getJoueur().getPosition();


    /**
     * Fait un tri basique en bulle
     */
    public void TriBasique(){
        for(int i=0; i < hashTemples.size(); i++){ // on parcours tout les temples pour trouver les distances à trier
            if(i < hashTemples.size() - 1) {// verifie si nous sommes pas en fin de tableau
                int distanceJoueur = posJoueur.distance(listeTemples[i].getPosition());
                int distanceDapres = posJoueur.distance(listeTemples[i + 1].getPosition());
                if(distanceJoueur < distanceDapres){
                    Temple tampon = listeTemples[i + 1];
                    listeTemples[i + 1] = listeTemples[i];
                    listeTemples[i] = tampon;
                }
            }
        }
    }

    public void TriHeuristique(Position [] parPositions){

    }

    public Collection<Temple> getHashTemples(){
        return hashTemples.values();
    }

    public String toString() {
        String string = "";
        for (Temple temple : listeTemples) {
            string += "[" + temple.getPosition().getPosX() + ", " + temple.getPosition().getPosY() + ", " + temple.getPosition().distance(posJoueur) +"] ";
        }
        return string;
    }
}

package modele;

import java.util.Collection;
import java.util.HashMap;

public class Tri implements CONSTANTES_MAP{

    private final HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
    private Position [] positionsTri;


    /**
     * Fait un tri basique en bulle
     */
    public void TriBasique(){
        Position posJoueur = Map.getJoueur().getPosition();

        for(Temple temple : listeTemples){ // on parcours tout les temples pour trier les distances
            /*int [] distance = {
                    temple.getPosition().getPosX() - posJoueur.getPosX(),
                    temple.getPosition().getPosY() - posJoueur.getPosY()
            };*/
            int distance = temple.getPosition().getPosX() - posJoueur.getPosX() + temple.getPosition().getPosY() - posJoueur.getPosY();

            if
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
            string += "[" + temple.getPosition().getPosX() + ", " + temple.getPosition().getPosY() + "] ";
        }
        return string;
    }
}

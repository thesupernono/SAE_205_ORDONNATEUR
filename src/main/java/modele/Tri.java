package modele;

import java.util.Collection;
import java.util.HashMap;

public class Tri implements CONSTANTES_MAP{

    private final HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array

    public void TriBasique(){
        Position posJoueur = Map.getJoueur().getPosition();
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

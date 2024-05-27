package modele;

import java.util.HashMap;

public class Tri implements CONSTANTES_MAP{
    private HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
    private Temple [] listeTemple; // la liste des positions des temples

    public void TriBasique(){
        //on scan la Map pour la liste des temples disponibles
        for(int y = 0; y <NOMBRE_CARRE; y++){
            int indice = 0;
            for(int x = 0; x <NOMBRE_CARRE; x++){
                listeTemple[indice] = hashTemples.get(new Position(x,y));
                indice++;
            }
        }
    }

    public void TriHeuristique(Position [] parPositions){

    }
}

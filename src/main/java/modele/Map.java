package modele;

import java.util.HashMap;
import java.util.HashSet;

public class Map implements CONSTANTES_MAP{

    // Les cristaux et les temples sont stockés avec comme clé leur position (position_x, position_y)
    // Ils ont comme valeur un

    HashMap<Position, Temple> coordonneesTemples = new HashMap<>();
    HashMap<Position, Cristal> coordonneesCristaux = new HashMap<>();

    public Map(String parNomFichierScenario) throws Exception {

        // On génère la map
        LectureScenario scenario = new LectureScenario(parNomFichierScenario);
        HashSet<Temple> listeTemple = scenario.getTemple();
        HashSet<Cristal> listeCristal = scenario.getCristal();


        // On stock les positions de tous les temples
        for(Temple temple: listeTemple){


            // On initie le temple
            coordonneesTemples.put(temple.getPosition(), temple);
        }


        // On stock les positions de tous les cristaux
        for(Cristal cristal: listeCristal){


            // On initie le cristal
            coordonneesCristaux.put(cristal.getPosition(), cristal);
        }
    }


    public HashMap<Position, Temple> getCoordonneesTemples(){
        return coordonneesTemples;
    }


    public HashMap<Position, Cristal> getCoordonneesCristaux(){
        return coordonneesCristaux;
    }
}

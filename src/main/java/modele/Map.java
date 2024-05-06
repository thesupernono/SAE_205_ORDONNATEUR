package modele;

import java.util.HashMap;
import java.util.HashSet;

public class Map implements CONSTANTES_MAP{

    // Les cristaux et les temples sont stockés avec comme clé leur position (position_x, position_y)
    // Ils ont comme valeur un

    HashMap<int [], Temple> coordonneesTemples = new HashMap<>();
    HashMap<int [], Cristal> coordonneesCristaux = new HashMap<>();

    public Map(String parNomFichierScenario) throws Exception {

        // On génère la map
        LectureScenario scenario = new LectureScenario(parNomFichierScenario);
        HashSet<Temple> listeTemple = scenario.getTemple();
        HashSet<Cristal> listeCristal = scenario.getCristal();


        // On génère le joueur
        Joueur joueur = new Joueur(CENTRE_X, CENTRE_Y);


        // On stock les positions de tous les Temples
        for(Temple temple: listeTemple){


            // On initie le temple
            coordonneesTemples.put(temple.getPosition(), temple);
        }


        // On stock les positions de tous les Cristaux
        for(Cristal cristal: listeCristal){


            // On initie les cristaux
            coordonneesCristaux.put(cristal.getPosition(), cristal);
        }
    }


    public HashMap<int [], Temple> getCoordonneesTemples(){
        return coordonneesTemples;
    }


    public HashMap<int [], Cristal> getCoordonneesCristaux(){
        return coordonneesCristaux;
    }
}

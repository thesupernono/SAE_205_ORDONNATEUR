package modele;

import java.util.HashMap;
import java.util.HashSet;

public class Map implements CONSTANTES_MAP{

    HashMap<int [], HashSet<Temple>> coordonneesTemples = new HashMap<>();
    HashMap<int [], HashSet<Cristal>> coordonneesCristal = new HashMap<>();

    public Map(String parNomFichierScenario) throws Exception {

        // On génère la map
        LectureScenario scenario = new LectureScenario(parNomFichierScenario);
        HashSet<Temple> listeTemple = scenario.listeTemple();
        HashSet<Cristal> listeCristal = scenario.listeCristal();


        // On génère le joueur
        Joueur joueur = new Joueur(CENTRE_X, CENTRE_Y);


        // On stock les positions de tous les Temples
        for(Temple temple: listeTemple){


            // On vérifie si d'autres éléments ont déjà été initié à cet emplacement
            // On initie si il n'y a pas encore d'élément
            if (!coordonneesTemples.containsKey(temple.getPosition())){
                HashSet<Temple> nouveauHashSet = new HashSet<>();
                nouveauHashSet.add(temple);
                coordonneesTemples.put(temple.getPosition(), nouveauHashSet);
            }
            else{
                // Si il y a déjà un élément, on reprend juste la liste associé à la position, et on ajoute le temple
                HashSet<Temple> listeAuCoordonnees = coordonneesTemples.get(temple.getPosition());
                listeAuCoordonnees.add(temple);
            }
        }


        // On stock les positions de tous les Cristaux
        for(Cristal cristal: listeCristal){


            // On vérifie si d'autres éléments ont déjà été initié à cet emplacement
            // On initie si il n'y a pas encore d'élément
            if (!coordonneesCristal.containsKey(cristal.getPosition())){
                HashSet<Cristal> nouveauHashSet = new HashSet<>();
                nouveauHashSet.add(cristal);
                coordonneesCristal.put(cristal.getPosition(), nouveauHashSet);
            }
            else{
                // Si il y a déjà un élément, on reprend juste la liste associé à la position, et on ajoute le temple
                HashSet<Cristal> listeAuCoordonnees = coordonneesCristal.get(cristal.getPosition());
                listeAuCoordonnees.add(cristal);
            }
        }
    }
}

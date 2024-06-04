package modele;

import interfaces.CONSTANTES_MAP;
import vue.VBoxInfos;
import vue.VBoxTemple;

import java.util.HashMap;
import java.util.HashSet;

public class Map implements CONSTANTES_MAP {

    // Les cristaux et les temples sont stockés avec comme clé leur position (position_x, position_y)
    // Ils ont comme valeur un

    private static HashMap<Position, Temple> coordonneesTemples = new HashMap<>();
    private static HashMap<Position, Cristal> coordonneesCristaux = new HashMap<>();
    private static Joueur joueur;


    public Map(String parNomFichierScenario) throws Exception {

        // On récupère la liste des éléments généré pour éviter redessiner que les cases qui en on besoin

        // Etant donné que les cristaux ne peuvent être posé que sur les temples

        VBoxTemple.resetMap();
        resetCoordonnees();

        // On génère la map
        new LectureScenario(parNomFichierScenario);

        // On récupère les informations de la lecture du derner scenario
        HashSet<Temple> listeTemple = LectureScenario.getTemple();
        HashSet<Cristal> listeCristal = LectureScenario.getCristal();
        System.out.println("--------------------");
        System.out.println("Position des Temples : " + listeTemple);
        System.out.println("position des Cistaux : " + listeCristal);
        joueur = new Joueur(CENTRE_X, CENTRE_Y);


        // On stock les positions de tous les temples
        for (Temple temple : listeTemple) {


            // On initie le temple
            coordonneesTemples.put(temple.getPosition(), temple);
        }


        // On stock les positions de tous les cristaux
        for (Cristal cristal : listeCristal) {

            // On initie le cristal
            coordonneesCristaux.put(cristal.getPosition(), cristal);
        }

        // On clear la map, au cas où il y avait déjà un scenario
        VBoxTemple.resetMap();


        //-----------------Cristaux et temples-----------------
        // On reset les graphique des anciens éléments
        if (!VBoxInfos.premierLancement){
            ElementsGraphiques.resetAll();
        System.out.println("---------resetAll--------------");
    }
        VBoxInfos.premierLancement = false;

        for (Temple temple: listeTemple){
            ElementsGraphiques.dessinerElement(temple);
        }

        for (Cristal cristal: listeCristal){
            ElementsGraphiques.dessinerElement(cristal);
        }
        // On affiche le joueur
        ElementsGraphiques.dessinerElement(joueur);
    }


    public static HashMap<Position, Temple> getCoordonneesTemples(){
        return coordonneesTemples;
    }


    public static HashMap<Position, Cristal> getCoordonneesCristaux(){
        return coordonneesCristaux;
    }

    public static Joueur getJoueur() {
        return joueur;
    }

    public void resetCoordonnees(){
        coordonneesCristaux.clear();
        coordonneesTemples.clear();
    }
}

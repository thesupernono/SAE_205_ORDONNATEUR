package modele;

import javafx.scene.canvas.GraphicsContext;
import vue.VBoxTemple;

import java.util.HashMap;
import java.util.HashSet;

public class Map implements CONSTANTES_MAP{

    // Les cristaux et les temples sont stockés avec comme clé leur position (position_x, position_y)
    // Ils ont comme valeur un

    private static HashMap<Position, Temple> coordonneesTemples = new HashMap<>();
    private static HashMap<Position, Cristal> coordonneesCristaux = new HashMap<>();
    private static Joueur joueur;


    public Map(String parNomFichierScenario) throws Exception {

        // On génère la map
        LectureScenario scenario = new LectureScenario(parNomFichierScenario);
        HashSet<Temple> listeTemple = scenario.getTemple();
        HashSet<Cristal> listeCristal = scenario.getCristal();
        System.out.println("--------------------");
        System.out.println("Position des Temples : " + listeTemple);
        System.out.println("position des Cistaux : " + listeCristal);
        joueur = new Joueur(CENTRE_X, CENTRE_Y);


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

        // On affiche le joueur
        ElementsGraphiques.dessinerElement(joueur);


        //-----------------Cristaux et temples-----------------
        for (Temple temple: listeTemple){
            ElementsGraphiques.dessinerElement(temple);
        }

        for (Cristal cristal: listeCristal){
            ElementsGraphiques.dessinerElement(cristal);
        }


            /*for(int i=0; i < 11; i++) {
                for(int j=0; i < 11; i++){
                    for(int k=0; k < 3; k++)
                        if(temples.contains(new Temple(i,j,k))) {
                            graphiqueContext2D.setFill(COULEURS[2]);
                            graphiqueContext2D.fillRect(
                                    i * CARRE + CARRE / 8,
                                    j * CARRE + CARRE / 4,
                                    LARGEUR_OVALE,HAUTEUR_OVALE);
                        }
                }
            }*/
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
}

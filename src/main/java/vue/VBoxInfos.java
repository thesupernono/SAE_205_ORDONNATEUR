package vue;

import interfaces.CONSTANTES_MAP;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Map;
import modele.Historique;
import modele.Position;
import modele.Cristal;

import static interfaces.CONSTANTES_ERREUR.MOUVEMENT_INTERDIT;

/**
 * Box des informations sur le joueur, son historique, pour prendre et poser le cristal
 * ainsi que pour réaliser des parcours
 */
public class VBoxInfos extends VBox implements CONSTANTES_MAP {
    /**
     * Attribut pour vérifier si ce lancement est le premier,
     * afin de savoir si on peut récupérer les ancien éléments
     */
    public static boolean premierLancement = true;
    private static Label nombrePasLabel;
    private static Button peuxPrendreCristal;
    private static Button peuxPoserCristal;
    private static Button boutonParcoursBasique;
    private static Button boutonParcoursHeuristique;
    private static Label possessionLabel;

    private Historique historique = Map.getJoueur().getHistorique();

    /**
     * Constructeur pour pouvoir afficher tous les éléments
     */
    public VBoxInfos(){

        // Initiation des variables
        nombrePasLabel = Map.getJoueur().getLabelPas();
        peuxPrendreCristal = new Button("Prendre le cristal");
        peuxPoserCristal = new Button("Poser le cristal");
        possessionLabel = new Label("Vous n'avez pas de cristal en main");

        boutonParcoursBasique = new Button("Réaliser un parcours basique");
        boutonParcoursHeuristique = new Button("Réaliser un parcours heuristique");

        // Ajout sur la fenêtre

        // affichage
        this.getChildren().add(nombrePasLabel);
        this.getChildren().add(peuxPrendreCristal);
        this.getChildren().add(peuxPoserCristal);
        this.getChildren().add(possessionLabel);
        this.getChildren().add(historique.getTableView());
        this.getChildren().add(boutonParcoursBasique);
        this.getChildren().add(boutonParcoursHeuristique);

        peuxPrendreCristal.setOnAction(HBoxRoot.getControleur());
        peuxPoserCristal.setOnAction(HBoxRoot.getControleur());

        boutonParcoursBasique.setOnAction(HBoxRoot.getControleur());
        boutonParcoursHeuristique.setOnAction(HBoxRoot.getControleur());

        boutonParcoursBasique.setUserData("Tri heuristique");
        boutonParcoursHeuristique.setUserData("Tri basique");
    }

    /**
     * Méthode satic qui permet d'actualiser les boutons
     * pour que le joueur puisse récupérer les cristaux quand il est dessus
     * et pour ne pas qu'on puisse les récupérer si on a changer de case
     * @param positionArrivee : position où l'on est / où l'on va, soit la position qu'il faut prendre
     *                          en compte pour vérifier si il y a bien un cristal, si on peut poser ext
     */
    public static void verifPossession(Position positionArrivee){
        // On les initialise à impossible et on change si c'est possible
        peuxPrendreCristal.setUserData("Impossible");
        peuxPoserCristal.setUserData("Impossible");

        // System.out.println("Vérif Possession lancé !!");
        // System.out.println("--------------------");
        if (Map.getJoueur().getCristalEnMain() != null){
            int numCouleur = Map.getJoueur().getCristalEnMain().getCouleur();
            possessionLabel.setText("Vous avez le cristal " + NOM_COULEURS[numCouleur]);
        }
        else{
            possessionLabel.setText("Vous n'avez pas de cristal en main");
        }

        // On associe les bouttons aux actions
        // On vérifie si il y a un cristal à la position du joueur
        for (Position posCristal: Map.getCoordonneesCristaux().keySet()) {
            if (positionArrivee.equals(posCristal)) {
                // Si il y a un cristal qui est à cette position
                // on le récupère et on l'associe au bouton getCristal

                Cristal cristalIci = Map.getCoordonneesCristaux().get(posCristal);
                peuxPrendreCristal.setUserData(cristalIci);
            }
        }

        // On vérifie si on a un cristal
        if (Map.getJoueur().getCristalEnMain() != null) {
            // On vérifie si on est sur un temple
            for(Position posTemple: Map.getCoordonneesTemples().keySet()){
                if(posTemple.equals(positionArrivee)) {
                    System.out.println("Cristal peut être posé sur le temple");
                    peuxPoserCristal.setUserData(Map.getCoordonneesTemples().get(posTemple));
                }
            }

        }
    }

}

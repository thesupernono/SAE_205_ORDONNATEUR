package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------

    int NOMBRE_CARRE = 15;
    int [] TAILLE_FENETRE = {1280, 720};
    int TAILLE_CARRE = 50;
    int TAILLE_CRISTAL = 30;
    //int [] TAILLE_MAP = {TAILLE_FENETRE[0] - 200, TAILLE_FENETRE[1] - 200};
    int [] TAILLE_MAP = {TAILLE_CARRE *NOMBRE_CARRE, TAILLE_CARRE *NOMBRE_CARRE};
    int CENTRE_X = 13;
    int CENTRE_Y = 5;
    Color COULEUR_GRILLE = Color.BLACK;


    //------------------------Joueur------------------------
    Color [] COULEURS= {
            Color.AQUA,         // Couleur du joueur
            Color.LIGHTGREEN,
            Color.PINK,
            Color.LIGHTGREEN,
            Color.PINK,
            Color.LIGHTGREEN,
            Color.PINK,
            Color.LIGHTGREEN,
            Color.PINK
    };

    int [] POSITION_DEPART = {CENTRE_X, CENTRE_Y};
    int LARGEUR_OVALE = 30;
    int HAUTEUR_OVALE = 30;
    Color COULEUR_DESTINATION = Color.RED;

    int LARGEUR_CIBLE = 25;
    int HAUTEUR_CIBLE = 25;

    String SCENARIO_DEFAUT = "Scenario1.txt";
}

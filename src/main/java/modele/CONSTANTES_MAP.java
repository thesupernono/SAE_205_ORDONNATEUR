package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------

    // carré
    int NOMBRE_CARRE = 30;
    int TAILLE_CARRE = 30;


    // fenetres
    int [] TAILLE_FENETRE = {1280, 720};
    int TAILLE_CRISTAL = TAILLE_CARRE - 10;
    int [] TAILLE_MAP = {TAILLE_CARRE * NOMBRE_CARRE, TAILLE_CARRE * NOMBRE_CARRE};


    // Centre et couleur de la grille
    int CENTRE_X = NOMBRE_CARRE / 2;
    int CENTRE_Y = NOMBRE_CARRE / 2;
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

    int LARGEUR_CIBLE = TAILLE_CARRE;
    int HAUTEUR_CIBLE = TAILLE_CARRE;

    String SCENARIO_DEFAUT = "Scenario1.txt";
}

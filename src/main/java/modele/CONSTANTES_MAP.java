package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------

    // carré
    int NOMBRE_CARRE = 21;
    int TAILLE_CARRE = 20;


    // fenetres
    int [] TAILLE_FENETRE = {1280, 720};
    int TAILLE_CRISTAL = TAILLE_CARRE - 10;
    int [] TAILLE_MAP = {TAILLE_CARRE * NOMBRE_CARRE, TAILLE_CARRE * NOMBRE_CARRE};


    // Centre et couleur de la grille
    int CENTRE_X = NOMBRE_CARRE / 2;
    int CENTRE_Y = NOMBRE_CARRE / 2;
    Color COULEUR_GRILLE = Color.BLACK;



    //------------------------Joueur------------------------
    Color [] COULEURS = {
            Color.AQUA,         // Couleur du joueur
            Color.LIGHTGREEN,
            Color.PINK,
            Color.DARKMAGENTA,
            Color.ORANGE,
            Color.LIGHTGREEN, // Couleurs encore à modifié à partir de celle ci inclu
            Color.PINK,
            Color.LIGHTGREEN,
            Color.PINK
    };

    String [] NOM_COULEURS = {
            "aqua",             // couleur du joueur
            "vert clair",
            "rose",
            "magenta foncé",
            "ORANGE"            // De la même manière, il faut définir les couleurs ici
    };

    int [] POSITION_DEPART = {CENTRE_X, CENTRE_Y};
    Color COULEUR_DESTINATION = Color.RED;
    Color COULEUR_FOND = Color.WHITE;


    String SCENARIO_DEFAUT = "Scenario1.txt";
}

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
            Color.rgb(102, 145, 232, 0.91),         // Couleur du joueur
            Color.rgb(102, 232, 105, 0.91),
            Color.rgb(235, 92, 88, 0.92),
            Color.rgb(255, 255, 0, 1), // ---------------------
            Color.rgb(220, 101, 215, 0.86), // ---------------------
            Color.rgb(101, 57, 161, 0.63), // Couleurs à modifier
            Color.CYAN,
            Color.NAVY,
    };

    String [] NOM_COULEURS = {
            "bleu",             // couleur du joueur
            "vert clair",
            "rouge",
            "jaune",
            "rose",
            "violet",
            "bleu cyan",
            "bleu foncé"
    };

    int [] POSITION_DEPART = {CENTRE_X, CENTRE_Y};
    Color COULEUR_DESTINATION = Color.RED;
    Color COULEUR_FOND = Color.WHITE;


    String SCENARIO_DEFAUT = "Scenario1.txt";
}

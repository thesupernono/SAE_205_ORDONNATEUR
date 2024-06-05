package interfaces;

import javafx.scene.paint.Color;

/**
 * interface des constantes de la map
 */
public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------

    // carré
    /** numbre de carré (la map c'est nombre de carré sur le noombre de carré)     */
    int NOMBRE_CARRE = 31;
    /** taille de chaque carré */
    int TAILLE_CARRE = 20;


    /** taille de la fenetres */
    int [] TAILLE_FENETRE = {1280, 720};
    /** Taille de chaque cristal */
    int TAILLE_CRISTAL = TAILLE_CARRE - 10;
    /** Taille de la map*/
    int [] TAILLE_MAP = {TAILLE_CARRE * NOMBRE_CARRE, TAILLE_CARRE * NOMBRE_CARRE};


    // Centre et couleur de la grille
    /**
     * On cherche le centre sur l'axe X
     */
    int CENTRE_X = NOMBRE_CARRE / 2;
    /**
     * On cherche le centre sur l'axe Y
     */
    int CENTRE_Y = NOMBRE_CARRE / 2;

    /**
     * On défini la couleur des grillage (les bordures des carrés)
     */
    Color COULEUR_GRILLE = Color.BLACK;

    /**
     * On défini la couleur des carrés vide (du fond)
     */
    Color COULEUR_FOND = Color.WHITE;


    //------------------------Couleurs------------------------

    /**
     * Tableau de toutes les couleurs utilisées
     * toutes les couleurs sont pour les couples temples / cristaux
     * sauf la première couleur qui est pour le joueur
     */
    Color [] COULEURS = {
            Color.rgb(102, 145, 232, 0.91),         // Couleur du joueur
            Color.rgb(102, 232, 105, 0.91),
            Color.rgb(235, 92, 88, 0.92),
            Color.rgb(255, 255, 0, 1),
            Color.rgb(220, 101, 215, 0.86),
            Color.rgb(101, 57, 161, 0.63),
            Color.CYAN,
            Color.NAVY,
            Color.BROWN,
            Color.DARKGREY
    };
    /**
     * On reprend le nom de chacune des couleurs afin de pouvoir les aficher à l'utilisateur
     */
    String [] NOM_COULEURS = {
            "bleu",             // couleur du joueur
            "vert clair",
            "rouge",
            "jaune",
            "rose",
            "violet",
            "bleu cyan",
            "bleu foncé",
            "marron",
            "Gris foncé"
    };

    /**
     * On défini le scenario à charger par défaut
     */
    String SCENARIO_DEFAUT = "scenario1.txt";
}

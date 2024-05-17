package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------
    int [] TAILLE_MAP = {1000,500};
    int CENTRE_X = TAILLE_MAP[0]/2;
    int CENTRE_Y = TAILLE_MAP[1]/2;
    Color COULEUR_GRILLE = Color.BLACK;
    int CARRE = 50;

    //------------------------Joueur------------------------
    Color [] COULEURS= {
            Color.AQUA,
            Color.LIGHTGREEN,
            Color.PINK
    };
    int [] POSITION_DEPART = {CENTRE_X, CENTRE_Y};
    int LARGEUR_OVALE = 30;
    int HAUTEUR_OVALE = 30;
    Color COULEUR_DESTINATION = Color.RED;

    int LARGEUR_CIBLE = 25;
    int HAUTEUR_CIBLE = 25;
}

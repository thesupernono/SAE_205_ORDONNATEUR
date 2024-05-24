package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------
    int [] TAILLE_FENETRE = {1280, 720};
    //int [] TAILLE_MAP = {TAILLE_FENETRE[0] - 200, TAILLE_FENETRE[1] - 200};
    int [] TAILLE_MAP = {20, 10};
    int CENTRE_X = 13;
    int CENTRE_Y = 5;
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

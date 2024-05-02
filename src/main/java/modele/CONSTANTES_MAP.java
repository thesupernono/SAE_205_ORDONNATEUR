package modele;

import javafx.scene.paint.Color;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------
    int [] TAILLE_MAP = {26, 26};
    int CENTRE_X = TAILLE_MAP[0]/2;
    int CENTRE_Y = TAILLE_MAP[1]/2;


    //------------------------Joueur------------------------
    Color [] COULEURS= {
            Color.AQUA,
            Color.LIGHTGREEN,
            Color.PINK
    };
    int [] POSITION_DEPART = {CENTRE_X, CENTRE_Y};

}

package modele;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public interface CONSTANTES_MAP {

    //-------------------------Map-------------------------
    final Pair<Integer, Integer> TAILLE_MAP = new Pair<>(26, 26);
    final int CENTRE = TAILLE_MAP.getValue()/2;


    //------------------------Joueur------------------------
    final Color [] COULEURS= {
            Color.AQUA,
            Color.LIGHTGREEN,
            Color.PINK
    };

}

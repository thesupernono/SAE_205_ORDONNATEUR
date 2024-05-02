package modele;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public class Cristal {
    private Pair<Integer,Integer> chPosCristal;
    private Color chCouleur;

    public Cristal(int parPosX, int parPosY, Color parCouleur){
        chPosCristal = new Pair<Integer,Integer>(parPosX,parPosY);
        chCouleur = parCouleur;
    }


}

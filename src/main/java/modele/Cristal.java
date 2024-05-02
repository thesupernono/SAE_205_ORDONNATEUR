package modele;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public class Cristal {
    private Pair<Integer,Integer> chPosCristal;
    private int chCouleur;

    public Cristal(int parPosX, int parPosY, int parCouleur){
        chPosCristal = new Pair<Integer,Integer>(parPosX,parPosY);
        chCouleur = parCouleur;
    }
}

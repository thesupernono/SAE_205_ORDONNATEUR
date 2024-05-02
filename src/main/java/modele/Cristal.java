package modele;

import javafx.util.Pair;

public class Cristal {
    private Pair<Integer,Integer> chPosCristal;
    private int chCouleur;

    public Cristal(int parPosX, int parPosY, int parCouleur){
        chPosCristal = new Pair<>(parPosX,parPosY);
        chCouleur = parCouleur;
    }


    public Pair<Integer, Integer> getPosition() {
        return chPosCristal;
    }


    public int getCouleur() {
        return chCouleur;
    }
}

package modele;

public class Cristal {
    private int [] position;
    private int couleur;

    public Cristal(int parPosX, int parPosY, int parCouleur){
        position = new int[2];
        position[0] = parPosX;
        position[1] = parPosY;
        couleur = parCouleur;
    }


    public int [] getPosition() {
        return position;
    }


    public int getCouleur() {
        return couleur;
    }

    public String toString(){
        return "position : (" + position[0] + "," + position[1] + ") couleur :" + couleur;
    }
}

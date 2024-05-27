package modele;

public class Cristal {
    private Position position;
    private int couleur;

    public Cristal(int parPosX, int parPosY, int parCouleur){
        position = new Position(parPosX, parPosY);
        couleur = parCouleur;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCouleur() {
        return couleur;
    }

    public String toString(){
        return "position : (" + position.getPosX() + "," + position.getPosY() + ") couleur :" + couleur;
    }
}

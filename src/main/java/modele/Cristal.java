package modele;

import exception.ExceptionManquant;
import exception.ExceptionPosition;

public class Cristal {
    private Position position;
    private int couleur;

    public Cristal(int parPosX, int parPosY, int parCouleur){
        position = new Position(parPosX, parPosY);
        couleur = parCouleur;

        // On vérifie si la position et la couleur sont correcte
        ExceptionPosition.VerifierPositionObjet(position, this);
        ExceptionManquant.VerifierCouleurObjet(couleur);
    }

    public Cristal copy(){
        return new Cristal(position.getPosX(), position.getPosY(), couleur);
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

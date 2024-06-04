package modele;

import exception.ExceptionManquant;
import exception.ExceptionPosition;

/**
 * Class cristal qui contient la position et la couleur d'un cristal
 */
public class Cristal {
    private Position position;
    private int couleur;

    /**
     * Constructeur d'un cristal
     * @param parPosX : position en abscise du cristal
     * @param parPosY : position en ordonnée du cristal
     * @param parCouleur : numéro de la couleur du cristal
     */
    public Cristal(int parPosX, int parPosY, int parCouleur){
        position = new Position(parPosX, parPosY);
        couleur = parCouleur;

        // On vérifie si la position et la couleur sont correcte
        ExceptionPosition.VerifierPositionObjet(position, this);
        ExceptionManquant.VerifierCouleurObjet(couleur);
    }

    /**
     * méthode pour copier le cristal, pour éviter que la copie ne se change si on change l'élément d'origine
     * @return une copie de ce cristal
     */
    public Cristal copy(){
        return new Cristal(position.getPosX(), position.getPosY(), couleur);
    }

    /**
     * getter de la position
     * @return la position du cristal
     */
    public Position getPosition() {
        return position;
    }

    /**
     * setter de la position
     * @param position : nouvelle position du cristal
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * getter de la couleur du cristal
     * @return le numéro de la couleur du cristal
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * Méthode toString (principalement pour le débuggage)
     * @return la position et la couleur au format String
     */
    public String toString(){
        return "position : (" + position.getPosX() + "," + position.getPosY() + ") couleur :" + couleur;
    }
}

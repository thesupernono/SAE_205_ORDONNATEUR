package modele;

import static interfaces.CONSTANTES_MAP.CENTRE_X;
import static interfaces.CONSTANTES_MAP.CENTRE_Y;
import static java.lang.Math.abs;

/**
 * Gestion des position dans un objet indépendant
 */
public class Position{
    private int posX;
    private int posY;


    //---------------------Constructeur---------------------

    /**
     * Constructeur d'une position en fonction de son abscisse et de son ordonnée
     * @param parPosX : abscisse
     * @param parPosY : ordonnée
     */
    public Position(int parPosX, int parPosY){
        posX = parPosX;
        posY = parPosY;
    }

    /**
     * Constructeur sans paramètre qui crée automatiquement un élément au centre de la map
     */
    public Position(){
        posX = CENTRE_X;
        posY = CENTRE_Y;

    }


    //---------------------Getter---------------------

    /**
     * Getter sur l'axe abscisse (l'axe X)
     * @return la position sur l'axe abscisse
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Getter sur l'axe ordonnée (l'axe Y)
     * @return la position sur l'axe ordonnée
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Permet de calculer la distance entre deux points
     *
     * @param parArrive position d'arrivé
     * @return la distance calculé
     */
    public int distance(Position parArrive){
        int disEntrePointsX = 0;
        int disEntrePointsY = 0;

        if(this.posX > parArrive.posX) {
            disEntrePointsX = abs(this.posX - parArrive.getPosX());
        }
        else{
            disEntrePointsX = abs(parArrive.getPosX() - this.posX);
        }

        if(this.posY > parArrive.posY) {
            disEntrePointsY = abs(this.getPosY() - parArrive.getPosY());
        }
        else{
            disEntrePointsY = abs(parArrive.getPosY() - this.posY);
        }

        return disEntrePointsX + disEntrePointsY;
    }


    /**
     * Gestion d'un déplacement en fonction de sa direction : Haut (H), Bas (B), Droite (D), Gauche (G)
     * @param direction : H B D G
     */

    public void deplacement(String direction){

        // On récupère la position de départ en créant une nouvelle position pour éviter qu'elle soit affectée par les changements
        Position positionDepart = new Position(Map.getJoueur().getPosition().getPosX(), Map.getJoueur().getPosition().getPosY());
        switch (direction) {

            case "D" :
                posX++;
                break;

            case "G" :
                posX--;
                break;

            case "H" :
                posY--;
                break;

            case "B" :
                posY++;
                break;
        }

        // On reset la position de départ
        ElementsGraphiques.resetGraphique(positionDepart);

        // On reset la position d'arrivée
        ElementsGraphiques.resetGraphique(Map.getJoueur().getPosition());

        Map.getJoueur().ajoutPas();
    }

    /**
     * Méthode pour savoir si deux position sont égales
     * @param posComparee : position à comparé
     * @return un booléen, true si les deux positions sont égales, false sinon
     */
    public boolean equals(Position posComparee) {
        if (posComparee.getPosX() == posX && posComparee.getPosY() == posY)
            return true;
        return false;
    }

    /**
     * Méthode toString pour le débuggage pour voir la position
     * @return la position au format String
     */
    public String toString(){
        return "(" + posX + ", " + posY + ")";
    }
}
package modele;

import static java.lang.Math.abs;

public class Position{
    private int posX;
    private int posY;


    //---------------------Constructeur---------------------
    public Position(int parPosX, int parPosY){
        posX = parPosX;
        posY = parPosY;
    }


    //---------------------Getter---------------------
    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }

    public void setPosX(int parPosX){
        posX = parPosX;
    }

    public void setPosY(int parPosY){
        posY = parPosY;
    }


    // Téléporteur (le temps des tests)
    public void teleporteur(int parPosX, int parPosY){
        posX = parPosX;
        posY = parPosY;
    }

    /**
     * Permet de calculer la distance entre deux points
     *
     * @param parDepart position de départ
     * @param parArrive position d'arrivé
     * @return la distance calculé
     */
    public int distance(Position parDepart, Position parArrive){
        int disEntrePointsX = 0;
        int disEntrePointsY = 0;

        if(parDepart.posX > parArrive.posX) {
            disEntrePointsX = abs(parDepart.posX - parArrive.getPosX());
        }
        else{
            disEntrePointsX = abs(parArrive.getPosX() - parDepart.posX);
        }

        if(parDepart.posY > parArrive.posY) {
            disEntrePointsY = abs(parDepart.getPosY() - parArrive.getPosY());
        }
        else{
            disEntrePointsY = abs(parArrive.getPosY() - parDepart.posY);
        }

        return disEntrePointsX + disEntrePointsY;
    }


    // Changement de direction

    public void deplacement(String direction){

        System.out.println("Déplacement vers " + direction);
        Position positionDepart = Map.getJoueur().getPosition();
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

}
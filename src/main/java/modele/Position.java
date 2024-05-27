package modele;

import vue.VBoxTemple;

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


    // Changement de direction

    public void deplacement(String direction){

        System.out.println("Déplacement vers " + direction);
        Position positionDepart = Map.getJoueur().getPosition();
        switch (direction) {

            case "D" : setPosX(posX++);

            case "G" : posX--;

            case "H" : posY--;

            case "B" : posY++;
        }

        // On reset la position de départ
        ElementsGraphiques.resetGraphique(positionDepart);

        // On reset la position d'arrivée
        ElementsGraphiques.resetGraphique(Map.getJoueur().getPosition());

        Map.getJoueur().ajoutPas();
    }

}
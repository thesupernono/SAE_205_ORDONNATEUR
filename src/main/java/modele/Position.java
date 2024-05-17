package modele;

import vue.VBoxTemple;

public class Position{
    int posX;
    int posY;


    //---------------------Constructeur---------------------
    Position(int parPosX, int parPosY){
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


    // Téléporteur (le temps des tests)
    public void teleporteur(int parPosX, int parPosY){
        posX = parPosX;
        posY = parPosY;
    }


    // Changement de direction

    public void deplacement(String direction){
        switch (direction) {
            case "D" : posX++;

            case "G" : posX--;

            case "H" : posY--;

            case "B" : posY--;
        }

        VBoxTemple.getJoueur().ajoutPas();
    }

}
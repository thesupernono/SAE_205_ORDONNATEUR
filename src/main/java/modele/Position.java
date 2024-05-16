package modele;

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
        if (direction == "droite")
            posX ++;

        else if (direction == "gauche")
            posX --;

        else if(direction == "haut")
            posY --;

        else if(direction == "bas")
            posY --;
    }

}